package net.doomxd.boe.block.entity.renderer;

import net.minecraft.client.renderer.block.BlockModelRenderState;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.world.level.Level;

public class ElseworldBlockEntityRenderState extends BlockEntityRenderState {
    public Level level;
    public BlockModelRenderState blockModel = new BlockModelRenderState();
}
