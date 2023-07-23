package satisfyu.beachparty.networking.packet;

import dev.architectury.networking.NetworkManager;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import satisfyu.beachparty.Beachparty;
import satisfyu.beachparty.block.RadioBlock;
import satisfyu.beachparty.util.RadioHelper;

public class TurnRadioS2CPacket implements NetworkManager.NetworkReceiver {
    @Override
    public void receive(FriendlyByteBuf buf, NetworkManager.PacketContext context) {
        BlockPos blockPos = buf.readBlockPos();
        int channel = buf.readInt();
        boolean on = buf.readBoolean();
        context.queue(() -> RadioHelper.setPlaying(blockPos, channel, on, on ? RadioBlock.DELAY : 0));
    }
}
