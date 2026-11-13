package net.doomxd.boe.mixin;

import net.doomxd.boe.effect.ModEffects;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.SkyRenderer;
import net.minecraft.client.renderer.state.level.SkyRenderState;
import net.minecraft.world.attribute.EnvironmentAttributeProbe;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

@Mixin(SkyRenderer.class)
abstract class SkyRendererMixin {
    @Inject(method = "extractRenderState", at = @At(value="TAIL"))
    private void getExtractRenderStateMixin(ClientLevel level, float partialTicks, Camera camera, SkyRenderState state, CallbackInfo ci)
    {
        if (state.skybox != DimensionType.Skybox.NONE && state.skybox != DimensionType.Skybox.END) {
            assert Minecraft.getInstance().player != null;
            if (Minecraft.getInstance().player.hasEffect(ModEffects.OPENED_EYES)) {
                state.skyColor = Color.PINK.hashCode();
                //the sunrise and sunsetcolor just changes the color of the sky around the sun
                // state.sunriseAndSunsetColor = Color.MAGENTA.hashCode();
            }
            else if (Minecraft.getInstance().player.hasEffect(ModEffects.SHIFTED))
            {
                state.skyColor = Color.WHITE.hashCode();
            }
        }
    }
}
