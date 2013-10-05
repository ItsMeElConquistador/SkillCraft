package elcon.mods.skillcraft.skills;

import java.util.HashMap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SkillClient {

	public static HashMap<String, HashMap<String, PlayerSkill>> players = new HashMap<String, HashMap<String, PlayerSkill>>();
	
	public static HashMap<String, PlayerSkill> getPlayerSkills(String player) {
		if(!players.containsKey(player)) {
			players.put(player, new HashMap<String, PlayerSkill>());
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
}
