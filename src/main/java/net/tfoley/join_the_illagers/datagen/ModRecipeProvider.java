
package net.tfoley.join_the_illagers.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.tfoley.join_the_illagers.block.ModBlocks;
import net.tfoley.join_the_illagers.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    private static final List<ItemConvertible> ABYSS_SMELTABLES = List.of(ModItems.ABYSS);

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        // offerSmelting(exporter, ModItem or a List, RecipeCategory.MISC, Result, 0.7f (EXP) , 200 (# of ticks it takes to cook), "group");

        offerSmelting(exporter, ABYSS_SMELTABLES , RecipeCategory.MISC, ModItems.ABYSSIUM_INGOT, 1f, 200, "abyss");

        // offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,item, RecipeCategory.BUILDING_BLOCKS, block);
        // offerShapelessRecipe(exporter, Items.CHICKEN, Items.HONEY_BOTTLE, RecipeCategory.FOOD,ModItems.HONEY_GLAZED_CHICKEN);

        // New method that should create a recipe for new upgrade templates
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_PICKAXE,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_PICKAXE);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_SWORD,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_SWORD);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_AXE,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_AXE);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_SHOVEL,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_SHOVEL);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_HOE,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_HOE);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_HELMET,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_HELMET);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_CHESTPLATE,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_CHESTPLATE);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_LEGGINGS,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_LEGGINGS);
        offerNetheriteLikeUpgradeRecipe(exporter,Items.DIAMOND_BOOTS,RecipeCategory.MISC, ModItems.ABYSSIUM_UPGRADE_TEMPLATE,ModItems.ABYSSIUM_INGOT,ModItems.ABYSSIUM_BOOTS);

        // JUST IF HAS INGOT AND BLOCK
        // offerReversibleCompactingRecipes(exporter,RecipeCategory.MISC, ModItems.ABYSSIUM_INGOT,RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABYSSIUM);

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD,ModItems.HONEY_GLAZED_CHICKEN,1)
                .pattern("HC")
                .input('C', Items.COOKED_CHICKEN)
                .input('H', Items.HONEY_BOTTLE)
                .criterion(hasItem(Items.COOKED_CHICKEN), conditionsFromItem(Items.COOKED_CHICKEN))
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .criterion(hasItem(ModItems.HONEY_GLAZED_CHICKEN), conditionsFromItem(ModItems.HONEY_GLAZED_CHICKEN))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HONEY_GLAZED_CHICKEN)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD,ModItems.ABYSSIUM_UPGRADE_TEMPLATE,2)
                .pattern("DTD")
                .pattern("DSD")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('S', Items.SCULK)
                .input('T', ModItems.ABYSSIUM_UPGRADE_TEMPLATE)
                .criterion(hasItem(ModItems.ABYSSIUM_UPGRADE_TEMPLATE), conditionsFromItem(ModItems.ABYSSIUM_UPGRADE_TEMPLATE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABYSSIUM_UPGRADE_TEMPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABYSSIUM,1)
                .pattern("AA")
                .pattern("SA")
                .input('A', ModItems.ABYSS)
                .input('S', ModItems.SOUL)
                .criterion(hasItem(ModItems.ABYSS), conditionsFromItem(ModItems.ABYSS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABYSSIUM)));
    }

    public static void offerNetheriteLikeUpgradeRecipe(Consumer<RecipeJsonProvider> exporter, Item input, RecipeCategory category,Item upgrade,Item ingot, Item result) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(upgrade), Ingredient.ofItems(input), Ingredient.ofItems(ingot), category, result).criterion("has_netherite_ingot", RecipeProvider.conditionsFromItem(ingot)).offerTo(exporter, RecipeProvider.getItemPath(result) + "_smithing");
    }

}
