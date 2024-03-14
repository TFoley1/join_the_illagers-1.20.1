package net.tfoley.join_the_illagers.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
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
                    .icon(()-> new ItemStack(ModBlocks.ABYSSIUM)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.ABYSSIUM);
                        entries.add(ModItems.ABYSSIUM_INGOT);


                        entries.add(ModItems.PRISM);
                        entries.add(ModItems.COPPERBOUND_PRISM);
                        entries.add(ModItems.FANG_SPELL_ITEM);






                    }).build());

    public static void  registerItemGroups() {
        JoinTheIllagers.LOGGER.info("Registering Item Groups for " + JoinTheIllagers.MOD_ID);
    }

}
