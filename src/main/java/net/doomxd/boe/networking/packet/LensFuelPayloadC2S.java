package net.doomxd.boe.networking.packet;

import net.doomxd.boe.BeyondOnesEyes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

public record LensFuelPayloadC2S(String name, int value) implements CustomPacketPayload {

    //Basically this turns this record goober into a thing both sides know that can be translated to and from a byte for easy transport

    public static final Type<LensFuelPayloadC2S> TYPE = new Type<>(
      Identifier.fromNamespaceAndPath(BeyondOnesEyes.MOD_ID, "lens_fuel_payload")
    );

    //This turns the vars into a byte
    public static final StreamCodec<RegistryFriendlyByteBuf, LensFuelPayloadC2S> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.STRING_UTF8,
            LensFuelPayloadC2S::name,

            ByteBufCodecs.VAR_INT,
            LensFuelPayloadC2S::value,

            //Example of how to add a ItemStack parameter for the record (would be next to int value up there ^)
            //Its legit jsut either bytebuff . smth or the class.smth then a comma then LensFuelPayloadC2S::varnamehere

            //ItemStack.STREAM_CODEC,
            //LensFuelPayloadC2S::stack,

            LensFuelPayloadC2S::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
