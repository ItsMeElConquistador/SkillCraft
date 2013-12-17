package elcon.mods.skillcraft.skills;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Skill {

	public String name;
	
	public HashMap<String, ArrayList<SkillUnlock>> unlocks = new HashMap<String, ArrayList<SkillUnlock>>();
	
	public Skill(String name) {
		this.name = name;
		
		registerUnlocks();
	}
	
	public void registerUnlock(SkillUnlock unlock, String... unlockType) {
		for(int i = 0; i < unlockType.length; i++) {
			if(!unlocks.containsKey(unlockType[i])) {
				unlocks.put(unlockType[i], new ArrayList<SkillUnlock>());
			}
			ArrayList<SkillUnlock> unlockList = unlocks.get(unlockType[i]);
			unlockList.add(unlock);
		}
	}
	
	public abstract void registerUnlocks();
}
