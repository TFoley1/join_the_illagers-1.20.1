package net.tfoley.join_the_illagers.effect;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class SoulBoundEffect extends StatusEffect {
    public SoulBoundEffect(StatusEffectCategory category, int color) {
        super(StatusEffectCategory.BENEFICIAL, 1123131);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
//        if (entity instanceof PlayerEntity) { save exp
//            int savedExperineceLevel = ((PlayerEntity) entity).experienceLevel;
//        }

//        if (entity instanceof PlayerEntity) {
//            ((PlayerEntity) entity).addExperience(1 << amplifier); // Higher amplifier gives you EXP faster
//        }

        if (entity instanceof PlayerEntity) {
            ((PlayerEntity) entity).disableExperienceDropping();
            int savedExperineceLevel = ((PlayerEntity) entity).experienceLevel;
            //entity.disableExperienceDropping();
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
