package elcon.mods.skillcraft.skills.types;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import elcon.mods.skillcraft.skills.Skill;
import elcon.mods.skillcraft.skills.SkillUnlockBlock;
import elcon.mods.skillcraft.skills.SkillUnlockItem;

public class SkillMining extends Skill {

	public SkillMining(String name) {
		super(name);
	}

	@Override
	public void registerUnlocks() {
		registerUnlock("BLOCK_ALL", new SkillUnlockBlock(1, Block.stone.blockID, -1));
		registerUnlock("BLOCK_ALL", new SkillUnlockBlock(1, Block.oreCoal.blockID, -1));
		registerUnlock("BLOCK_ALL", new SkillUnlockBlock(5, Block.oreIron.blockID, -1));
		
		registerUnlock("ITEM_ALL", new SkillUnlockItem(1, Item.pickaxeWood.itemID, -1));
		registerUnlock("ITEM_ALL", new SkillUnlockItem(5, Item.pickaxeStone.itemID, -1));
	}
}
