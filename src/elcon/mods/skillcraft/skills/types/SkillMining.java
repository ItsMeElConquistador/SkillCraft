package elcon.mods.skillcraft.skills.types;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import elcon.mods.skillcraft.skills.Skill;
import elcon.mods.skillcraft.skills.SkillUnlockBlock;
import elcon.mods.skillcraft.skills.SkillUnlockItem;

public class SkillMining extends Skill {

	public SkillMining() {
		super("Mining");
	}

	@Override
	public void registerUnlocks() {
		registerUnlock(new SkillUnlockBlock(1, 5, Block.stone.blockID, -1), "BLOCK_BREAK", "BLOCK_PLACE");
		registerUnlock(new SkillUnlockBlock(1, 10, Block.oreCoal.blockID, -1), "BLOCK_BREAK", "BLOCK_PLACE");
		registerUnlock(new SkillUnlockBlock(5, 20, Block.oreIron.blockID, -1), "BLOCK_BREAK", "BLOCK_PLACE");
		
		registerUnlock(new SkillUnlockItem(1, 0, Item.pickaxeWood.itemID, -1), "ITEM_HIT", "ITEM_HIT_BLOCK", "ITEM_RIGHT");
		registerUnlock(new SkillUnlockItem(5, 0, Item.pickaxeStone.itemID, -1), "ITEM_HIT", "ITEM_HIT_BLOCK", "ITEM_RIGHT");
	}
}
