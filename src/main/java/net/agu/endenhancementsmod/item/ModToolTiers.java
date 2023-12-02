package net.agu.endenhancementsmod.item;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers
{
    public static final Tier IMPERIUM = TierSortingRegistry.registerTier(
          new ForgeTier(5, 2971, 10.0f, 4f, 25,
                  ModTags.Blocks.NEEDS_IMPERIUM_TOOL, () -> Ingredient.of(ModItems.IMPERIUM_INGOT.get())),
            new ResourceLocation(AGUEndMod.MODID, "imperium_ingot"), List.of(Tiers.NETHERITE), List.of());
}
