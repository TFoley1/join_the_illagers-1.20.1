
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

        // ALLOW ABYSSIUM TO BE SMELTED DOWN TO SOMETHING (NUGGETS?)

        // offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,item, RecipeCategory.BUILDING_BLOCKS, block);


        // JUST IF HAS INGOT AND BLOCK
        // offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, ModItems.ABYSSIUM_INGOT,RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABYSSIUM);

        offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC,ModItems.RAW_ABYSSIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_RAW_ABYSSIUM);

        // IF NUGGET, INGOT, AND BLOCK
            // INGOT TO BLOCK... Supposed to be reversable? Does not  give block recipe
            offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter, RecipeCategory.MISC, ModItems.ABYSSIUM_INGOT,
                    RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABYSSIUM,
                    "abyssium_from_abyssium_ingot", "abyssium_ingot");

            // NUGGET TO INGOT REVERSIBLE
            offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter, RecipeCategory.MISC, ModItems.ABYSSIUM_NUGGET,
                    RecipeCategory.BUILDING_BLOCKS, ModItems.ABYSSIUM_INGOT,
                    "abyssium_ingot_from_abyssium_nugget", "abyssium_ingot");


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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD,ModItems.SWEET_BERRY_PIE,1)
                .pattern("BSE")
                .input('B', Items.SWEET_BERRIES)
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(hasItem(Items.SUGAR), conditionsFromItem(Items.SUGAR))
                .criterion(hasItem(Items.EGG), conditionsFromItem(Items.EGG))
                .criterion(hasItem(ModItems.SWEET_BERRY_PIE), conditionsFromItem(ModItems.SWEET_BERRY_PIE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SWEET_BERRY_PIE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABYSSIUM_UPGRADE_TEMPLATE,2)
                .pattern("DTD")
                .pattern("DSD")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('S', Items.SCULK)
                .input('T', ModItems.ABYSSIUM_UPGRADE_TEMPLATE)
                .criterion(hasItem(ModItems.ABYSSIUM_UPGRADE_TEMPLATE), conditionsFromItem(ModItems.ABYSSIUM_UPGRADE_TEMPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABYSSIUM_UPGRADE_TEMPLATE)));


    }

}
