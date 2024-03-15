package net.tfoley.join_the_illagers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.tfoley.join_the_illagers.block.ModBlocks;
import net.tfoley.join_the_illagers.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        // addDrop(*insert block*);
        // addDrop(ModBlocks.ABYSSIUM);
//        oreDrops(ModBlocks.ABYSSIUM_ORE, ModItems.RAW_ABYSSIUM);
//        oreDrops(ModBlocks.ABYSSIUM, ModItems.ABYSSIUM_NUGGET);


        addDrop(ModBlocks.BLOCK_OF_RAW_ABYSSIUM);
        addDrop(ModBlocks.ABYSSIUM,copperLikeOreDrops(ModBlocks.ABYSSIUM, ModItems.ABYSSIUM_NUGGET));
        addDrop(ModBlocks.ABYSSIUM_ORE,copperLikeOreDrops(ModBlocks.ABYSSIUM_ORE, ModItems.RAW_ABYSSIUM));

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
