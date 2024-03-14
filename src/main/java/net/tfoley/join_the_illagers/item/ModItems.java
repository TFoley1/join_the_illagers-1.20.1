package net.tfoley.join_the_illagers.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.tfoley.join_the_illagers.JoinTheIllagers;
import net.tfoley.join_the_illagers.item.custom.FangSpellItem;

public class ModItems {

    public static final Item ABYSSIUM_INGOT = registerItem("abyssium_ingot",new Item(new FabricItemSettings()));
    public static final Item PRISM = registerItem("prism",new Item(new FabricItemSettings().rarity(Rarity.EPIC)));
    public static final Item COPPERBOUND_PRISM = registerItem("copperbound_prism",new Item(new FabricItemSettings().rarity(Rarity.EPIC)));


    public static final Item FANG_SPELL_ITEM = registerItem("fang_spell_item", new FangSpellItem(new FabricItemSettings().rarity(Rarity.EPIC)));



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
