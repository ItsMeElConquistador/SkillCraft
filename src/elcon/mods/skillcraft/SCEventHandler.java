package elcon.mods.skillcraft;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import elcon.mods.skillcraft.skills.SkillRegistry;
import elcon.mods.skillcraft.skills.SkillServer;

public class SCEventHandler {
	
	@ForgeSubscribe
	public void onBlockBreak(BreakEvent event) {
		String playerName = event.getPlayer().username;
		int blockID = event.block.blockID;
		int blockMetadata = event.blockMetadata;
		for(String skill : SkillRegistry.getSkillNames()) {
			if(!SkillServer.hasUnlocked(playerName, skill, "BLOCK_BREAK", event.world, event.x, event.y, event.z, blockID, blockMetadata)) {
				event.setCanceled(true);
				return;
			}
		}
		for(String skill : SkillRegistry.getSkillNames()) {
			int exp = SkillServer.getExpToGive(playerName, skill, "BLOCK_BREAK", event.world, event.x, event.y, event.z, blockID, blockMetadata);
			if(exp == 0) {
				continue;
			}
			SkillServer.addExp(playerName, skill, exp);
		}
	}
	
	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.entityPlayer.inventory.getCurrentItem() != null) {
			String playerName = event.entityPlayer.username;
			ItemStack stack = event.entityPlayer.inventory.getCurrentItem();
			if(event.action == Action.LEFT_CLICK_BLOCK) {
				for(String skill : SkillRegistry.getSkillNames()) {
					if(!SkillServer.hasUnlocked(playerName, skill, "ITEM_HIT_BLOCK", event.entityPlayer.worldObj, event.x, event.y, event.z, stack)) {
						event.setCanceled(true);
						return;
					}
				}
			} else if(event.action == Action.RIGHT_CLICK_BLOCK) {
				String eventName = event.entityPlayer.isSneaking() ? "ITEM_RIGHT" : "BLOCK_ACTIVATE";
				Object[] args = new Object[]{event.entityPlayer.isSneaking() ? stack : event.entityPlayer.worldObj, event.x, event.y, event.z};
				for(String skill : SkillRegistry.getSkillNames()) {
					if(!SkillServer.hasUnlocked(playerName, skill, eventName, stack)) {
						event.setCanceled(true);
						return;
					}
				}
				if(event.entityPlayer.isSneaking()) {
					for(String skill : SkillRegistry.getSkillNames()) {
						int exp = SkillServer.getExpToGive(playerName, skill, "ITEM_RIGHT", args);
						if(exp == 0) {
							continue;
						}
						SkillServer.addExp(playerName, skill, exp);
					}
				}
			} else if(event.action == Action.RIGHT_CLICK_AIR) {
				for(String skill : SkillRegistry.getSkillNames()) {
					if(!SkillServer.hasUnlocked(playerName, skill, "ITEM_RIGHT", stack)) {
						event.setCanceled(true);
						return;
					}
				}
				if(event.entityPlayer.isSneaking()) {
					for(String skill : SkillRegistry.getSkillNames()) {
						int exp = SkillServer.getExpToGive(playerName, skill, "ITEM_RIGHT", stack);
						if(exp == 0) {
							continue;
						}
						SkillServer.addExp(playerName, skill, exp);
					}
				}
			}
		}
	}
	
	@ForgeSubscribe
	public void onPlayerAttackEntity(AttackEntityEvent event) {
		
	}
}
