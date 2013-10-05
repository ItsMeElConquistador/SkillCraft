package elcon.mods.skillcraft;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import elcon.mods.core.ElConCore;
import elcon.mods.core.ElConMod;
import elcon.mods.skillcraft.commands.CommandSkill;
import elcon.mods.skillcraft.skills.PlayerSkill;
import elcon.mods.skillcraft.skills.SkillRegistry;
import elcon.mods.skillcraft.skills.types.SkillMining;

@Mod(modid = SCReference.MOD_ID, name = SCReference.NAME, version = SCReference.VERSION, acceptedMinecraftVersions = SCReference.MC_VERSION, dependencies = SCReference.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, serverPacketHandlerSpec = @SidedPacketHandler(packetHandler = SCPacketHandler.class, channels = {"SkillCraft"}), clientPacketHandlerSpec = @SidedPacketHandler(packetHandler = SCPacketHandlerClient.class, channels = {"SkillCraft"}))
public class SkillCraft {

	@Instance(SCReference.MOD_ID)
	public static SkillCraft instance;

	@SidedProxy(clientSide = SCReference.CLIENT_PROXY_CLASS, serverSide = SCReference.SERVER_PROXY_CLASS)
	public static SCCommonProxy proxy;

	public SCPacketHandler packetHandler;
	public SCTickHandlerClient tickHandlerClient;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ElConCore.registerMod(SCReference.NAME, new ElConMod(SCReference.NAME, SCReference.VERSION, SCReference.VERSION_URL, event.getSourceFile(), event.getSuggestedConfigurationFile(), SCConfig.class, new SCSaveHandler()));

		SCLog.init();

		PlayerSkill.calculateNeeded();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderInformation();

		//init tick handlers
		tickHandlerClient = new SCTickHandlerClient();

		//register packet handler
		packetHandler = new SCPacketHandler();
		NetworkRegistry.instance().registerConnectionHandler(packetHandler);

		//register event handler
		SCEventHandler eventHandler = new SCEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		//register skills
		SkillRegistry.registerSkill(new SkillMining());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandSkill());
	}
}
