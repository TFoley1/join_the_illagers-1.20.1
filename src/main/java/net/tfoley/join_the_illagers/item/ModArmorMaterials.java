package net.tfoley.join_the_illagers.item;

import net.minecraft.client.sound.Sound;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.tfoley.join_the_illagers.JoinTheIllagers;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    ABYSSIUM("abyssium",23, new int[] {3,8,6,4},19, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,2f,
            0.1f,() -> Ingredient.ofItems(ModItems.ABYSSIUM_INGOT)),

    EMERALD("emerald",23, new int[] {3,8,6,4},19, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,2f,
            0.1f,() -> Ingredient.ofItems(Items.EMERALD));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent  equipSound;
    private final float toughness;
    public final float knockbackResistance;
    public final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return JoinTheIllagers.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
