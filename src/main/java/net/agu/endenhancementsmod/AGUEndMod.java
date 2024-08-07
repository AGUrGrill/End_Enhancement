package net.agu.endenhancementsmod;

import com.mojang.logging.LogUtils;
import net.agu.endenhancementsmod.block.ModBlocks;
import net.agu.endenhancementsmod.effects.ModEffects;
import net.agu.endenhancementsmod.event.ModEvents;
import net.agu.endenhancementsmod.item.ModCreativeModTabs;
import net.agu.endenhancementsmod.item.ModItems;
import net.agu.endenhancementsmod.loot.ModLootModifiers;
import net.agu.endenhancementsmod.networking.ModNetworking;
import net.agu.endenhancementsmod.potion.ModPotions;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.function.Supplier;

@Mod(AGUEndMod.MODID)
public class AGUEndMod
{
    public static final String MODID = "aguendmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AGUEndMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModCreativeModTabs.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(new ModEvents());
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        ModLootModifiers.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        ModNetworking.register();

        // VOID RESISTANCE POTION
        Ingredient input = Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION,1), Potions.AWKWARD));
        Ingredient ingredient = Ingredient.of(Items.POPPED_CHORUS_FRUIT);
        ItemStack output = PotionUtils.setPotion(new ItemStack(Items.POTION,1), ModPotions.VOID_RESISTANCE_POTION.get());
        BrewingRecipeRegistry.addRecipe(input, ingredient, output);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.IMPERIUM_INGOT);
            event.accept(ModItems.ENDRIX_NUGGET);
            event.accept(ModItems.ENDRIX_UPGRADE_SMITHING_TEMPLATE);
        }
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.ENDRIX_ORE);
        }
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            event.accept(ModItems.IMPERIUM_PICKAXE);
            event.accept(ModItems.IMPERIUM_AXE);
            event.accept(ModItems.IMPERIUM_SHOVEL);
            event.accept(ModItems.IMPERIUM_HOE);
        }
        if (event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(ModItems.IMPERIUM_SWORD);
            event.accept(ModItems.ENDRIX_UPGRADE_SMITHING_TEMPLATE);
            event.accept(ModItems.ENDRIX_HELMET);
            event.accept(ModItems.ENDRIX_CHESTPLATE);
            event.accept(ModItems.ENDRIX_LEGGINGS);
            event.accept(ModItems.ENDRIX_BOOTS);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
        {
            event.accept(ModItems.CHORUS_FRUIT_YOGURT);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
