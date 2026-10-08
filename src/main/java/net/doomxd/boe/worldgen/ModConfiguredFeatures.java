package net.doomxd.boe.worldgen;

import net.doomxd.boe.BeyondOnesEyes;
import net.doomxd.boe.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ELSEWHERE_WOOD_KEY = registerKey("elsewhere_wood_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LESOLITE_ORE = registerKey("overworld_lesolite_ore");
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreConfiguration.TargetBlockState> oreGoldTargetList = List.of(OreConfiguration.target(deepslateReplaceables, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState()));

        register(context, OVERWORLD_LESOLITE_ORE, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(deepslateReplaceables, ModBlocks.LESOLITE_ORE.defaultBlockState())), 9
                ));




        register(context, ELSEWHERE_WOOD_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                //new ForkingTrunkPlacer(3, 3, 4),

                BlockStateProvider.simple(ModBlocks.ELSEWHERE_WOOD),
                new CherryTrunkPlacer(7, 1, 0, new WeightedListInt(
                        WeightedList.<IntProvider>builder().add(ConstantInt.of(1),
                                        1).add(ConstantInt.of(2),1)
                                .add(ConstantInt.of(3),1).build()
                ), UniformInt.of(2, 4),
                        UniformInt.of(-4, -3), UniformInt.of(-1, 0)),

                BlockStateProvider.simple(ModBlocks.ELSEWHERE_LEAVES),
                new CherryFoliagePlacer(ConstantInt.of(3),
                        ConstantInt.of(0), ConstantInt.of(5),
                        0.25F, 0.5F,
                        0.16666667F, 0.33333334F),
                //new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),

                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}