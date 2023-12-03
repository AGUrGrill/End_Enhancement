package net.agu.endenhancementsmod.datagen;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.item.ModItems;
import net.agu.endenhancementsmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider
{
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, AGUEndMod.MODID);
    }

    @Override
    protected void start() {
        add("endrix_template_from_end_city", new AddItemModifier(new LootItemCondition[] {
            new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build(),
                LootItemRandomChanceCondition.randomChance(0.05f).build(), },
                ModItems.ENDRIX_UPGRADE_SMITHING_TEMPLATE.get()));
    }
}
