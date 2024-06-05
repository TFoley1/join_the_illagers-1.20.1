package net.tfoley.join_the_illagers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.tfoley.join_the_illagers.block.ModBlocks;
import net.tfoley.join_the_illagers.item.ModItems;

import java.util.List;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }
    private static List<ItemConvertible> LOOT_ITEMS = List.of(Items.IRON_INGOT,Items.GOLD_INGOT);
    @Override
    public void generate() {
        // addDrop(*insert block*);
        // addDrop(ModBlocks.ABYSSIUM);
//        oreDrops(ModBlocks.ABYSSIUM_ORE, ModItems.RAW_ABYSSIUM);
//        oreDrops(ModBlocks.ABYSSIUM, ModItems.ABYSSIUM_NUGGET);


        addDrop(ModBlocks.ABYSSIUM,copperLikeOreDrops(ModBlocks.ABYSSIUM, ModItems.ABYSSIUM_NUGGET));
        addDrop(ModBlocks.LOOT_BLOCK); // NOTE FIND WAY TO KEEP ALREADY EXISTING LOOT TABLE OR GENERATE SAME/SIMILAR ONE

    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(2.0f, 5.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
