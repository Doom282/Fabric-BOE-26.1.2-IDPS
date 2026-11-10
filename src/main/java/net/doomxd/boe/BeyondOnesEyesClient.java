package net.doomxd.boe;

import net.doomxd.boe.block.entity.ModBlockEntities;
import net.doomxd.boe.block.entity.renderer.ElsewhereBlockEntityRenderer;
import net.doomxd.boe.block.entity.renderer.InvertedElsewhereBlockEntityRenderer;
import net.doomxd.boe.effect.ModEffects;
import net.doomxd.boe.keymapping.ModKeyMappings;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.effect.MobEffectInstance;

public class BeyondOnesEyesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(ModBlockEntities.ELSEWORLD_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, ElsewhereBlockEntityRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.INVERTED_ELSEWORLD_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, InvertedElsewhereBlockEntityRenderer::new);
        ModKeyMappings.register();
        ClientTickEvents.END_CLIENT_TICK.register(BeyondOnesEyesClient::onEndTick);
    }

    public static void onEndTick(Minecraft client)
    {
        while(ModKeyMappings.ACTIVATE_LENSES.consumeClick())
        {
                //net.minecraft.world.effect.MobEffectInstance see = new MobEffectInstance(ModEffects.OPENED_EYES, 400, 0, true, true);
                //client.player.addEffect(see);
        }
    }
}
