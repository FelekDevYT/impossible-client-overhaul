package me.alpha432.oyvey.mixin;

import me.alpha432.oyvey.Impossible;
import me.alpha432.oyvey.features.modules.render.NoRender;
import me.alpha432.oyvey.util.traits.Util;
import net.minecraft.client.particle.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleEngine.class)
public class MixinParticleEngine implements Util {
    @Inject(method = "add", at = @At("HEAD"), cancellable = true)
    private void aVoid(Particle particle, CallbackInfo ci) {
        NoRender noRender = Impossible.moduleManager.getModuleByClass(NoRender.class);
        if (noRender.isEnabled()) {
            if (particle instanceof CritParticle) {
                ci.cancel();
            }
        }
    }
}
