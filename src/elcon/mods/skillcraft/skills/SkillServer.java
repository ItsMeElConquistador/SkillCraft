package elcon.mods.skillcraft.skills;

import java.util.ArrayList;
import java.util.HashMap;

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
		}
		return players.get(player);
	}
	
	public static PlayerSkill getPlayerSkill(String player, String skill) {
		HashMap<String, PlayerSkill> skills = getPlayerSkills(player);
		if(!skills.containsKey(skill)) {
			skills.put(skill, new PlayerSkill(skill));
		}
		return skills.get(skill);
	}
	
	public static void addPlayerSkills(String player, HashMap<String, PlayerSkill> skills) {
		players.put(player, skills);
	}
	
	public static void addPlayerSkill(String player, PlayerSkill skill) {
		getPlayerSkills(player).put(skill.skillName, skill);
	}

	public static void addExp(String player, String skill, int exp) {
		getPlayerSkill(player, skill).addExp(exp);
	}
	
	public static void addLevels(String player, String skill, int levels) {
		getPlayerSkill(player, skill).addLevels(levels);
	}
	
	public static boolean hasUnlocked(String player, String skill, String unlockType, Object... args) {
		int level = getPlayerSkill(player, skill).level;
		ArrayList<SkillUnlock> unlocks = SkillRegistry.getSkill(skill).unlocks.get(unlockType);
		for(SkillUnlock unlock : unlocks) {
			if(unlock.hasUnlocked(unlockType, level, args) == UnlockResult.BLOCK) {
				return false;
			}
		}
		return true;
	}
}
