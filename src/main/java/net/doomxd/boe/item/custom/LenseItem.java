package net.doomxd.boe.item.custom;

import net.doomxd.boe.effect.ModEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class LenseItem extends Item {
    MobEffectInstance see;
    //MobEffectInstance nyoom;
    MobEffectInstance woo;
    public LenseItem(Properties properties, int tier) {
        super(properties);
        see = new MobEffectInstance(ModEffects.OPENED_EYES, 5, tier, true, false);
        woo = new MobEffectInstance(MobEffects.NAUSEA, 60, 30, true, false);
        //nyoom = new MobEffectInstance(MobEffects.SPEED, 3, 30, true, false);
    }
    public int getUseDuration(final ItemStack itemStack, final LivingEntity user) {
        return 1200;
    }

    public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
        player.awardStat(Stats.ITEM_USED.get(this));
        player.addEffect(woo);
        return ItemUtils.startUsingInstantly(level, player, hand);

    }

    public ItemStack finishUsingItem(final ItemStack itemStack, final Level level, final LivingEntity entity) {
        this.stopUsing(entity);
        entity.addEffect(see);
        //entity.addEffect(nyoom);
        return itemStack;
    }

    public boolean releaseUsing(final ItemStack itemStack, final Level level, final LivingEntity entity, final int remainingTime) {
        this.stopUsing(entity);
        entity.addEffect(see);
        return true;
    }

    private void stopUsing(final LivingEntity entity) {
        entity.addEffect(see);
        //entity.addEffect(nyoom);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int ticksRemaining) {
        livingEntity.addEffect(see);
        //livingEntity.addEffect(nyoom);
    }
}
