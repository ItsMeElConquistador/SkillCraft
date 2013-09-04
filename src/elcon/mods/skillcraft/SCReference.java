package elcon.mods.skillcraft;

public class SCReference {

	public static final boolean DEBUG_MODE = true;
	
	public static final String MOD_ID = "SkillCraft";
	public static final String NAME = "SkillCraft";
	public static final String VERSION = "@VERSION@ (build @BUILD_NUMBER@)";
	public static final String MC_VERSION = "[1.6.2]";
	public static final String DEPENDENCIES = "required-after:Forge@[9.10.0.799,)";
	public static final String SERVER_PROXY_CLASS = "elcon.mods.skillcraft.SCCommonProxy";
    public static final String CLIENT_PROXY_CLASS = "elcon.mods.skillcraft.SCClientProxy";
    
    public static final int VERSION_CHECK_ATTEMPTS = 3;
}
