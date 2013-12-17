package elcon.mods.skillcraft.skills;

public class SkillUnlockBlock extends SkillUnlock {

	public int blockID;
	public int blockMetadata;
	
	public SkillUnlockBlock(int level, int exp, int blockID, int blockMetadata) {
		super(level, exp);
		this.blockID = blockID;
		this.blockMetadata = blockMetadata;
	}
	
	@Override
	public UnlockResult hasUnlocked(String unlockType, int currentLevel, Object... args) {
		if(unlockType.equalsIgnoreCase("BLOCK_BREAK") || unlockType.equalsIgnoreCase("BLOCK_PLACE") || unlockType.equalsIgnoreCase("BLOCK_ACTIVE")) {
			if(args != null && args.length >= 6) {
				int id = ((Integer) args[4]).intValue();
				int metadata = ((Integer) args[5]).intValue();
				if(blockID == id && (metadata == -1 || blockMetadata == -1 || blockMetadata == metadata)) {
					return currentLevel >= level ? UnlockResult.ALLOW : UnlockResult.BLOCK;
				}
			}
		}
		return UnlockResult.UNKOWN;
	}

	@Override
	public int getExpToGive(String unlockType, Object... args) {
		if(unlockType.equalsIgnoreCase("BLOCK_BREAK") || unlockType.equalsIgnoreCase("BLOCK_PLACE") || unlockType.equalsIgnoreCase("BLOCK_ACTIVE")) {
			if(args != null && args.length >= 6) {
				int id = ((Integer) args[4]).intValue();
				int metadata = ((Integer) args[5]).intValue();
				if(blockID == id && (metadata == -1 || blockMetadata == -1 || blockMetadata == metadata)) {
					return exp;
				}
			}
		}
		return 0;
	}
}
