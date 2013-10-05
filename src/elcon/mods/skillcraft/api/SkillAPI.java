package elcon.mods.skillcraft.api;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elcon.mods.skillcraft.skills.PlayerSkill;
import elcon.mods.skillcraft.skills.Skill;
import elcon.mods.skillcraft.skills.SkillClient;
import elcon.mods.skillcraft.skills.SkillRegistry;
import elcon.mods.skillcraft.skills.SkillServer;

public class SkillAPI {

	public static Set<String> getSkillNames() {
		return SkillRegistry.getSkillNames();
	}
	
	public static Collection<Skill> getSkills() {
		return SkillRegistry.getSkills();
	}
	
	public static Skill getSkill(String skillName) {
		return SkillRegistry.getSkill(skillName);
	}
	
	public static boolean hasSkill(String skillName) {
		return SkillRegistry.hasSkill(skillName);
	}
	
	public static void registerSkill(Skill skill) {
		SkillRegistry.registerSkill(skill);
	}
	
	public static void unregisterSkill(String skillName) {
		SkillRegistry.unregisterSkill(skillName);
	}
	
	public static HashMap<String, PlayerSkill> getPlayerSkills(String player) {
		return SkillServer.getPlayerSkills(player);
	}
	
	public static PlayerSkill getPlayerSkill(String player, String skill) {
		return SkillServer.getPlayerSkill(player, skill);
	}
	
	public static void addPlayerSkills(String player, HashMap<String, PlayerSkill> skills) {
		SkillServer.addPlayerSkills(player, skills);
	}
	
	public static void addPlayerSkill(String player, PlayerSkill skill) {
		SkillServer.addPlayerSkill(player, skill);
	}	
	
	public static void addExp(String player, String skill, int exp) {
		SkillServer.addExp(player, skill, exp);
	}
	
	public static void addLevels(String player, String skill, int levels) {
		SkillServer.addLevels(player, skill, levels);
	}
	
	public static boolean hasUnlocked(String player, String skill, String unlockType, Object... args) {
		return SkillServer.hasUnlocked(player, skill, unlockType, args);
	}
	
	@SideOnly(Side.CLIENT)
	public static HashMap<String, PlayerSkill> getPlayerSkillsClient(String player) {
		return SkillClient.getPlayerSkills(player);
	}
	
	@SideOnly(Side.CLIENT)
	public static PlayerSkill getPlayerSkillClient(String player, String skill) {
		return SkillClient.getPlayerSkill(player, skill);
	}
	
	@SideOnly(Side.CLIENT)
	public static void addPlayerSkillsClient(String player, HashMap<String, PlayerSkill> skills) {
		SkillClient.addPlayerSkills(player, skills);
	}
	
	@SideOnly(Side.CLIENT)
	public static void addPlayerSkillClient(String player, PlayerSkill skill) {
		SkillClient.addPlayerSkill(player, skill);
	}	
	
	@SideOnly(Side.CLIENT)
	public static void addExpClient(String player, String skill, int exp) {
		SkillClient.addExp(player, skill, exp);
	}
}
