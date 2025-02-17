package bzh.alexxzs.brezhonegdelight.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.UseAction;

import java.util.List;

public class DrinkItem extends Item {

    private final String name;

    public DrinkItem(Settings settings, String name) {
        super(settings);
        this.name = name;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown())
            tooltip.add(Text.translatable("tooltip.brezhonegdelight." + name + ".shift_down"));
        else
            tooltip.add(Text.translatable("tooltip.brezhonegdelight.noshift"));


        super.appendTooltip(stack, context, tooltip, type);
    }
}
