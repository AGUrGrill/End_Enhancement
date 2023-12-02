package net.agu.endenhancementsmod.datagen;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, AGUEndMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(ModItems.ENDRIX_NUGGET);
        simpleItem(ModItems.ENDRIX_UPGRADE_SMITHING_TEMPLATE);
        simpleItem(ModItems.IMPERIUM_INGOT);
        handheldItem(ModItems.IMPERIUM_SWORD);
        handheldItem(ModItems.IMPERIUM_PICKAXE);
        handheldItem(ModItems.IMPERIUM_AXE);
        handheldItem(ModItems.IMPERIUM_SHOVEL);
        handheldItem(ModItems.IMPERIUM_HOE);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(AGUEndMod.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AGUEndMod.MODID,"item/" + item.getId().getPath()));
    }
}
