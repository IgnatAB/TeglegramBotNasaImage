import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.awt.*;

public class MyNasaBot extends TelegramLongPollingBot {
    private final String BOT_NAME;
    private final String BOT_TOKEN;
    private final String url = "https://api.nasa.gov/planetary/apod" +
            "?api_key=PlBwupr36pDhD31oXdScZrnh43yxCEpf5J3TtlC3";

    public MyNasaBot(String BOT_NAME, String BOT_TOKEN) throws TelegramApiException {
        this.BOT_NAME = BOT_NAME;
        this.BOT_TOKEN = BOT_TOKEN;
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        // TODO
        if (update.hasMessage() && update.getMessage().hasText()) {
             long chatId = update.getMessage().getChatId();
             String answer = update.getMessage().getText();
             String[] separatedAnswer = answer.split(" ");
             String action = separatedAnswer[0];
             switch (action) {
                 case "/start":
                     sendMessage("Я бот НАСА, я присылаю картинку дня. Известные команды: /start , /help, /image, /date YYYY-MM-DD", chatId);
                     break;
                 case "/help":
                     sendMessage("Введите команду /image для получения сегодняшней картинки дня.\n", chatId);
                     sendMessage("Введите команду /date YYYY-MM-DD для получения картинки дня за это число", chatId);
                     break;
                 case "/image":
                      String image = Utils.getImageUrl(url);
                      sendMessage(image, chatId);
                     break;
                 case "/date":
                      image = Utils.getImageUrl(url + "&date=" + separatedAnswer[1]);
                     sendMessage(image, chatId);
                     //sendMessage("Введите дату в формате ГГГГ-ММ-ЧЧ", chatId);
                     break;
                 default:
                     sendMessage("Неизвестная команда!", chatId);


             }

            }
        }


    private void sendMessage(String text, long chatId) {
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {
        // TODO
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        // TODO
        return BOT_TOKEN;
    }
}


