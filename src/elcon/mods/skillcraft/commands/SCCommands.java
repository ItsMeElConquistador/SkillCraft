package elcon.mods.skillcraft.commands;

public class SCCommands {

	public static final String COMMAND_SKILL = "skill";
	public static final String COMMAND_SKILL_USAGE = "/skill <list|info|version>";
	public static final String COMMAND_LIST = "list";
	public static final String COMMAND_INFO = "info";
	public static final String COMMAND_INFO_USAGE = "/skill info <skill>";
	
	public static final String COMMAND_VERSION = "version";
	
	public static String getHeader(String title) {
		StringBuilder sb = new StringBuilder();
		sb.append(".oOo.=");
		int size = (int) Math.floor((20 - title.length()) / 2);
		for(int i = 0; i < size; i++) {
			sb.append("=");
		}
		sb.append(" ");
		sb.append(title);
		sb.append(" ");
		for(int i = 0; i < size; i++) {
			sb.append("=");
		}
		sb.append("=.o0o.");
		return sb.toString();
	}
}
