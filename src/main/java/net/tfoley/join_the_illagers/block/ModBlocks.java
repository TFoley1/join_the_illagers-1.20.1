package net.tfoley.join_the_illagers.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.tfoley.join_the_illagers.JoinTheIllagers;

public class ModBlocks {


//    example
//    public static final Block NAME = registerBlock("name",
//            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));


    public static final Block LOOT_BLOCK = registerBlock("loot_block",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.GLOWSTONE).strength(2f).sounds(BlockSoundGroup.SCULK), UniformIntProvider.create(4,7)));
    public static final Block ABYSSIUM = registerBlock("abyssium",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.GLOWSTONE).strength(4f).sounds(BlockSoundGroup.NETHERITE), UniformIntProvider.create(4,7)));


    public static void registerModBlocks() {
        JoinTheIllagers.LOGGER.info("Registering ModBlocks for " + JoinTheIllagers.MOD_ID);
    }

    private static Item registerBlockItem(String name, Block block) {
        // Makes it so that a block can be used
        return Registry.register(Registries.ITEM, new Identifier(JoinTheIllagers.MOD_ID,name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(JoinTheIllagers.MOD_ID, name),block);
    }
}
