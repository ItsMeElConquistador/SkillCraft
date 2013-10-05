package elcon.mods.skillcraft.commands;

import elcon.mods.core.lang.LanguageManager;
import elcon.mods.skillcraft.skills.SkillRegistry;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

public class CommandSkillList {

	public static void processCommand(ICommandSender commandSender, String[] args) {
		if(SkillRegistry.getSkillNames().size() > 0) {
			StringBuilder sb = new StringBuilder();
			for(String skill : SkillRegistry.getSkillNames()) {
				sb.append(skill);
				sb.append(", ");
			}
			commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(LanguageManager.getLocalization("skillcraft.commands.skill.list") + " " + sb.substring(0, sb.length() - 2)));
		} else {
			commandSender.sendChatToPlayer(ChatMessageComponent.createFromText(LanguageManager.getLocalization("skillcraft.commands.skill.list") + " "));
		}
	}
}
