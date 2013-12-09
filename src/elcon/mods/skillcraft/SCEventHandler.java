package elcon.mods.skillcraft;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import elcon.mods.skillcraft.skills.SkillRegistry;
import elcon.mods.skillcraft.skills.SkillServer;

public class SCEventHandler {
	
	@ForgeSubscribe
	public void onBlockBreak(BreakEvent event) {
		for(String skill : SkillRegistry.getSkillNames()) {
			if(!SkillServer.hasUnlocked(event.getPlayer().username, skill, "BLOCK_BREAK", event.block.blockID, event.blockMetadata)) {
				event.setCanceled(true);
				return;
			}
			if(!SkillServer.hasUnlocked(event.getPlayer().username, skill, "BLOCK_ALL", event.block.blockID, event.blockMetadata)) {
				event.setCanceled(true);
				return;
			}
		}
		for(String skill : SkillRegistry.getSkillNames()) {
			int exp = SkillServer.getExpToGive(event.getPlayer().username, skill, "BLOCK_BREAK", event.block.blockID, event.blockMetadata);
			if(exp == 0) {
				continue;
			}
			SkillServer.addExp(event.getPlayer().username, skill, exp);
		}
	}
}
