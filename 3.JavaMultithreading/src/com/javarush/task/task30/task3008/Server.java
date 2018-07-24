package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import static com.javarush.task.task30.task3008.ConsoleHelper.writeMessage;

public class Server {
    private static final Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    public static void main(String[] args) throws IOException {
        writeMessage("Enter port of server.");
        int port = ConsoleHelper.readInt();

        ServerSocket serverSocket = new ServerSocket(port);

        writeMessage("Server is started.");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            } catch (Exception e) {
                serverSocket.close();
                break;
            }
        }
    }

    /**
     * Отправляет всем пользователям сообщение.
     *
     * @param message Сообщение.
     */
    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                writeMessage("Не удалось отправить сообщение пользователю " + entry.getKey());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            writeMessage("Установлено соединение с удаленным сервером " + socket.getRemoteSocketAddress());

            Connection connection = null;
            String userName = null;

            try {
                connection = new Connection(socket);

                userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                sendListOfUsers(connection, userName);

                serverMainLoop(connection, userName);
            } catch (Exception e) {
                writeMessage("Произошла ошибка при обмене данными с удаленным адресом " + socket.getRemoteSocketAddress());

                if (connection != null)
                    try {
                        connection.close();
                    } catch (IOException exception) {
                        writeMessage("Ошибка закрытия соединения с " + connection.getRemoteSocketAddress());
                        exception.printStackTrace();
                    }

                return;
            }

            connectionMap.remove(userName);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            writeMessage("Соединение с удаленным адрессом " + connection.getRemoteSocketAddress() + " закрыто.");
        }

        /**
         * Процедура "рукопожатия" между сервером и клиентом: запрос имени у клиента для его подключения к серверу.
         *
         * @param connection Соединение между клиентом и сервером.
         * @return Имя нового пользователя.
         * @throws IOException            При ошибке принятия или отправки сообщения.
         * @throws ClassNotFoundException Не должно быть без изменения кода, однако требуется из-за ObjectInputStream.
         */
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();

                if ((answer.getType() == MessageType.USER_NAME) && (!answer.getData().isEmpty()) && (!connectionMap.containsKey(answer.getData()))) {
                    connection.send(new Message(MessageType.NAME_ACCEPTED));

                    connectionMap.putIfAbsent(answer.getData(), connection);

                    //connection.send(new Message(MessageType.USER_ADDED));

                    return answer.getData();
                }
            }
        }

        /**
         * Отправка списка всех активных пользователей новому клиенту.
         *
         * @param connection Соединение с клиентом.
         * @param userName   Имя клиента.
         * @throws IOException При ошибке отправки.
         */
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet())
                if (!entry.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message income = connection.receive();
                if (income.getType() == MessageType.TEXT) {
                    Message text = new Message(MessageType.TEXT, userName + ": " + income.getData());
                    sendBroadcastMessage(text);
                } else {
                    writeMessage("Неправильный тип сообщения от пользователя " + userName);
                }
            }
        }
    }
}
