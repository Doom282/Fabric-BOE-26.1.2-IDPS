package net.doomxd.boe.timer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;

public class ModAddEffectTimer implements ServerTickEvents.EndTick {
    public static final ModAddEffectTimer INSTANCE = new ModAddEffectTimer();
    private long ticksUntilSomething;
    private MobEffectInstance effectInstance;
    private ServerPlayer player;
    private String action;


    public void addEffectTimer(long ticksUntilSomething, MobEffectInstance effectInstance, ServerPlayer player) {
        this.ticksUntilSomething = ticksUntilSomething;
        this.effectInstance = effectInstance;
        this.player = player;
    }

    @Override
    public void onEndTick(MinecraftServer server) {
        if (--this.ticksUntilSomething == 0L) {
            if(effectInstance!=null && player != null )
            {
                    player.addEffect(effectInstance);
            }
            // If you want to repeat this, reset ticksUntilSomething here.
        }
    }
    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(INSTANCE);
    }
}
