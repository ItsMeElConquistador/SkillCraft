package elcon.mods.skillcraft;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import elcon.mods.skillcraft.language.LanguageManager;
import elcon.mods.skillcraft.skills.PlayerSkill;

@Mod(modid = SCReference.MOD_ID, name = SCReference.NAME, version = SCReference.VERSION, acceptedMinecraftVersions = SCReference.MC_VERSION, dependencies = SCReference.DEPENDENCIES)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, packetHandler = SCPacketHandler.class, channels = {"SkillCraft"})
public class SkillCraft {

	@Instance(SCReference.MOD_ID)
	public static SkillCraft instance;

	@SidedProxy(clientSide = SCReference.CLIENT_PROXY_CLASS, serverSide = SCReference.SERVER_PROXY_CLASS)
	public static SCCommonProxy proxy;

	public SCPacketHandler packetHandler;
	public SCTickHandlerClient tickHandlerClient;

	public static File minecraftDir;
	public static File modContainerSource;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		minecraftDir = new File(event.getSuggestedConfigurationFile().getPath().replace("config\\SkillCraft.cfg", ""));
		modContainerSource = event.getSourceFile();
		LanguageManager.load();

		SCLog.init();

		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		SCConfig.load(config);

		SCVersion.execute();

		config.save();

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
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
