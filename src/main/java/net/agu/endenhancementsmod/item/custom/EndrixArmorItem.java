package net.agu.endenhancementsmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EndrixArmorItem extends ArmorItem {
    public EndrixArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        Item boots = player.getInventory().armor.get(0).getItem();
        Item leggings = player.getInventory().armor.get(1).getItem();
        Item chestplate = player.getInventory().armor.get(2).getItem();
        Item helmet = player.getInventory().armor.get(3).getItem();
        Boolean fullSetEquipped = boots == this && leggings == this &&
                chestplate == this && helmet == this;

        // Add full set effects
        if (player.getInventory().armor.get(0).getItem() == this) {
            player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 10, 0));
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 10, 0));
            player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 10, 0));
        }
    }
}
