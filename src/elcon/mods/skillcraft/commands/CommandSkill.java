package elcon.mods.skillcraft.commands;

import elcon.mods.core.ElConCore;
import elcon.mods.core.color.Color;
import elcon.mods.core.lang.LanguageManager;
import elcon.mods.skillcraft.SCReference;
import elcon.mods.skillcraft.skills.SkillServer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatMessageComponent;

public class CommandSkill extends CommandBase {

	@Override
	public String getCommandName() {
		return SCCommands.COMMAND_SKILL;
	}

	@Override
	public String getCommandUsage(ICommandSender commandSender) {
		return SCCommands.COMMAND_SKILL_USAGE;
	}

	@Override
	public void processCommand(ICommandSender commandSender, String[] args) {
		if(args.length > 0) {
			String commandName = args[0];
			System.arraycopy(args, 1, args, 0, args.length - 1);
			if(commandName.equalsIgnoreCase(SCCommands.COMMAND_LIST)) {
				CommandSkillList.processCommand(commandSender, args);
			} else if(commandName.equalsIgnoreCase(SCCommands.COMMAND_INFO)) {
				CommandSkillInfo.processCommand(commandSender, args);
			} else if(commandName.equalsIgnoreCase(SCCommands.COMMAND_EXP)) {
				if(args.length >= 2) {
					SkillServer.getPlayerSkill(args.length >= 3 ? args[2] : commandSender.getCommandSenderName(), args[0]).addExp(Integer.parseInt(args[1]));
					commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(LanguageManager.getLocalization("skillcraft.commands.skill.exp").replaceAll("%e", args[1]).replaceAll("%s", args[0]).replaceAll("%p", args.length >= 3 ? args[2] : commandSender.getCommandSenderName())));
				} else {
					throw new WrongUsageException(SCCommands.COMMAND_EXP_USAGE);
				}
			} else if(commandName.equalsIgnoreCase(SCCommands.COMMAND_LEVEL)) {
				if(args.length >= 2) {
					SkillServer.getPlayerSkill(args.length >= 3 ? args[2] : commandSender.getCommandSenderName(), args[0]).addLevels(Integer.parseInt(args[1]));
					commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(LanguageManager.getLocalization("skillcraft.commands.skill.level").replaceAll("%l", args[1]).replaceAll("%s", args[0]).replaceAll("%p", args.length >= 3 ? args[2] : commandSender.getCommandSenderName())));
				} else {
					throw new WrongUsageException(SCCommands.COMMAND_LEVEL_USAGE);
				}
			} else if(commandName.equalsIgnoreCase(SCCommands.COMMAND_VERSION)) {
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_GOLD + LanguageManager.getLocalization("skillcraft.commands.skill.version") + " " + Color.TEXT_COLOR_PREFIX_YELLOW + ElConCore.mods.get(SCReference.MOD_ID).version));
			} else if(commandName.equalsIgnoreCase(SCCommands.COMMAND_HELP)) {
				CommandSkillHelp.processCommand(commandSender, args);
			} else {
				throw new WrongUsageException(getCommandUsage(commandSender));
			}
		} else {
			CommandSkillHelp.processCommand(commandSender, args);
		}
	}
}
