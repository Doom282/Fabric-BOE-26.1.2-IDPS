package net.doomxd.boe.creativemodetab;

import net.doomxd.boe.BeyondOnesEyes;
import net.doomxd.boe.block.ModBlocks;
import net.doomxd.boe.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTabs {
    public static final CreativeModeTab BOE_ITEMS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, "boe_items"),
    FabricCreativeModeTab.builder().icon(()-> new ItemStack(ModItems.LESOLITE))
            .title(Component.translatable("creativemodetab.beyond_ones_eyes.boe_items"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.LESOLITE);
                output.accept(ModItems.LESOLITE_POOR_LENS);
                output.accept(ModBlocks.LESOLITE_ORE);
            }).build());

    public static void registerModCreativeModeTabs()
    {
        BeyondOnesEyes.LOGGER.info("Registering creative mode tabs for " + BeyondOnesEyes.MOD_ID);
    }
}
