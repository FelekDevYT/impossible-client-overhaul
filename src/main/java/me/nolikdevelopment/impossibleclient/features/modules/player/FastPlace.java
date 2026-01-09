package me.nolikdevelopment.impossibleclient.features.modules.player;

import me.nolikdevelopment.impossibleclient.features.modules.Module;
import me.nolikdevelopment.impossibleclient.util.player.PlayerUtil;
import me.nolikdevelopment.impossibleclient.util.traits.Util;
import net.minecraft.world.item.Items;

public class FastPlace extends Module implements Util {
    public FastPlace() {
        super("FastPlace", "Removes delay", Category.PLAYER);
    }

    @Override
    public void onTick() {
        if (nullCheck()) return;
        if (PlayerUtil.getWeaponOffhand().getItem() == Items.END_CRYSTAL) {
            mc.rightClickDelay = 0;
        }
        if (PlayerUtil.getWeaponOffhand().getItem() == Items.EXPERIENCE_BOTTLE) {
            mc.rightClickDelay = 0;
        }
        if (PlayerUtil.getWeaponOffhand().getItem() == Items.OBSIDIAN) {
            mc.rightClickDelay = 0;
        }
    }
}