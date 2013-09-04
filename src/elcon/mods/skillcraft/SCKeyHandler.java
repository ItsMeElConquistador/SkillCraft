package elcon.mods.skillcraft;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class SCKeyHandler extends KeyHandler {

	public static KeyBinding skillOverview = new KeyBinding("Skills", Keyboard.KEY_F);
	
	public SCKeyHandler() {
		super(new KeyBinding[]{skillOverview}, new boolean[]{false});
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		if(Minecraft.getMinecraft().currentScreen == null) {
			if(kb.keyCode == skillOverview.keyCode) {
				//Minecraft.getMinecraft().displayGuiScreen(new GuiSkillOverview());
			}
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}
	
	@Override
	public String getLabel() {
		return "SkillCraftKeyHandler";
	}
}
