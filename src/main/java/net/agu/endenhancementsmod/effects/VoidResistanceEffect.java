package net.agu.endenhancementsmod.effects;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.EntityTeleportEvent;

public class VoidResistanceEffect extends MobEffect
{
    protected VoidResistanceEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pEntityLiving, int pAmplifier) {
        Level pLevel = pEntityLiving.level();
        if (!pEntityLiving.level().isClientSide() && pEntityLiving instanceof Player player)
        {
            if (pEntityLiving.position().y < 0)
            {
                double d0 = pEntityLiving.getX();
                double d1 = pEntityLiving.getY();
                double d2 = pEntityLiving.getZ();

                for(int i = 0; i < 16; ++i)
                {
                    double d3 = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - 0.5) * (16.0*(i+1));
                    double d4 = pEntityLiving.getX() + (pEntityLiving.getRandom().nextDouble() - 0.5) * (16.0*(i+1));
                    double d5 = pEntityLiving.getZ() + (pEntityLiving.getRandom().nextDouble() - 0.5) * (16.0*(i+1));

                    if (pEntityLiving.isPassenger()) {
                        pEntityLiving.stopRiding();
                    }

                    Vec3 vec3 = pEntityLiving.position();
                    pLevel.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(pEntityLiving));
                    EntityTeleportEvent.ChorusFruit event = ForgeEventFactory.onChorusFruitTeleport(pEntityLiving, d3, d4, d5);

                    if (pEntityLiving.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true)) {
                        SoundEvent soundevent = pEntityLiving instanceof Fox ? SoundEvents.FOX_TELEPORT : SoundEvents.CHORUS_FRUIT_TELEPORT;
                        pLevel.playSound((Player)null, d0, d1, d2, soundevent, SoundSource.PLAYERS, 1.0F, 1.0F);
                        pEntityLiving.playSound(soundevent, 1.0F, 1.0F);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
