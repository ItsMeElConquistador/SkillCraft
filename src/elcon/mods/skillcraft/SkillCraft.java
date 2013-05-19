package elcon.mods.skillcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "SkillCraft", name = "SkillCraft", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class SkillCraft {

	@Instance("SkillCraft")
	public static SkillCraft instance;
	
	@SidedProxy(clientSide = "elcon.mods.skillcraft.ClientProxy", serverSide = "elcon.mods.skillcraft.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		PlayerSkill.calculateNeeded();
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderInformation();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
