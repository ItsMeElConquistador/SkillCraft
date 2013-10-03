package elcon.mods.skillcraft.skills;

public class SkillUnlockBlock extends SkillUnlock {

	public int blockID;
	public int blockMetadata;
	
	public SkillUnlockBlock(int level, int blockID, int blockMetadata) {
		super(level);
		this.blockID = blockID;
		this.blockMetadata = blockMetadata;
	}
	
	@Override
	public UnlockResult isUnlocked(int currentLevel, Object... args) {
		if(args != null && args.length >= 2) {
			int id = ((Integer) args[0]).intValue();
			int metadata = ((Integer) args[1]).intValue();
			if(blockID == id && (blockMetadata == -1 || blockMetadata == metadata)) {
				return currentLevel >= level ? UnlockResult.ALLOW : UnlockResult.BLOCK;
			}
		}
		return UnlockResult.UNKOWN;
	}
}
