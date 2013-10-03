package elcon.mods.skillcraft.skills;

public abstract class SkillUnlock {

	public static enum UnlockResult {
		ALLOW,
		BLOCK,
		UNKOWN
	}
	
	public int level;
	
	public SkillUnlock(int level) {
		this.level = level;
	}
	
	public abstract UnlockResult isUnlocked(int currentLevel, Object... args);
}
