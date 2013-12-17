package elcon.mods.skillcraft.skills;

import net.minecraft.item.ItemStack;

public class SkillUnlockItem extends SkillUnlock {

	public int itemID;
	public int itemMetadata;
	
	public SkillUnlockItem(int level, int exp, int itemID, int itemMetadata) {
		super(level, exp);
		this.itemID = itemID;
		this.itemMetadata = itemMetadata;
	}
	
	@Override
	public UnlockResult hasUnlocked(String unlockType, int currentLevel, Object... args) {
		if(unlockType.equalsIgnoreCase("ITEM_HIT") || unlockType.equalsIgnoreCase("ITEM_HIT_BLOCK") || unlockType.equalsIgnoreCase("ITEM_RIGHT")) {
			if(args != null && args.length >= 1) {
				ItemStack stack = (ItemStack) args[0];
				if(itemID == stack.itemID && (stack.getItemDamage() == -1 || itemMetadata == -1 || itemMetadata == stack.getItemDamage())) {
					return currentLevel >= level ? UnlockResult.ALLOW : UnlockResult.BLOCK;
				}
			}
		}
		return UnlockResult.UNKOWN;
	}

	@Override
	public int getExpToGive(String unlockType, Object... args) {
		if(unlockType.equalsIgnoreCase("ITEM_HIT") || unlockType.equalsIgnoreCase("ITEM_HIT_BLOCK") || unlockType.equalsIgnoreCase("ITEM_RIGHT")) {
			if(args != null && args.length >= 1) {
				ItemStack stack = (ItemStack) args[0];
				if(itemID == stack.itemID && (stack.getItemDamage() == -1 || itemMetadata == -1 || itemMetadata == stack.getItemDamage())) {
					return exp;
				}
			}
		}
		return 0;
	}
}
