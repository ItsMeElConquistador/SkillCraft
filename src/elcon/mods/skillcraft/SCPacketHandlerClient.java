package elcon.mods.skillcraft;

import java.util.HashMap;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elcon.mods.skillcraft.skills.PlayerSkill;
import elcon.mods.skillcraft.skills.SkillClient;

@SideOnly(Side.CLIENT)
public class SCPacketHandlerClient implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		byte packetID = dat.readByte();
		switch(packetID) {
		case 0: 
			handleSkillUpdate(dat);
			break;
		case 1: 
			handleAllSkillsUpdate(dat);
			break;
		case 2:
			handleSkillAllUpdate(dat);
			break;
		}
	}
	
	private void handleSkillUpdate(ByteArrayDataInput dat) {
		SkillClient.addPlayerSkill(dat.readUTF(), new PlayerSkill(dat.readUTF(), dat.readInt(), dat.readInt()));
	}

	private void handleAllSkillsUpdate(ByteArrayDataInput dat) {
		String player = dat.readUTF();
		int size = dat.readInt();
		HashMap<String, PlayerSkill> skills = new HashMap<String, PlayerSkill>();
		for(int i = 0; i < size; i++) {
			String name = dat.readUTF();
			skills.put(name, new PlayerSkill(name, dat.readInt(), dat.readInt()));
		}
		SkillClient.addPlayerSkills(player, skills);
	}

	private void handleSkillAllUpdate(ByteArrayDataInput dat) {
		int playerSize = dat.readInt();
		for(int i = 0; i < playerSize; i++) {
			String player = dat.readUTF();
			int size = dat.readInt();
			HashMap<String, PlayerSkill> skills = new HashMap<String, PlayerSkill>();
			for(int j = 0; j < size; j++) {
				String name = dat.readUTF();
				skills.put(name, new PlayerSkill(name, dat.readInt(), dat.readInt()));
			}
			SkillClient.addPlayerSkills(player, skills);
		}
	}
}
