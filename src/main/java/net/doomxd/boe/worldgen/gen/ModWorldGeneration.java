package net.doomxd.boe.worldgen.gen;

import net.doomxd.boe.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        /* UNDERGROUND ORES */

        // Example for individual Biomes
        // BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.DEEP_OCEAN, Biomes.BADLANDS),
        //         GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.OVERWORLD_FLUORITE_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS, Biomes.MEADOW, Biomes.STONY_PEAKS, Biomes.STONY_SHORE),
                GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.ELSEWOOD_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.excludeByKey(Biomes.DEEP_DARK), GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.OVERWORLD_LESOLITE_ORE_PLACED_KEY);
    }
}