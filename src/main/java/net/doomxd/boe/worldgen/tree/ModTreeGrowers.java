package net.doomxd.boe.worldgen.tree;

import net.doomxd.boe.BeyondOnesEyes;
import net.doomxd.boe.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower ELSEWHERE_WOOD = new TreeGrower(BeyondOnesEyes.MOD_ID + ":elsewhere_wood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ELSEWHERE_WOOD_KEY), Optional.empty());
}
