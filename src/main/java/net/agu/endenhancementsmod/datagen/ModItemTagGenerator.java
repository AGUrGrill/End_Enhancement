package net.agu.endenhancementsmod.datagen;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                               CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, AGUEndMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ENDRIX_HELMET.get())
                .add(ModItems.ENDRIX_CHESTPLATE.get())
                .add(ModItems.ENDRIX_LEGGINGS.get())
                .add(ModItems.ENDRIX_BOOTS.get());
    }
}
