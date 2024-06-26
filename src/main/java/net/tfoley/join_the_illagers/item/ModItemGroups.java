package net.tfoley.join_the_illagers.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tfoley.join_the_illagers.JoinTheIllagers;
import net.tfoley.join_the_illagers.block.ModBlocks;

public class ModItemGroups extends ItemGroups {

    public static final ItemGroup ILLAGER_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(JoinTheIllagers.MOD_ID, "illager"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.illager"))
                    .icon(()-> new ItemStack(ModItems.FANG_SPELL_ITEM)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.ABYSSIUM);
                        entries.add(ModBlocks.LOOT_BLOCK);

                        entries.add(ModItems.ABYSS);
                        entries.add(ModItems.ABYSSIUM);
                        entries.add(ModItems.ABYSSIUM_INGOT);
                        entries.add(ModItems.ABYSSIUM_NUGGET);
                        entries.add(ModItems.ABYSSIUM_UPGRADE_TEMPLATE);
                        entries.add(ModItems.ABYSSIUM_SWORD);
                        entries.add(ModItems.ABYSSIUM_PICKAXE);
                        entries.add(ModItems.ABYSSIUM_AXE);
                        entries.add(ModItems.ABYSSIUM_SHOVEL);
                        entries.add(ModItems.ABYSSIUM_HOE);
                        entries.add(ModItems.ABYSSIUM_HELMET);
                        entries.add(ModItems.ABYSSIUM_CHESTPLATE);
                        entries.add(ModItems.ABYSSIUM_LEGGINGS);
                        entries.add(ModItems.ABYSSIUM_BOOTS);
                        entries.add(ModItems.EMERALD_CROWN);

                        entries.add(ModItems.VEX_SPELL_ITEM);
                        entries.add(ModItems.FANG_SPELL_ITEM);
                        entries.add(ModItems.SOUL);
                        entries.add(ModItems.SWEET_BERRY_PIE);
                        entries.add(ModItems.HONEY_GLAZED_CHICKEN);


                    }).build());

    public static void  registerItemGroups() {
        JoinTheIllagers.LOGGER.info("Registering Item Groups for " + JoinTheIllagers.MOD_ID);
    }

}
