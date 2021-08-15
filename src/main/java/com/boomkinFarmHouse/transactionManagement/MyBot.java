package com.boomkinFarmHouse.transactionManagement;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class MyBot extends TelegramLongPollingBot  {

    @Override
    public String getBotUsername() {
        return "goldNotif_bot";
    }

    @Override
    public String getBotToken() {
        return "1946338047:AAGD7La5d7EjNNdMEXXNDh8_3Tu-ptPsYH0";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText("hello user ");
            log.info("chat id : {}", update.getMessage().getChatId() );
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
