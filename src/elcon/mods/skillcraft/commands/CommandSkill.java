package elcon.mods.skillcraft.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

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
				
			}
		}
	}
}
