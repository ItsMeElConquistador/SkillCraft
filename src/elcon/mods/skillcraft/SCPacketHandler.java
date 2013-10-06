package elcon.mods.skillcraft;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import elcon.mods.skillcraft.skills.PlayerSkill;
import elcon.mods.skillcraft.skills.SkillServer;

public class SCPacketHandler implements IPacketHandler, IConnectionHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		
	}
	
	public static Packet getSkillUpdatePacket(String player, String skillName) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(bos);
			Packet250CustomPayload packet = new Packet250CustomPayload();
			dos.writeByte(0);
			dos.writeUTF(player);
			PlayerSkill skill = SkillServer.getPlayerSkills(player).get(skillName);
			dos.writeUTF(skill.skillName);
			dos.writeInt(skill.level);
			dos.writeInt(skill.exp);
			dos.close();
			packet.channel = "SkillCraft";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			packet.isChunkDataPacket = false;
			return packet;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Packet getAllSkillsUpdatePacket(String player) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(bos);
			Packet250CustomPayload packet = new Packet250CustomPayload();
			dos.writeByte(1);
			dos.writeUTF(player);
			HashMap<String, PlayerSkill> skills = SkillServer.getPlayerSkills(player);
			dos.writeInt(skills.size());
			for(PlayerSkill skill : skills.values()) {
				dos.writeUTF(skill.skillName);
				dos.writeInt(skill.level);
				dos.writeInt(skill.exp);
			}
			dos.close();
			packet.channel = "SkillCraft";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			packet.isChunkDataPacket = false;
			return packet;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Packet getSkillAllUpdatePacket() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(bos);
			Packet250CustomPayload packet = new Packet250CustomPayload();
			dos.writeByte(2);
			dos.writeInt(SkillServer.players.size());
			for(String player : SkillServer.players.keySet()) {
				dos.writeUTF(player);
				HashMap<String, PlayerSkill> skills = SkillServer.getPlayerSkills(player);
				dos.writeInt(skills.size());
				for(PlayerSkill skill : skills.values()) {
					dos.writeUTF(skill.skillName);
					dos.writeInt(skill.level);
					dos.writeInt(skill.exp);
				}
			}
			dos.close();
			packet.channel = "SkillCraft";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			packet.isChunkDataPacket = false;
			return packet;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	//SERVER SIDE
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) {
		PacketDispatcher.sendPacketToPlayer(getSkillAllUpdatePacket(), player);
		PacketDispatcher.sendPacketToAllPlayers(getAllSkillsUpdatePacket(netHandler.getPlayer().username));
		SCLog.info("Send all skills to " + netHandler.getPlayer().username);
	}

	@Override
	//SERVER SIDE
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
		return null;
	}

	@Override
	//CLIENT SIDE
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) {
	}

	@Override
	//CLIENT SIDE
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) {
	}

	@Override
	//CLIENT
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) {
	}
	
	@Override
	//BOTH SIDES
	public void connectionClosed(INetworkManager manager) {
	}
}
