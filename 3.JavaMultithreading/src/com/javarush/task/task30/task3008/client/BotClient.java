package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    private static final String DATE_FORMAT = "d.MM.YYYY";
    private static final String DAY_FORMAT = "d";
    private static final String MONTH_FORMAT = "MMMM";
    private static final String YEAR_FORMAT = "YYYY";
    private static final String TIME_FORMAT = "H:mm:ss";
    private static final String HOUR_FORMAT = "H";
    private static final String MINUTES_FORMAT = "m";
    private static final String SECONDS_FORMAT = "s";

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");

            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);

            String[] parts = message.split(":");

            if(parts.length != 2)
                return;

            String userName = parts[0];

            SimpleDateFormat format = new SimpleDateFormat();

            switch(parts[1].trim()) {
                case "дата": {
                    format.applyPattern(DATE_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
                case "день": {
                    format.applyPattern(DAY_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
                case "месяц": {
                    format.applyPattern(MONTH_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
                case "год": {
                    format.applyPattern(YEAR_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
                case "время": {
                    format.applyPattern(TIME_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
                case "час": {
                    format.applyPattern(HOUR_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
                case "минуты": {
                    format.applyPattern(MINUTES_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
                case "секунды": {
                    format.applyPattern(SECONDS_FORMAT);
                    sendTextMessage(String.format("Информация для %s: %s", parts[0], format.format(Calendar.getInstance().getTime())));
                } break;
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + ((int) (Math.random() * 100));
    }
}
