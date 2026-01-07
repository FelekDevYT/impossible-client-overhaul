package me.alpha432.oyvey.features.modules.hud;


import me.alpha432.oyvey.Impossible;
import me.alpha432.oyvey.event.impl.Render2DEvent;
import me.alpha432.oyvey.features.modules.client.HudModule;
import me.alpha432.oyvey.manager.ServerManager;

public class Ping extends HudModule {
    public Ping() {
        super("Ping", "Show player ping", 20, 20);
    }
    @Override
    protected void render(Render2DEvent event) {
        super.render(event);
        if (nullCheck()) return;
        String str = "Ping " + Impossible.serverManager.getPing();
        event.getContext().drawString(mc.font, str, (int) getX(), (int) getY(), -1);
        setWidth(mc.font.width(str));
        setHeight(mc.font.lineHeight);
    }
}
