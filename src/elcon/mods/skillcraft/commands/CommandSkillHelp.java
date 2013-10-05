package elcon.mods.skillcraft.commands;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import elcon.mods.core.color.Color;
import elcon.mods.core.lang.LanguageManager;

public class CommandSkillHelp {

	public static void processCommand(ICommandSender commandSender, String[] args) {
		commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(SCCommands.getHeader(30, LanguageManager.getLocalization("skillcraft.commands.skill.help"))));
		commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_GOLD + SCCommands.COMMAND_HELP_USAGE + " " + Color.TEXT_COLOR_PREFIX_YELLOW + LanguageManager.getLocalization("skillcraft.commands.skill.help.description")));
		commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_GOLD + SCCommands.COMMAND_LIST_USAGE + " " + Color.TEXT_COLOR_PREFIX_YELLOW + LanguageManager.getLocalization("skillcraft.commands.skill.list.description")));
		commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_GOLD + SCCommands.COMMAND_INFO_USAGE + " " + Color.TEXT_COLOR_PREFIX_YELLOW + LanguageManager.getLocalization("skillcraft.commands.skill.info.description")));
		commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_GOLD + SCCommands.COMMAND_EXP_USAGE + " " + Color.TEXT_COLOR_PREFIX_YELLOW + LanguageManager.getLocalization("skillcraft.commands.skill.exp.description")));
		commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_GOLD + SCCommands.COMMAND_LEVEL_USAGE + " " + Color.TEXT_COLOR_PREFIX_YELLOW + LanguageManager.getLocalization("skillcraft.commands.skill.level.description")));
		commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_GOLD + SCCommands.COMMAND_VERSION_USAGE + " " + Color.TEXT_COLOR_PREFIX_YELLOW + LanguageManager.getLocalization("skillcraft.commands.skill.version.description")));
	}
}
