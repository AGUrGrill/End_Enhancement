package net.agu.endenhancementsmod.potion;

import net.agu.endenhancementsmod.AGUEndMod;
import net.agu.endenhancementsmod.effects.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions
{
    private static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, AGUEndMod.MODID);

    public static final RegistryObject<Potion> VOID_RESISTANCE_POTION =
            POTIONS.register("void_resistance_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.VOID_RESISTANCE.get(), 900)));

    public static void register(IEventBus eventBus)
    {
        POTIONS.register(eventBus);
    }

}
