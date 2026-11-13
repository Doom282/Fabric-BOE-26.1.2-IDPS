package net.doomxd.boe.mixin;


import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightmapRenderStateExtractor;
import net.minecraft.client.renderer.state.LightmapRenderState;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightmapRenderStateExtractor.class)
abstract class LightmapRenderStateExtractorMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Inject(method = "extract", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;pop()V"))
    private void getExtractMixin(LightmapRenderState renderState, float partialTicks, CallbackInfo ci){
        assert minecraft.player != null;
        if(minecraft.player.hasEffect(ModEffects.OPENED_EYES)) {
            //renderState.skyLightColor = new Vector3f(0.94F, 0.57F, 0.97F);
            renderState.skyLightColor = new Vector3f(0.9603F, 0.7103F, 0.8651F);
        }
        else if(minecraft.player.hasEffect(ModEffects.SHIFTED))
        {

            renderState.skyLightColor = new Vector3f(0.01F, 0.01F, 0.01F);
        }
    }

}
