package net.tfoley.join_the_illagers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.tfoley.join_the_illagers.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        // ADD BLOCKS WITH TAGS NEEDED BELOW
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ABYSSIUM)
                .add(ModBlocks.BLOCK_OF_RAW_ABYSSIUM)
                .add(ModBlocks.ABYSSIUM_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ABYSSIUM)
                .add(ModBlocks.BLOCK_OF_RAW_ABYSSIUM)
                .add(ModBlocks.ABYSSIUM_ORE)
        ;
    }
}
