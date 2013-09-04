package elcon.mods.skillcraft;

import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLCommonHandler;

public class SCCommonProxy {

	public void registerRenderInformation() {
		
	}
	
	public MinecraftServer getMCServer() {
		return FMLCommonHandler.instance().getMinecraftServerInstance();
	}
}
