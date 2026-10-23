package net.doomxd.boe.effect;

import net.doomxd.boe.BeyondOnesEyes;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;

public class ModEffects {
    public static final Holder<MobEffect> OPENED_EYES = registerMobEffect("opened_eyes",
            new OpenedEyesEffect(MobEffectCategory.NEUTRAL, 13458603));

    private static Holder<MobEffect> registerMobEffect(String name, MobEffect effect)
    {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name), effect);
    }

    public static void registerEffects()
    {
        BeyondOnesEyes.LOGGER.info("Registering potion effects for " + BeyondOnesEyes.MOD_ID);

    }
}
