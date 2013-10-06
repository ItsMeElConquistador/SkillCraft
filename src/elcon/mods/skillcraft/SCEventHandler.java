package elcon.mods.skillcraft;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerEvent.HarvestCheck;
import elcon.mods.skillcraft.skills.SkillRegistry;
import elcon.mods.skillcraft.skills.SkillServer;

public class SCEventHandler {

	@ForgeSubscribe
	@Deprecated
	//TODO: Find a better place to hook
	public void onHarvestCheck(HarvestCheck event) {
		for(String skill : SkillRegistry.getSkillNames()) {
			if(!SkillServer.hasUnlocked(event.entityPlayer.username, skill, "BLOCK_BREAK", event.block.blockID, -1)) {
				event.success = false;
				break;
			}
			if(!SkillServer.hasUnlocked(event.entityPlayer.username, skill, "BLOCK_ALL", event.block.blockID, -1)) {
				event.success = false;
				break;
			}
		}
	}
}
