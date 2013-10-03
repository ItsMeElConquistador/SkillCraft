package elcon.mods.skillcraft;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class SCTickHandlerClient implements ITickHandler {

	public boolean initialized = false;

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if(type.contains(TickType.RENDER)) {

		}
		if(type.contains(TickType.CLIENT)) {
			
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
