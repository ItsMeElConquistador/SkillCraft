package elcon.mods.skillcraft;

import cpw.mods.fml.client.registry.KeyBindingRegistry;

public class SCClientProxy extends SCCommonProxy {

	@Override
	public void registerRenderInformation() {
		//register client tick handler
		//TickRegistry.registerTickHandler(SkillCraft.instance.tickHandlerClient, Side.CLIENT);

		//register key handler
		KeyBindingRegistry.registerKeyBinding(new SCKeyHandler());
	}
}
