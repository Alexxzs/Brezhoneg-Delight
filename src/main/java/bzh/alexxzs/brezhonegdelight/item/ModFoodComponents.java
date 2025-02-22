package bzh.alexxzs.brezhonegdelight.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoodComponents {

    public static final int TICK_TO_SECONDS = 20;

    public static final FoodComponent KOUIGN_AMANN = new FoodComponent.Builder()
            .nutrition(10)
            .saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT, 300*TICK_TO_SECONDS, 0), 1.0F)
            .build();

    public static final FoodComponent KIG_HA_FARZ = new FoodComponent.Builder()
            .nutrition(10)
            .saturationModifier(1f)
            //.statusEffect(new StatusEffectInstance(ModEffects.COMFORT, 300*TICK_TO_SECONDS, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT, 300*TICK_TO_SECONDS, 0), 1.0F)
            .build();

    public static final FoodComponent CHOUCHEN = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(ModEffects.COMFORT, 120*TICK_TO_SECONDS, 0), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 5*TICK_TO_SECONDS, 0), 0.33F)
            .build();

    public static final FoodComponent BRETON_CREPE = new FoodComponent.Builder()
            .nutrition(10)
            .saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT, 300*TICK_TO_SECONDS, 0), 1.0F)
            .build();

}
