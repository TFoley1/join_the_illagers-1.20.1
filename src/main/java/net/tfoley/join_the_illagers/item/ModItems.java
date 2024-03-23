package net.tfoley.join_the_illagers.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.tfoley.join_the_illagers.JoinTheIllagers;
import net.tfoley.join_the_illagers.item.custom.FangSpellItem;
import net.tfoley.join_the_illagers.item.custom.ModArmorItem;
import net.tfoley.join_the_illagers.item.custom.VexSpellItem;

public class ModItems {


    // MATERIALS
    public static final Item ABYSSIUM_INGOT = registerItem("abyssium_ingot",new Item(new FabricItemSettings()));
    public static final Item ABYSSIUM_NUGGET = registerItem("abyssium_nugget",new Item(new FabricItemSettings()));
    public static final Item ABYSS = registerItem("abyss",new Item(new FabricItemSettings()));
    public static final Item SOUL = registerItem("soul",new Item(new FabricItemSettings()));
    public static final Item ABYSSIUM_UPGRADE_TEMPLATE = registerItem("abyssium_upgrade_template",new ItemWithTooltip(new FabricItemSettings(), Text.translatable("tooltip.join_the_illagers.abyssium_smithing_template.tooltip")));

    // FOOD ITEM
    public static final Item SWEET_BERRY_PIE = registerItem("sweet_berry_pie",new Item(new FabricItemSettings().food(ModFoodCompontents.SWEET_BERRY_PIE)));
    public static final Item HONEY_GLAZED_CHICKEN = registerItem("honey_glazed_chicken",new Item(new FabricItemSettings().food(ModFoodCompontents.HONEY_GLAZED_CHICKEN)));

    // TOOLS, WEAPONS & ARMOR
    public static final Item ABYSSIUM_PICKAXE = registerItem("abyssium_pickaxe", new PickaxeItem(ModToolMaterial.ABYSSIUM, 2, -3.0f, new FabricItemSettings()));

    public static final Item ABYSSIUM_AXE = registerItem("abyssium_axe", new AxeItem(ModToolMaterial.ABYSSIUM, 5, -2.8f, new FabricItemSettings()));

    public static final Item ABYSSIUM_SHOVEL = registerItem("abyssium_shovel", new ShovelItem(ModToolMaterial.ABYSSIUM, 2, -3.0f, new FabricItemSettings()));
    public static final Item ABYSSIUM_HOE = registerItem("abyssium_hoe", new HoeItem(ModToolMaterial.ABYSSIUM, 0, -3.0f, new FabricItemSettings()));
    public static final Item ABYSSIUM_SWORD= registerItem("abyssium_sword", new SwordItem(ModToolMaterial.ABYSSIUM, 3, -2.2f, new FabricItemSettings()));
    public static final Item ABYSSIUM_HELMET= registerItem("abyssium_helmet", new ModArmorItem(ModArmorMaterials.ABYSSIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ABYSSIUM_CHESTPLATE= registerItem("abyssium_chestplate", new ModArmorItem(ModArmorMaterials.ABYSSIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ABYSSIUM_LEGGINGS= registerItem("abyssium_leggings", new ModArmorItem(ModArmorMaterials.ABYSSIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ABYSSIUM_BOOTS= registerItem("abyssium_boots", new ModArmorItem(ModArmorMaterials.ABYSSIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    // TODO CHANGE STACK SIZE TO ONE
    public static final Item PRISM = registerItem("prism",new Item(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item COPPERBOUND_PRISM = registerItem("copperbound_prism",new Item(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item FANG_SPELL_ITEM = registerItem("fang_spell_item", new FangSpellItem(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item VEX_SPELL_ITEM = registerItem("vex_spell_item", new VexSpellItem(new FabricItemSettings().rarity(Rarity.EPIC).maxCount(1)));
    public static final Item EMERALD_CROWN = registerItem("emerald_crown", new ModArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET,new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(JoinTheIllagers.MOD_ID, name), item);
    }

    public static void registerModItems() {
        JoinTheIllagers.LOGGER.info("Registering Mod Items for "+JoinTheIllagers.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);

    }

    private  static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {

        entries.add(ABYSSIUM_INGOT);
    }



}
