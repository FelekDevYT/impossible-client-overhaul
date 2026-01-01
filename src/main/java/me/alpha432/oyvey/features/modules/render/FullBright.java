package me.alpha432.oyvey.features.modules.render;

import me.alpha432.oyvey.event.system.Subscribe;
import me.alpha432.oyvey.features.modules.Module;
import me.alpha432.oyvey.features.settings.Setting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.awt.*;

public class FullBright extends Module {
    public Setting<Color> color = color("Color", 255, 0, 0, 255);
    public FullBright() {
        super("FullBright", "", Category.RENDER);
    }
    @Subscribe public void onTick() {
        if (!mc.player.hasEffect(MobEffects.NIGHT_VISION)) {
            mc.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 999999999));
        }
    }
}
