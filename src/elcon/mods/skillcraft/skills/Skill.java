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
	
	public void registerUnlock(String unlockType, SkillUnlock unlock) {
		if(!unlocks.containsKey(unlockType)) {
			unlocks.put(unlockType, new ArrayList<SkillUnlock>());
		}
		ArrayList<SkillUnlock> unlockList = unlocks.get(unlockType);
		unlockList.add(unlock);
	}
	
	public abstract void registerUnlocks();
}
