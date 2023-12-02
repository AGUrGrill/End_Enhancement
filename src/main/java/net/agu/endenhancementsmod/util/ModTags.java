package net.agu.endenhancementsmod.util;

import net.agu.endenhancementsmod.AGUEndMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags
{
    public static class Blocks {
        public static final TagKey<Block> NEEDS_IMPERIUM_TOOL = tag("needs_imperium_tool");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(AGUEndMod.MODID, name));
        }
    }
}
