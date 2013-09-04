package elcon.mods.skillcraft;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class SCTickHandlerClient implements ITickHandler {

	public boolean initialized = false;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = (EntityPlayer) mc.thePlayer;
		// long time = System.currentTimeMillis();

		if(type.contains(TickType.RENDER)) {

		}
		if(type.contains(TickType.CLIENT)) {
			if(SCConfig.DISPLAY_VERSION_RESULT && !initialized && SCVersion.getResult() == SCVersion.OUTDATED) {
				if(FMLClientHandler.instance().getClient().currentScreen == null) {
					if(SCVersion.getResult() != SCVersion.UNINITIALIZED || SCVersion.getResult() != SCVersion.FINAL_ERROR) {
						initialized = true;
						if(SCVersion.getResult() == SCVersion.OUTDATED) {
							FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().printChatMessage(SCVersion.getResultMessageForClient());
						}
					}
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER, TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return "SkillCraftTickHandler";
	}

}
