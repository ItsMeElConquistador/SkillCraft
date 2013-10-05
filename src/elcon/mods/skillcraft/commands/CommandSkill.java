package elcon.mods.skillcraft.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

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
			} else if(commandName.equalsIgnoreCase(SCCommands.COMMAND_VERSION)) {
				CommandVersion.processCommand(commandSender, args);
			} else {
				throw new WrongUsageException(getCommandUsage(commandSender));
			}
		} else {
			throw new WrongUsageException(getCommandUsage(commandSender));
		}
	}
}
