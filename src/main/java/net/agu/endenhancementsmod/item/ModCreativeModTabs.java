package net.agu.endenhancementsmod.item;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AGUEndMod.MODID);

    public static final RegistryObject<CreativeModeTab> AGU_END_TAB = CREATIVE_MODE_TABS.register("agu_end_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.IMPERIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.agu_end_tab"))
                    .displayItems(((pParameters, pOutput) -> {

                        // Items
                        pOutput.accept(ModItems.ENDRIX_NUGGET.get());
                        pOutput.accept(ModItems.IMPERIUM_INGOT.get());
                        pOutput.accept(ModItems.ENDRIX_UPGRADE_SMITHING_TEMPLATE.get());
                        pOutput.accept(ModItems.CHORUS_FRUIT_YOGURT.get());

                        // Weapon/Tools
                        pOutput.accept(ModItems.IMPERIUM_SWORD.get());
                        pOutput.accept(ModItems.IMPERIUM_PICKAXE.get());
                        pOutput.accept(ModItems.IMPERIUM_AXE.get());
                        pOutput.accept(ModItems.IMPERIUM_SHOVEL.get());
                        pOutput.accept(ModItems.IMPERIUM_HOE.get());

                        // Armor
                        pOutput.accept(ModItems.ENDRIX_HELMET.get());
                        pOutput.accept(ModItems.ENDRIX_CHESTPLATE.get());
                        pOutput.accept(ModItems.ENDRIX_LEGGINGS.get());
                        pOutput.accept(ModItems.ENDRIX_BOOTS.get());

                        // Blocks
                        pOutput.accept(ModBlocks.ENDRIX_ORE.get());

                    }))
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
