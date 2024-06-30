package net.agu.endenhancementsmod.datagen;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.block.ModBlocks;
import net.agu.endenhancementsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static final List<ItemLike> ENDRIX_SMELTABLES = List.of(ModBlocks.ENDRIX_ORE.get());
    public ModRecipeProvider(PackOutput pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter)
    {
        oreBlasting(pWriter, ENDRIX_SMELTABLES, RecipeCategory.MISC, ModItems.ENDRIX_NUGGET.get(), 0.5f, 200, "endrix_nuggets");
        oreSmelting(pWriter, ENDRIX_SMELTABLES, RecipeCategory.MISC, ModItems.ENDRIX_NUGGET.get(), 0.5f, 400, "endrix_nuggets");

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHORUS_FRUIT_YOGURT.get())
                .pattern(" C ")
                .pattern("CMC")
                .pattern(" B ")
                .define('B', Items.BOWL)
                .define('M', Items.MILK_BUCKET)
                .define('C', Items.CHORUS_FRUIT)
                .unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.MILK_BUCKET))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IMPERIUM_INGOT.get())
                .pattern("EEE")
                .pattern("ESE")
                .pattern("EEE")
                .define('E', ModItems.ENDRIX_NUGGET.get())
                .define('S', Items.NETHER_STAR)
                .unlockedBy(getHasName(ModItems.IMPERIUM_INGOT.get()), has(ModItems.IMPERIUM_INGOT.get()))
                .save(pWriter);
        /*
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IMPERIUM_INGOT.get(), 9)
                .requires(ModBlocks.ENDRIX_ORE.get())
                .unlockedBy(getHasName(ModItems.IMPERIUM_INGOT.get()), has(ModItems.IMPERIUM_INGOT.get()))
                .save(pWriter);
        */
        imperiumSmithing(pWriter, Items.NETHERITE_SWORD, RecipeCategory.TOOLS, ModItems.IMPERIUM_SWORD.get());
        imperiumSmithing(pWriter, Items.NETHERITE_PICKAXE, RecipeCategory.TOOLS, ModItems.IMPERIUM_PICKAXE.get());
        imperiumSmithing(pWriter, Items.NETHERITE_AXE, RecipeCategory.TOOLS, ModItems.IMPERIUM_AXE.get());
        imperiumSmithing(pWriter, Items.NETHERITE_SHOVEL, RecipeCategory.TOOLS, ModItems.IMPERIUM_SHOVEL.get());
        imperiumSmithing(pWriter, Items.NETHERITE_HOE, RecipeCategory.TOOLS, ModItems.IMPERIUM_HOE.get());

        imperiumSmithing(pWriter, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, ModItems.ENDRIX_HELMET.get());
        imperiumSmithing(pWriter, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, ModItems.ENDRIX_CHESTPLATE.get());
        imperiumSmithing(pWriter, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, ModItems.ENDRIX_LEGGINGS.get());
        imperiumSmithing(pWriter, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, ModItems.ENDRIX_BOOTS.get());
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, AGUEndMod.MODID + ":" +getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
    protected static void imperiumSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.ENDRIX_UPGRADE_SMITHING_TEMPLATE.get()),
                Ingredient.of(pIngredientItem), Ingredient.of(ModItems.IMPERIUM_INGOT.get()), pCategory, pResultItem)
                .unlocks("has_netherite_ingot", has(ModItems.IMPERIUM_INGOT.get()))
                .save(pFinishedRecipeConsumer, AGUEndMod.MODID + ":" + getItemName(pResultItem) + "_smithing");
    }
}
