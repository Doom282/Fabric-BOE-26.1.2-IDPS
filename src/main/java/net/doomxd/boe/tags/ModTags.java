package net.doomxd.boe.tags;

import net.doomxd.boe.BeyondOnesEyes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static TagKey<Block> createTag(String name)
        {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name));
        }
    }
    public static class Items {
        //public static final TagKey<Item> DFDSDS = createTag("sddsasdsd");
        public static final TagKey<Item> ELSEWHERE_WOOD_BLOCKS = createTag("elsewhere_wood_blocks");

        public static TagKey<Item> createTag(String name)
        {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, name));
        }
    }
}
