package net.doomxd.boe.item.custom;

import net.doomxd.boe.effect.ModEffects;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
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
    public static final int USE_DURATION = 1200;
    public static final float ZOOM_FOV_MODIFIER = 0.1F;
    public LenseItem(Properties properties, int tier) {
        super(properties);
        see = new MobEffectInstance(ModEffects.OPENED_EYES, 5, tier, true, false);
    }
    public int getUseDuration(final ItemStack itemStack, final LivingEntity user) {
        return 1200;
    }

    public InteractionResult use(final Level level, final Player player, final InteractionHand hand) {
        player.awardStat(Stats.ITEM_USED.get(this));
        return ItemUtils.startUsingInstantly(level, player, hand);

    }

    public ItemStack finishUsingItem(final ItemStack itemStack, final Level level, final LivingEntity entity) {
        this.stopUsing(entity);
        entity.addEffect(see);
        return itemStack;
    }

    public boolean releaseUsing(final ItemStack itemStack, final Level level, final LivingEntity entity, final int remainingTime) {
        this.stopUsing(entity);
        entity.addEffect(see);
        return true;
    }

    private void stopUsing(final LivingEntity entity) {
        entity.playSound(SoundEvents.SPYGLASS_STOP_USING, 1.0F, 1.0F);
        entity.addEffect(see);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack itemStack, int ticksRemaining) {
        livingEntity.addEffect(see);
    }
}
