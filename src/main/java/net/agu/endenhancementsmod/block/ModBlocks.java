package net.agu.endenhancementsmod.block;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.*;
import java.util.function.Supplier;

public class ModBlocks
{
    // Register blocks
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AGUEndMod.MODID);

    // Register block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block); // Registers block
        registerBlockItem(name, toReturn); // Registers block item
        return toReturn;
    }

    // Register the item of the block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // ENDRIX ORE
    public static final RegistryObject<Block> ENDRIX_ORE = registerBlock("endrix_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE).sound(SoundType.SLIME_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    public static void register (IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
