package elcon.mods.skillcraft.skills;

public class SkillUnlockItem extends SkillUnlock {

	public int itemID;
	public int itemMetadata;
	
	public SkillUnlockItem(int level, int itemID, int itemMetadata) {
		super(level);
		this.itemID = itemID;
		this.itemMetadata = itemMetadata;
	}
	
	@Override
	public UnlockResult isUnlocked(int currentLevel, Object... args) {
		if(args != null && args.length >= 2) {
			int id = ((Integer) args[0]).intValue();
			int metadata = ((Integer) args[1]).intValue();
			if(itemID == id && (itemMetadata == -1 || itemMetadata == metadata)) {
				return currentLevel >= level ? UnlockResult.ALLOW : UnlockResult.BLOCK;
			}
		}
		return UnlockResult.UNKOWN;
	}
}
