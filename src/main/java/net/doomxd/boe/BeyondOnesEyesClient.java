package net.doomxd.boe;

import net.doomxd.boe.block.entity.ModBlockEntities;
import net.doomxd.boe.block.entity.renderer.ElsewhereBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class BeyondOnesEyesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(ModBlockEntities.ELSEWORLD_BLOCK_ENTITY_BLOCK_ENTITY_TYPE, ElsewhereBlockEntityRenderer::new);
        //ClientTickEvents.END_CLIENT_TICK.register(BeyondOnesEyesClient::onEndTick);
    }
}
