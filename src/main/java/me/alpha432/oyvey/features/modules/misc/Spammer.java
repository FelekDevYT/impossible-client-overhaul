package me.alpha432.oyvey.features.modules.misc;

import me.alpha432.oyvey.event.system.Subscribe;
import me.alpha432.oyvey.features.commands.Command;
import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;
import me.alpha432.oyvey.util.StringUtils;
import me.alpha432.oyvey.util.models.Timer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Spammer extends Module {
    public Setting<Integer> delay = num("Delay", 20, 1, 500);
    public Setting<String> fileName = str("Filename", "spammer.txt");
    public Setting<Boolean> antiSpam = bool("AntiSpam", false);

    Timer timer = new Timer();
    private String messageToSend = "";

    public Spammer() {
        super("Spammer", "Spamming messages in the chat.", Category.MISC);
    }

    @Override
    public void onEnable() {
        timer.reset();
        prepareMessage();
    }

    @Override
    public void onDisable() {
        timer.reset();
        messageToSend = "";
    }

    @Subscribe
    public void onTick() {
        if (messageToSend == null || messageToSend.isEmpty()) {
            return;
        }
        if (timer.passedS(delay.getValue())) {
            String msg = messageToSend;

            if (antiSpam.getValue()) {
                msg += " | " + StringUtils.generateRandomString(4);
            }
            mc.getConnection().sendChat(msg.toString());
            timer.reset();
        }
    }

    private void prepareMessage() {
        try {
            File folder = new File("oyvey", "spammer");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            Path path = Paths.get("oyvey/spammer/" + fileName.getValue());
            if (!Files.exists(path)) {
                Command.sendMessage("{red}Файл " + path.toString() + " не найден!");
                disable();
                return;
            }

            String content = Files.readString(path);

            if (content.isEmpty()) {
                Command.sendMessage("{yellow}В файле " + path.toString() + " нету текста!");
                disable();
                return;
            }

            messageToSend = content;
            Command.sendMessage("{green}Spammer включен в режиме файла.");
        } catch (IOException e) {
            Command.sendMessage("{red}Сторонняя ошибка: " + e.getMessage());//Не должно, но пусть будет
            e.printStackTrace();
            disable();
        }
    }
}