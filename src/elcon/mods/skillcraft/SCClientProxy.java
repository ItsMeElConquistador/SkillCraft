package elcon.mods.skillcraft;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class SCClientProxy extends SCCommonProxy {

	@Override
	public void registerRenderInformation() {
		//register client tick handler
		TickRegistry.registerTickHandler(SkillCraft.instance.tickHandlerClient, Side.CLIENT);

		//register key handler
		KeyBindingRegistry.registerKeyBinding(new SCKeyHandler());
	}
}
