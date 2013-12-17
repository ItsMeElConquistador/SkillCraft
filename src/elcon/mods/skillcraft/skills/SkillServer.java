package elcon.mods.skillcraft.skills;

import java.util.ArrayList;
import java.util.HashMap;

import cpw.mods.fml.common.network.PacketDispatcher;

import elcon.mods.skillcraft.SCPacketHandler;
import elcon.mods.skillcraft.skills.SkillUnlock.UnlockResult;

public class SkillServer {

	public static HashMap<String, HashMap<String, PlayerSkill>> players = new HashMap<String, HashMap<String, PlayerSkill>>();
	
	public static HashMap<String, PlayerSkill> getPlayerSkills(String player) {
		if(!players.containsKey(player)) {
			HashMap<String, PlayerSkill> skills = new HashMap<String, PlayerSkill>();
			for(String skillName : SkillRegistry.getSkillNames()) {
				skills.put(skillName, new PlayerSkill(skillName));
			}
			players.put(player, skills);
			PacketDispatcher.sendPacketToAllPlayers(SCPacketHandler.getAllSkillsUpdatePacket(player));
		}
		return players.get(player);
	}
	
	public static PlayerSkill getPlayerSkill(String player, String skill) {
		HashMap<String, PlayerSkill> skills = getPlayerSkills(player);
		if(!skills.containsKey(skill)) {
			skills.put(skill, new PlayerSkill(skill));
			PacketDispatcher.sendPacketToAllPlayers(SCPacketHandler.getSkillUpdatePacket(player, skill));
		}
		return skills.get(skill);
	}
	
	public static void addPlayerSkills(String player, HashMap<String, PlayerSkill> skills) {
		players.put(player, skills);
		PacketDispatcher.sendPacketToAllPlayers(SCPacketHandler.getAllSkillsUpdatePacket(player));
	}
	
	public static void addPlayerSkill(String player, PlayerSkill skill) {
		getPlayerSkills(player).put(skill.skillName, skill);
		PacketDispatcher.sendPacketToAllPlayers(SCPacketHandler.getSkillUpdatePacket(player, skill.skillName));
	}

	public static void addExp(String player, String skill, int exp) {
		getPlayerSkill(player, skill).addExp(exp);
		PacketDispatcher.sendPacketToAllPlayers(SCPacketHandler.getSkillUpdatePacket(player, skill));
	}
	
	public static void addLevels(String player, String skill, int levels) {
		getPlayerSkill(player, skill).addLevels(levels);
		PacketDispatcher.sendPacketToAllPlayers(SCPacketHandler.getSkillUpdatePacket(player, skill));
	}
	
	public static boolean hasUnlocked(String player, String skill, String unlockType, Object... args) {
		int level = getPlayerSkill(player, skill).level;
		ArrayList<SkillUnlock> unlocks = SkillRegistry.getSkill(skill).unlocks.get(unlockType);
		if(unlocks != null) {
			for(SkillUnlock unlock : unlocks) {
				if(unlock.hasUnlocked(unlockType, level, args) == UnlockResult.BLOCK) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static int getExpToGive(String player, String skill, String unlockType, Object... args) {
		int exp = 0;
		ArrayList<SkillUnlock> unlocks = SkillRegistry.getSkill(skill).unlocks.get(unlockType);
		if(unlocks != null) {
			for(SkillUnlock unlock : unlocks) {
				exp += unlock.getExpToGive(unlockType, args);
			}
		}
		return exp;
	}
}
