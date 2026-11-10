package net.doomxd.boe.keymapping;

import com.mojang.blaze3d.platform.InputConstants;
import net.doomxd.boe.BeyondOnesEyes;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.tutorial.Tutorial;
import org.lwjgl.glfw.GLFW;

public class ModKeyMappings {
    public static final KeyMapping ACTIVATE_LENSES= KeyMappingHelper.registerKeyMapping(
            new KeyMapping("key.beyond_ones_eyes.activate_lenses",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_R, KeyMapping.Category.MISC)
    );

    public static void register()
    {
        BeyondOnesEyes.LOGGER.info("Registering Mod key mappings for " + BeyondOnesEyes.MOD_ID);

    }
}
