package net.tfoley.join_the_illagers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.tfoley.join_the_illagers.block.ModBlocks;
import net.tfoley.join_the_illagers.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.item);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABYSSIUM);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // itemModelGenerator.register(ModItems.item,Models.GENERATED);
        itemModelGenerator.register(ModItems.ABYSSIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISM, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERBOUND_PRISM, Models.GENERATED);
        itemModelGenerator.register(ModItems.FANG_SPELL_ITEM, Models.GENERATED);
    }
}