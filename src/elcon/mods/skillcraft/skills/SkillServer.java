package elcon.mods.skillcraft.skills;

import java.util.HashMap;

@Deprecated
public class SkillServer {

	public static HashMap<String, SkillPlayer> players = new HashMap<String, SkillPlayer>();
	
	public static SkillPlayer getPlayer(String player) {
		if(players.containsKey(player)) {
			return players.get(player);
		}
		return null;
	}
	
	public static void addPlayer(String player, SkillPlayer skillPlayer) {
		players.put(player, skillPlayer);
	}
	
	public static void removePlayer(String player) {
		players.remove(player);
	}
}
