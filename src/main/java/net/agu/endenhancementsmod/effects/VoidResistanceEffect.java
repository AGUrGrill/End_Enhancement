package net.agu.endenhancementsmod.effects;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class VoidResistanceEffect extends MobEffect
{
    protected VoidResistanceEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level().isClientSide() && pLivingEntity instanceof Player player)
        {
            player.sendSystemMessage(Component.literal("blahblahblah"));
            Vec3 playerPos = player.position();
            double x = playerPos.x();
            double y = playerPos.y();
            double z = playerPos.z();

            if (y < 0)
            {
                pLivingEntity.sendSystemMessage(Component.literal("Fired"));
                pLivingEntity.setPos(x, y+100, z);
                pLivingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 500, 0));
            }
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return super.isDurationEffectTick(pDuration, pAmplifier);
    }
}
