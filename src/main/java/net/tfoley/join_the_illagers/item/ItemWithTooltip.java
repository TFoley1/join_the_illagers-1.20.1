package net.tfoley.join_the_illagers.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemWithTooltip extends Item {
    public ItemWithTooltip(Settings settings, Text tooltip) {
        super(settings);
        this.tooltip = tooltip;
    }

    private final Text tooltip;

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(this.tooltip);
        super.appendTooltip(stack, world, tooltip, context);
    }
}