package elcon.mods.skillcraft.skills;

import java.io.Serializable;


public class SkillPlayer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String player;
	public PlayerSkill[] skills = new PlayerSkill[Skill.skills.length];
	
	public SkillPlayer(String player) {
		this.player = player;
	}
	
	public void init() {
		for(int i = 0; i < Skill.skills.length; i++) {
			if(Skill.skills[i] != null) {
				skills[i] = new PlayerSkill(i);
			}
		}
	}
}
