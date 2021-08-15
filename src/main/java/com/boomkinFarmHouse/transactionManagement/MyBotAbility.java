package com.boomkinFarmHouse.transactionManagement;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.Locality;
import org.telegram.abilitybots.api.objects.Privacy;


public class MyBotAbility extends AbilityBot {

    public static String BOT_TOKEN = "1946338047:AAGD7La5d7EjNNdMEXXNDh8_3Tu-ptPsYH0";
    public static String BOT_USERNAME = "goldNotif_bot";

    public MyBotAbility() {
        super(BOT_TOKEN, BOT_USERNAME);
    }

    @Override
    public long creatorId() {
        return 0;
    }


    public Ability sayHelloWorld() {
        return Ability
                .builder()
                .name("hello")
                .info("says hello world!")
                .locality(Locality.ALL)
                .privacy(Privacy.PUBLIC)
                .action(ctx -> silent.send("Hello world!", ctx.chatId()))
                .build();
    }
}
