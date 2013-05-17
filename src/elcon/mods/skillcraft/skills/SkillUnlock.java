package elcon.mods.skillcraft.skills;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class SkillUnlock {

	public int level;
	
	public int id = 0;
	
	public SkillUnlock(int level, int id) {
		this.level = level;
		this.id = id;
	}
	
	public boolean isBlock() {
		return Item.itemsList[id] instanceof ItemBlock;
	}
	
	public boolean isItem() {
		return !isBlock();
	}
}
