package net.tfoley.join_the_illagers.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.tfoley.join_the_illagers.JoinTheIllagers;
import net.tfoley.join_the_illagers.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier WITHER_SKELETON_ID = new Identifier("minecraft", "entities/wither_skeleton");
    private static final Identifier ENDER_DRAGON_ID = new Identifier("minecraft", "entities/ender_dragon");
    private static final Identifier ENDERMAN_ID = new Identifier("minecraft", "entities/enderman");
    private static final Identifier WARDEN_ID = new Identifier("minecraft", "entities/warden");
    private static final Identifier ALLAY_ID = new Identifier("minecraft", "entities/allay");
    private static final Identifier VEX_ID = new Identifier("minecraft", "entities/vex");
    private static final Identifier WOODLAND_MANSION_ID = new Identifier("minecraft", "chests/woodland_mansion");
    private static final Identifier BURIED_TREASURE_ID = new Identifier("minecraft", "chests/buried_treasure");
    private static final Identifier ANCIENT_CITY_ID = new Identifier("minecraft", "chests/ancient_city");
    private static final Identifier ABANDONED_MINESHAFT_ID = new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static final Identifier ARMORER_CHEST_ID = new Identifier("minecraft", "chests/village/village_armorer");
    private static final Identifier ARMORER_ID = new Identifier("minecraft", "gameplay/hero_of_the_village/armorer_gift");
    private static final Identifier SOUL_SAND_ID = new Identifier("minecraft", "blocks/soul_sand");


    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(WITHER_SKELETON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.2f)) // Drops 20% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ENDER_DRAGON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.80f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.ABYSS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(10.0f, 20.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ENDERMAN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.30f)) // Drops 30% of the time
                        .with(ItemEntry.builder(ModItems.ABYSS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 3.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(WARDEN_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.ABYSS))
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 7.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ALLAY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(VEX_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Drops 100% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(SOUL_SAND_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.3f)) // Drops 50% of the time
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(WOODLAND_MANSION_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.8f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.VEX_SPELL_ITEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(BURIED_TREASURE_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.2f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.EMERALD_CROWN))
                        .with(ItemEntry.builder(ModItems.PRISM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.5f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.PRISM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ANCIENT_CITY_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.5f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.ABYSS))
                        .with(ItemEntry.builder(ModItems.SOUL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 5.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ABANDONED_MINESHAFT_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.5f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.PRISM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ARMORER_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.5f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.EMERALD_CROWN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(ARMORER_CHEST_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(.2f)) // Drops 80% of the time
                        .with(ItemEntry.builder(ModItems.PRISM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

        }

                ));
    }
}
