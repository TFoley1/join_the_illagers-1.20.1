package net.tfoley.join_the_illagers.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.tfoley.join_the_illagers.JoinTheIllagers;


public class ModEffects {
    public static final StatusEffect SOULBOUND = new SoulBoundEffect(StatusEffectCategory.BENEFICIAL, 312467);


    public static StatusEffect RegisterStatusEffects() {
        JoinTheIllagers.LOGGER.info("Registering Mod Effects for "+JoinTheIllagers.MOD_ID);
        return Registry.register(Registries.STATUS_EFFECT, new Identifier("join_the_illagers", "soulbound"), SOULBOUND);
    }
}
