package net.tfoley.join_the_illagers.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.sound.Sound;
import net.minecraft.command.CommandSource;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.tfoley.join_the_illagers.JoinTheIllagers;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class VexSpellItem extends Item implements Equipment { // new class with spell casting illager entity?
    public VexSpellItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.join_the_illagers.vex_spell_tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    public void particleEffectSpawner(ServerWorld world, LivingEntity user){
        world.spawnParticles(ParticleTypes.SOUL, user.getX(), (user.getY()) + 2.5, user.getZ(), 25, 0f, 0f, 0f, 0f);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!(user instanceof PlayerEntity)) {
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
        user.setCurrentHand(hand);
        Vec3d fromPlayer = new Vec3d(3, 0, 0);
        // Add particle effects
        // user.getItemCooldownManager().set(this,60);

        return TypedActionResult.pass(user.getStackInHand(hand));
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {

        // VexItemCooldownManager.set(user.getActiveItem().getItem(), 60);
        if (user instanceof PlayerEntity){
            // summon 1 vex
            VexEntity ownedVex = ((EntityType<VexEntity>) EntityType.VEX).create(world);
            //VexEntity.updatePosition(user.getX(), (user.getY()), user.getZ());
            ownedVex.updatePosition(user.getX(), (user.getY()) + 3, user.getZ());
            // ownedVex.setOwner((MobEntity) user); // change one line in a mixin to require LivingEntity?
            world.spawnEntity(ownedVex);
            if (!world.isClient) {
                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.PLAYERS, 1f, 1f);
            }

            ((PlayerEntity) user).getItemCooldownManager().set(this, 60);
        }


        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }



    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.OFFHAND;
    }

}


