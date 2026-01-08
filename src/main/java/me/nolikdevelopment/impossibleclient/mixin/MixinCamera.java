package me.nolikdevelopment.impossibleclient.mixin;

import me.nolikdevelopment.impossibleclient.Impossible;
import me.nolikdevelopment.impossibleclient.features.modules.render.ViewClip;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Camera.class)
public abstract class MixinCamera {
    @Shadow
    protected abstract float getMaxZoom(float f);

    @Redirect(method = "setup", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;getMaxZoom(F)F"))
    private float redirectGetMaxZoom(Camera instance, float distance) {
        ViewClip viewClip = Impossible.moduleManager.getModuleByClass(ViewClip.class);

        if (viewClip != null && viewClip.isEnabled()) {
            return distance;
        }

        return this.getMaxZoom(distance);
    }
}
