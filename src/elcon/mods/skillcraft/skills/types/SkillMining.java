package elcon.mods.skillcraft.skills.types;

import elcon.mods.skillcraft.skills.Skill;
import elcon.mods.skillcraft.skills.SkillUnlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class SkillMining extends Skill {

	public SkillMining(int id, String name) {
		super(id, name);
	}

	@Override
	public void registerUnlocks() {
		unlocks.add(new SkillUnlock(1, Block.stone.blockID));
		unlocks.add(new SkillUnlock(1, Block.oreCoal.blockID));
		unlocks.add(new SkillUnlock(5, Block.oreIron.blockID));
		
		unlocks.add(new SkillUnlock(1, Item.pickaxeWood.itemID));
		unlocks.add(new SkillUnlock(5, Item.pickaxeStone.itemID));
	}
}
