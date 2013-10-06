package elcon.mods.skillcraft.commands;

import elcon.mods.core.color.Color;
import elcon.mods.core.lang.LanguageManager;
import elcon.mods.skillcraft.skills.PlayerSkill;
import elcon.mods.skillcraft.skills.SkillRegistry;
import elcon.mods.skillcraft.skills.SkillServer;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.util.ChatMessageComponent;

public class CommandSkillInfo {

	public static void processCommand(ICommandSender commandSender, String[] args) {
		if(args.length > 0) {
			String skillName = args[0];
			if(SkillRegistry.getSkillNames().contains(skillName)) {
				PlayerSkill skill = SkillServer.getPlayerSkill(commandSender.getCommandSenderName(), skillName);
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(SCCommands.getHeader(20, skillName)));
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_YELLOW
						+ LanguageManager.getLocalization("skillcraft.level") + ": " + Color.TEXT_COLOR_PREFIX_AQUA
						+ Integer.toString(skill.level)));
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_YELLOW
						+ LanguageManager.getLocalization("skillcraft.exp") + ": " + Color.TEXT_COLOR_PREFIX_AQUA
						+ Integer.toString(skill.exp) + " / " + Integer.toString(skill.expNeeded)));
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_YELLOW
						+ LanguageManager.getLocalization("skillcraft.currentExp") + ": " + Color.TEXT_COLOR_PREFIX_AQUA
						+ Integer.toString(skill.currentExp) + " / " + Integer.toString(skill.currentExpNeeded)));
			} else {
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(Color.TEXT_COLOR_PREFIX_RED + LanguageManager.getLocalization("skillcraft.commands.skill.notfound") + " " + skillName));
			}
		} else {
			throw new WrongUsageException(SCCommands.COMMAND_INFO_USAGE);
		}
	}
}
