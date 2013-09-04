package elcon.mods.skillcraft.skills;

import java.util.ArrayList;

import elcon.mods.skillcraft.skills.types.SkillMining;

public class Skill {
	
	public static Skill[] skills = new Skill[32];
	
	public static int skillCount = 0;
	
	public static Skill mining = new SkillMining(0, "Mining");
	
	public int id;
	public String name;
	
	public ArrayList<SkillUnlock> unlocks = new ArrayList<SkillUnlock>();
	
	public Skill(int id, String name) {
		this.id = id;
		this.name = name;
		
		registerUnlocks();
		
		skillCount++;
		skills[id] = this;
	}
	
	public void registerUnlocks() {
		
	}
}
