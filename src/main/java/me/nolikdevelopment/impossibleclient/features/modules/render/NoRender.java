package me.nolikdevelopment.impossibleclient.features.modules.render;

import me.nolikdevelopment.impossibleclient.features.modules.Module;
import me.nolikdevelopment.impossibleclient.features.settings.Setting;


public class NoRender extends Module {
    public Setting<Boolean> fireOverlay = bool("Fire", false);
    public Setting<Boolean> noFog = bool("Fog", false);
    public Setting<Boolean> bossBar = bool("BossBar", false);
    public Setting<Boolean> scoreboard = bool("Scoreboard", false);
    public Setting<Boolean> portalOverlay = bool("Portal", false);
    public Setting<Boolean> potionEffects = bool("PotionEffect", false);

    public NoRender() {
        super("NoRender", "Disables rendering of certain elements", Category.RENDER);
    }
}
