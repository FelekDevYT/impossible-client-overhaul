package me.alpha432.oyvey.util.player;

import me.alpha432.oyvey.util.traits.Util;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class PlayerUtil implements Util {
    public static boolean isDead() {
        return mc.player.isDeadOrDying();
    }
    public static boolean isUsingItem() {
        return mc.player.isUsingItem();
    }
    public static boolean isSneaking() {
        return mc.player.isMovingSlowly();
    }
    public static boolean isSprinting() {
        return mc.player.isSprinting();
    }
    public static boolean isGliding() {
        return mc.player.isFallFlying();
    }
    public static Entity getVehicle() {
        return mc.player.getVehicle();
    }
    public static void setSprinting() {
        mc.player.setSprinting(true);
    }
    public static boolean isInvisible() {
        return mc.player.isInvisible();
    }
    public static ItemStack getWeaponOffhand() {
        return mc.player.getWeaponItem();
    }
}
