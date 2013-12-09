package elcon.mods.skillcraft.skills;

public abstract class SkillUnlock {

	public static enum UnlockResult {
		ALLOW,
		BLOCK,
		UNKOWN
	}
	
	public int level;
	public int exp;
	
	public SkillUnlock(int level, int exp) {
		this.level = level;
		this.exp = exp;
	}
	
	public abstract UnlockResult hasUnlocked(String unlockType, int currentLevel, Object... args);
	
	public abstract int getExpToGive(String unlockType, Object... args);
}
