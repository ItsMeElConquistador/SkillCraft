package elcon.mods.skillcraft.commands;

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
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(SCCommands.getHeader(skillName)));
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(LanguageManager.getLocalization("skillcraft.commands.skill.info.line1")
						.replaceAll("%l", Integer.toString(skill.level))
						.replaceAll("%e", Integer.toString(skill.exp))
						.replaceAll("%t", Integer.toString(skill.expNeeded))));
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(LanguageManager.getLocalization("skillcraft.commands.skill.info.line2")
						.replaceAll("%e", Integer.toString(skill.currentExp))
						.replaceAll("%t", Integer.toString(skill.currentExpNeeded))));
			} else {
				commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(LanguageManager.getLocalization("skillcraft.commands.skill.notfound") + " " + skillName));
			}
		} else {
			throw new WrongUsageException(SCCommands.COMMAND_INFO_USAGE);
		}
	}
}
