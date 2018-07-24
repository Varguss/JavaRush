package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectInputStream in;
    private final ObjectOutputStream out;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in =  new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Метод общения сервера с клиентом: передача сообщения клиенту.
     * @param message Сообщение, которое будет отправлено клиенту.
     * @throws IOException При ошибке передачи сообщения.
     */
    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
        }
    }

    /**
     * Метод считывает сообщение клиента.
     * @return Сообщение, полученное от клиента.
     * @throws IOException При ошибке
     * @throws ClassNotFoundException Возникать не должно, если не изменять код, однако требуется при использовании ObjectInputStream.
     */
    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (in) {
            return (Message) in.readObject();
        }
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    /**
     * Метод прерывает соединение между сервером и клиентом.
     * @throws IOException При ошибке закрытия соединения.
     */
    public void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }
}
