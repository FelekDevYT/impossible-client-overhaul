package me.nolikdevelopment.impossibleclient.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.nolikdevelopment.impossibleclient.Impossible;
import me.nolikdevelopment.impossibleclient.features.modules.render.FullBright;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LightTexture.class)
public class MixinLightTexture {
    @ModifyExpressionValue(method = "updateLightTexture", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;getDarkenWorldAmount(F)F"))
    private float aVoid(float original) {
        FullBright fullBright = Impossible.moduleManager.getModuleByClass(FullBright.class);
        if (fullBright.isEnabled()) {
            return -9999999f;
        }
        return original;
    }
}
