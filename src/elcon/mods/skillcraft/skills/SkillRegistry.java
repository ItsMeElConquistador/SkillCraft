package elcon.mods.skillcraft.skills;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import elcon.mods.skillcraft.SCLog;

public class SkillRegistry {

	private static HashMap<String, Skill> skills = new HashMap<String, Skill>();
	
	public static Set<String> getSkillNames() {
		return skills.keySet();
	}
	
	public static Collection<Skill> getSkills() {
		return skills.values();
	}
	
	public static Skill getSkill(String skillName) {
		if(skills.containsKey(skillName)) {
			return skills.get(skillName);
		}
		return null;
	}
	
	public static boolean hasSkill(String skillName) {
		return skills.containsKey(skillName);
	}
	
	public static void registerSkill(Skill skill) {
		if(skills.containsKey(skill.name)) {
			SCLog.warning("[SkillRegistry] Overriding skill: " + skill.name);
		}
		skills.put(skill.name, skill);
	}
	
	public static void unregisterSkill(String skillName) {
		if(skills.containsKey(skillName)) {
			skills.remove(skillName);
		}
	}
}
