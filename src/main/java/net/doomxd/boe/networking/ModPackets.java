package net.doomxd.boe.networking;

import net.doomxd.boe.networking.packet.LensFuelPayloadC2S;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.RegistryFriendlyByteBuf;

public class ModPackets {
    private static void registerClientbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry)
    {
        //Server -> Client payloads

    }
    private static void registerServerbound(PayloadTypeRegistry<RegistryFriendlyByteBuf> registry)
    {
        //Client -> Server payloads
        registry.register(LensFuelPayloadC2S.TYPE, LensFuelPayloadC2S.STREAM_CODEC);

        ServerPlayNetworking.registerGlobalReceiver(LensFuelPayloadC2S.TYPE, ServerboundPackets::handleLensFuelPayload);

    }

    public static void registerPackets()
    {
        registerClientbound(PayloadTypeRegistry.clientboundPlay());
        registerServerbound(PayloadTypeRegistry.serverboundPlay());
    }

}
