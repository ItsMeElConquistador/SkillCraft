package elcon.mods.skillcraft.api;

import java.util.Collection;
import java.util.Set;

import elcon.mods.skillcraft.skills.Skill;
import elcon.mods.skillcraft.skills.SkillRegistry;

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
}
