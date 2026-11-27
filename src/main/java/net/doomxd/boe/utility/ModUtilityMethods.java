package net.doomxd.boe.utility;

import net.doomxd.boe.effect.ModEffects;
import net.doomxd.boe.timer.ModAddEffectTimer;
import net.doomxd.boe.timer.ModRemoveEffectTimer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class ModUtilityMethods {

    public static void fade(LivingEntity player)
    {
        MobEffectInstance woozy = new MobEffectInstance(MobEffects.DARKNESS, 60, 12, false, false);
        MobEffectInstance blind = new MobEffectInstance(MobEffects.BLINDNESS, 10, 20, false, false);
        MobEffectInstance see = new MobEffectInstance(ModEffects.OPENED_EYES, 3600, 0, true, true);
        ModAddEffectTimer INSTANCE2 = new ModAddEffectTimer();


        player.addEffect(woozy);
        ModAddEffectTimer.INSTANCE.addEffectTimer(10, blind, player);
        ModAddEffectTimer.INSTANCE.addEffectTimer(30, see, player);
    }
    public static void fadeSickly(LivingEntity player)
    {
        MobEffectInstance woozy = new MobEffectInstance(MobEffects.DARKNESS, 60, 12, false, false);
        MobEffectInstance blind = new MobEffectInstance(MobEffects.BLINDNESS, 10, 20, false, false);
        MobEffectInstance see = new MobEffectInstance(ModEffects.OPENED_EYES, 3600, 0, true, true);
        MobEffectInstance sick = new MobEffectInstance(MobEffects.NAUSEA, 80, 0, false, false);

        ModAddEffectTimer INSTANCE2 = new ModAddEffectTimer();


        player.addEffect(woozy);
        player.addEffect(sick);
        ModAddEffectTimer.INSTANCE.addEffectTimer(10, blind, player);
        ModAddEffectTimer.INSTANCE.addEffectTimer(30, see, player);

    }
    public static void fadeOut(LivingEntity player)
    {
        MobEffectInstance woozy = new MobEffectInstance(MobEffects.DARKNESS, 60, 12, false, false);
        MobEffectInstance blind = new MobEffectInstance(MobEffects.BLINDNESS, 10, 20, false, false);
        MobEffectInstance see = new MobEffectInstance(ModEffects.OPENED_EYES, 3600, 0, true, true);
        MobEffectInstance slow = new MobEffectInstance(MobEffects.SLOWNESS, 60, 0, false, false);
        player.addEffect(woozy);
        ModAddEffectTimer.INSTANCE.addEffectTimer(10, blind, player);
        ModRemoveEffectTimer.INSTANCE.removeEffectTimer(30, see, player);
        ModAddEffectTimer.INSTANCE.addEffectTimer(31, slow, player);
    }
    public static void fadeWithout(LivingEntity player)
    {
        MobEffectInstance woozy = new MobEffectInstance(MobEffects.DARKNESS, 60, 12, false, false);
        MobEffectInstance blind = new MobEffectInstance(MobEffects.BLINDNESS, 10, 20, false, false);



        player.addEffect(woozy);
        ModAddEffectTimer.INSTANCE.addEffectTimer(10, blind, player);
    }
}
