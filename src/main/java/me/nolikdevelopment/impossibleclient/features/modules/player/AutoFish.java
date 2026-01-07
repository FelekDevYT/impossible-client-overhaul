package me.nolikdevelopment.impossibleclient.features.modules.player;

import me.nolikdevelopment.impossibleclient.event.impl.PacketEvent;
import me.nolikdevelopment.impossibleclient.event.system.Subscribe;
import me.nolikdevelopment.impossibleclient.features.modules.Module;
import me.nolikdevelopment.impossibleclient.util.models.Timer;
import me.nolikdevelopment.impossibleclient.util.player.PlayerUtil;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Items;

public class AutoFish extends Module {
    private Timer timer = new Timer();
    private boolean isCasted;

    public AutoFish() {
        super("AutoFish", "Automatically fishing", Category.PLAYER);
    }

    @Subscribe
    public void onPacket(PacketEvent.Receive event) {
        if (event.getPacket() instanceof ClientboundSoundPacket packet) {
            if (packet.getSound().value() == SoundEvents.FISHING_BOBBER_SPLASH) {
                mc.gameMode.useItem(mc.player, InteractionHand.MAIN_HAND);
                mc.player.swing(InteractionHand.MAIN_HAND);
                isCasted = true;
                timer.reset();
            }
        }
    }
    @Subscribe public void onTick() {
        if (isCasted && timer.passedS(5)) {
            mc.gameMode.useItem(mc.player, InteractionHand.MAIN_HAND);
            mc.player.swing(InteractionHand.MAIN_HAND);
            isCasted = false;
        }
    }
    @Subscribe public void onEnable() {
        if (PlayerUtil.getWeaponOffhand().getItem() == Items.FISHING_ROD) {
            mc.gameMode.useItem(mc.player, InteractionHand.MAIN_HAND);
            mc.player.swing(InteractionHand.MAIN_HAND);
        }
    }
}