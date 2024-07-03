package net.agu.endenhancementsmod.effects;

import net.agu.endenhancementsmod.AGUEndMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModEffects
{
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AGUEndMod.MODID);

    public static final RegistryObject<MobEffect> VOID_RESISTANCE = MOB_EFFECTS.register("void_resistance",
            () -> new VoidResistanceEffect(MobEffectCategory.BENEFICIAL, Color.MAGENTA.getRGB()));

    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
