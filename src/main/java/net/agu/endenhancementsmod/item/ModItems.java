package net.agu.endenhancementsmod.item;

import net.agu.endenhancementsmod.AGUEndMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    // List of items to be added
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AGUEndMod.MODID);

    // Register new item object and supply properties
    public static final RegistryObject<Item> ENDRIX_NUGGET = ITEMS.register("endrix_nugget",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDRIX_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("endrix_upgrade_smithing_template",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IMPERIUM_INGOT = ITEMS.register("imperium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IMPERIUM_SWORD = ITEMS.register("imperium_sword",
            () -> new SwordItem(ModToolTiers.IMPERIUM, 3, -2f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IMPERIUM_PICKAXE = ITEMS.register("imperium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.IMPERIUM, 1, -2.4f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IMPERIUM_AXE = ITEMS.register("imperium_axe",
            () -> new AxeItem(ModToolTiers.IMPERIUM, 5, -2.8f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IMPERIUM_SHOVEL = ITEMS.register("imperium_shovel",
            () -> new ShovelItem(ModToolTiers.IMPERIUM, 1.5f, -2.8f,
                    new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> IMPERIUM_HOE = ITEMS.register("imperium_hoe",
            () -> new HoeItem(ModToolTiers.IMPERIUM, -4, 0f,
                    new Item.Properties().fireResistant()));

    // Register items list
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }

}
