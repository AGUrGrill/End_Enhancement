package net.agu.endenhancementsmod.worldgen;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ENDRIX_ORE_KEY = registerKey("endrix_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest endStoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        /* Overworld
        List<OreConfiguration.TargetBlockState> endEndrixOre = List.of(OreConfiguration.target(endStoneReplaceables,
                ModBlocks.ENDRIX_ORE.get().defaultBlockState()));
        */

        register(context, END_ENDRIX_ORE_KEY, Feature.ORE, new OreConfiguration(endStoneReplaceables,
                ModBlocks.ENDRIX_ORE.get().defaultBlockState(), 3));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(AGUEndMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration,
            F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                 ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
