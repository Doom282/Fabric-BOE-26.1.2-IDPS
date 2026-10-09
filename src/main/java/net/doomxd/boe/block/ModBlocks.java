package net.doomxd.boe.block;

import net.doomxd.boe.BeyondOnesEyes;
import net.doomxd.boe.block.custom.ElsewhereBlock;
import net.doomxd.boe.worldgen.tree.ModTreeGrowers;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ModBlocks {
    //Still need to add drop-ability

    //WHENEVER YOU ADD A BLOCK OR ITEM ADD IT TO CREATIVE TAB
    public static final Block LESOLITE_ORE = registerBlock("lesolite_ore",
            properties -> new DropExperienceBlock(UniformInt.of(2, 8), properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final Block ELSEWHERE_WOOD_PLANKS = registerBlock("elsewhere_wood_planks",
            properties -> new ElsewhereBlock(properties.strength(1f)
                    .sound(SoundType.WOOD).noOcclusion().ignitedByLava()
                    .isValidSpawn(Blocks::never).isSuffocating(Blocks::never).isViewBlocking(Blocks::never)));

    public static final Block ELSEWHERE_LEAVES = registerBlock("elsewhere_leaves",
            properties -> new ElsewhereBlock(properties.strength(0.1f)
                    .sound(SoundType.CHERRY_LEAVES).noOcclusion().ignitedByLava()
                    .isValidSpawn(Blocks::never).isSuffocating(Blocks::never).isViewBlocking(Blocks::never)));

    public static final Block ELSEWHERE_WOOD = registerBlock("elsewhere_wood",
            properties -> new ElsewhereBlock(properties.strength(1f)
                    .sound(SoundType.WOOD).noOcclusion().ignitedByLava()
                    .isValidSpawn(Blocks::never).isSuffocating(Blocks::never).isViewBlocking(Blocks::never)));

    public static final Block ELSEWHERE_WOOD_SAPLING = registerBlock("elsewhere_wood_sapling",
            properties -> new SaplingBlock(ModTreeGrowers.ELSEWHERE_WOOD, properties.mapColor(MapColor.PLANT)
                    .noOcclusion().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final Block POTTED_ELSEWHERE_WOOD_SAPLING = registerBlockWithoutBlockItem("potted_elsewhere_wood_sapling",
            properties -> new SaplingBlock(ModTreeGrowers.ELSEWHERE_WOOD, properties.mapColor(MapColor.PLANT)
                    .noOcclusion().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));
    /**To add elsehwhere blocks
    add the block here
     add to creative menus below and in ModCreativeModeTabs
     add textures and make them work with datagen in ModModelProvider
     add the block to the list in ModBlockEntities
    **/
    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name)))));
    }

    public static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name), toRegister);
    }

    public static void registerModBlocks()
    {
        BeyondOnesEyes.LOGGER.info("Registering Mod Blocks for " + BeyondOnesEyes.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(output -> {
            output.accept(LESOLITE_ORE);
            output.accept(ELSEWHERE_WOOD_PLANKS);
            output.accept(ELSEWHERE_WOOD);
            output.accept(ELSEWHERE_LEAVES);
            output.accept(ELSEWHERE_WOOD_SAPLING);
        });
    }
}
