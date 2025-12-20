package me.alpha432.oyvey.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.alpha432.oyvey.Impossible;
import me.alpha432.oyvey.features.modules.player.MultiTask;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Minecraft.class)
public class MixinMinecraftClient {
    // TODO: DONT WORK
    @ModifyExpressionValue(method = "startUseItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/MultiPlayerGameMode;isDestroying()Z"))
    private boolean aVoid(boolean original) {
        MultiTask multiTask = Impossible.moduleManager.getModuleByClass(MultiTask.class);
        if (multiTask.isEnabled()) {
            return false;
        }
        return original;
    }
}
