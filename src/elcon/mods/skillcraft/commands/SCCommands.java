package elcon.mods.skillcraft.commands;

import elcon.mods.core.color.Color;

public class SCCommands {

	public static final String COMMAND_SKILL = "skill";
	public static final String COMMAND_SKILL_USAGE = "/skill <help|list|info|exp|level|version>";
	public static final String COMMAND_HELP = "help";
	public static final String COMMAND_HELP_USAGE = "/skill help";
	public static final String COMMAND_LIST = "list";
	public static final String COMMAND_LIST_USAGE = "/skill list";
	public static final String COMMAND_INFO = "info";
	public static final String COMMAND_INFO_USAGE = "/skill info <skill>";
	public static final String COMMAND_EXP = "exp";
	public static final String COMMAND_EXP_USAGE = "/skill exp <skill> <exp> [player]";
	public static final String COMMAND_LEVEL = "level";
	public static final String COMMAND_LEVEL_USAGE = "/skill level <skill> <level> [player]";
	
	public static final String COMMAND_VERSION = "version";
	public static final String COMMAND_VERSION_USAGE = "/skill version";
	
	public static String getHeader(int maxSize, String title) {
		StringBuilder sb = new StringBuilder();
		sb.append(Color.TEXT_COLOR_PREFIX_GOLD);
		sb.append(".oOo.=");
		int size = (int) Math.floor((maxSize - title.length()) / 2);
		for(int i = 0; i < size; i++) {
			sb.append("=");
		}
		sb.append(" ");
		sb.append(Color.TEXT_COLOR_PREFIX_YELLOW);
		sb.append(title);
		sb.append(Color.TEXT_COLOR_PREFIX_GOLD);
		sb.append(" ");
		for(int i = 0; i < size; i++) {
			sb.append("=");
		}
		sb.append("=.o0o.");
		return sb.toString();
	}
}
