package elcon.mods.skillcraft.skills;

import java.util.HashMap;

public class SkillClient {

	public static SkillPlayer player;
	public static HashMap<String, SkillPlayer> players = new HashMap<String, SkillPlayer>();
	
	public static SkillPlayer getPlayer() {
		return player;
	}
	
	public static void setPlayer(SkillPlayer skillPlayer) {
		player = skillPlayer;
	}
	
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
