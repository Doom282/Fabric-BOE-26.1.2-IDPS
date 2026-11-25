package net.doomxd.boe.attachment;

import com.mojang.serialization.Codec;
import net.doomxd.boe.BeyondOnesEyes;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentSyncPredicate;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.network.codec.ByteBufCodecs;

public class ModAttachments {
    public static final AttachmentType<Boolean> IS_SHIFTED = AttachmentRegistry.create(
            BeyondOnesEyes.id("is_shifted"),
            builder -> builder
                    .initializer(() -> false) // The default value of the Attachment, if one has not been set.
                    .persistent(Codec.BOOL)
                    .syncWith(
                            ByteBufCodecs.BOOL,  // Dictates how to turn the data into a packet to send to clients.
                            AttachmentSyncPredicate.all() // Dictates who to send the data to.
                    )
    );

    public static void initialize() {

    }
}
