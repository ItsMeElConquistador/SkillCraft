package elcon.mods.skillcraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import elcon.mods.skillcraft.gui.GuiSkill;
import elcon.mods.skillcraft.gui.GuiSkillOverview;

public class SCClientProxy extends SCCommonProxy {

	@Override
	public void registerRenderInformation() {
		//register client tick handler
		//TickRegistry.registerTickHandler(SkillCraft.instance.tickHandlerClient, Side.CLIENT);

		//register key handler
		KeyBindingRegistry.registerKeyBinding(new SCKeyHandler());
	}
	
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if(id == 0) {
			return new GuiSkillOverview();
		} else if(id == 1) {
			return new GuiSkill();
		}
		return null;
	}
}
