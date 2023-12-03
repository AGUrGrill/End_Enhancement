package net.agu.endenhancementsmod;

import com.mojang.logging.LogUtils;
import net.agu.endenhancementsmod.block.ModBlocks;
import net.agu.endenhancementsmod.item.ModCreativeModTabs;
import net.agu.endenhancementsmod.item.ModItems;
import net.agu.endenhancementsmod.loot.ModLootModifiers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AGUEndMod.MODID)
public class AGUEndMod
{
    public static final String MODID = "aguendmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AGUEndMod()
    {
        // Event bus
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registers mod items to eventbus
        ModItems.register(modEventBus);

        // Registers mod blocks to eventbus
        ModBlocks.register(modEventBus);

        // Register creative mode tab
        ModCreativeModTabs.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register Modified Loot Tables
        ModLootModifiers.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        // Adds item to 'ingredients' tab
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
