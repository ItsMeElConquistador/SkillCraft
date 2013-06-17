package elcon.mods.skillcraft;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.world.WorldEvent;

public class SCEventHandler {

	@ForgeSubscribe
	public void worldLoad(WorldEvent.Load event) {
		if(event.world.isRemote) {
			return;
		}
		SCSaveHandler sm = new SCSaveHandler(event.world.getSaveHandler(), event.world);
		sm.loadSkills();
	}
	
	@ForgeSubscribe
	public void worldSave(WorldEvent.Save event) {
		if(event.world.isRemote) {
			return;
		}
		SCSaveHandler sm = new SCSaveHandler(event.world.getSaveHandler(), event.world);
		sm.saveSkills();
	}
}
