package bzh.alexxzs.brezhonegdelight;

import bzh.alexxzs.brezhonegdelight.block.custom.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BrezhonegDelightClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUCKWHEAT_CROP, RenderLayer.getCutout());
    }
}
