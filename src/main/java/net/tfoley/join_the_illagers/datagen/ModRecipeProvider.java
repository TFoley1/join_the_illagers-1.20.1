package net.tfoley.join_the_illagers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.tfoley.join_the_illagers.block.ModBlocks;
import net.tfoley.join_the_illagers.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // offerSmelting(exporter, ModItem or a List, RecipeCategory.MISC, Result, 0.7f (EXP) , 200 (# of ticks it takes to cook), "group");

        // ALLOW ABYSSIUM TO BE SMELTED DOWN TO SOMETHING (NUGGETS?)3

        // offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,item, RecipeCategory.BUILDING_BLOCKS, block);

        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, ModItems.ABYSSIUM_INGOT,RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABYSSIUM);

        // Breaks when you do more than one, need a shaped recipe instead?
        // offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, ModItems.ABYSSIUM_NUGGET,RecipeCategory.MISC, ModItems.ABYSSIUM_INGOT);

//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABYSSIUM_INGOT,1)
//                .pattern("###")
//                .pattern("###")
//                .pattern("###")
//                .input('#', ModItems.ABYSSIUM_NUGGET)
//                .criterion(hasItem(ModItems.ABYSSIUM_NUGGET), conditionsFromItem(ModItems.ABYSSIUM_NUGGET))
//                .criterion(hasItem(ModItems.ABYSSIUM_INGOT), conditionsFromItem(ModItems.ABYSSIUM_INGOT))
//                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABYSSIUM_INGOT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ABYSSIUM_INGOT, 9);



        // SHAPED
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FANG_SPELL_ITEM,1)
                .pattern("ELS")
                .pattern("XTD")
                .pattern("/P/")
                .input('E', Items.ECHO_SHARD)
                .input('L', Items.LAPIS_LAZULI)
                .input('S', Items.SOUL_SAND)
                .input('X', Items.EXPERIENCE_BOTTLE)
                .input('T', Items.TOTEM_OF_UNDYING)
                .input('D', Items.DRAGON_BREATH)
                .input('/', Items.STICK)
                .input('P', Items.PAPER)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.FANG_SPELL_ITEM)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.COPPERBOUND_PRISM,1)
                .pattern(" C ")
                .pattern("CPC")
                .pattern(" C ")
                .input('C', Items.COPPER_INGOT)
                .input('P', ModItems.PRISM)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .criterion(hasItem(ModItems.PRISM), conditionsFromItem(ModItems.PRISM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COPPERBOUND_PRISM)));
    }
}
