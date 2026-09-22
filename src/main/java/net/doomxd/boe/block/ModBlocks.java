package net.doomxd.boe.block;

import net.doomxd.boe.BeyondOnesEyes;
import net.doomxd.boe.block.custom.ElsewhereBlock;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {
    //Still need to add drop-ability

    //WHENEVER YOU ADD A BLOCK OR ITEM ADD IT TO CREATIVE TAB
    public static final Block LESOLITE_ORE = registerBlock("lesolite_ore",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block ELSEWHERE_WOOD_PLANKS = registerBlock("elsewhere_wood_planks",
            properties -> new ElsewhereBlock(properties.strength(1f)
                    .requiresCorrectToolForDrops().sound(SoundType.WOOD).noOcclusion()));
    //ADD NO OCCLUSION TO ALL ELSEWHERE BLOCKS


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
        });
    }
}
