package be.theking90000.nezarialobby.scoreboard;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import be.theking90000.nezarialobby.Main;
import me.clip.placeholderapi.PlaceholderAPI;




public class ScoreBoardManager {

	public Player player;
	public ScoreBoardSign sign;
	public static Map<Player, ScoreBoardSign> scoreboard = new HashMap<>();

	
	public ScoreBoardManager(Player player) {
		this.player = player;
		this.sign = new ScoreBoardSign(player, player.getName());
		if(!scoreboard.containsKey(player)) {
		scoreboard.put(player, this.sign);
		}
	}
	
	public void loadScoreBoard() {
		this.sign.setObjectiveName(Parsethis(PlaceholderAPI.setPlaceholders(player, Main.INSTANCE.sb.getConfig().getString("scoreboard-name"))));
		this.sign.create();
		
		  List<String> content = Main.INSTANCE.sb.getConfig().getStringList("scoreboard-content");
		 int i2 = 0;
		 for(int i = content.size(); i > 0; i--) {
			 String c = Parsethis(PlaceholderAPI.setPlaceholders(player, content.get(i2)));
			((ScoreBoardSign) scoreboard.get(player)).setLine(i, c);
			i2++;
		}

	}
	
	public void unLoadScoreboard() {
		((ScoreBoardSign) scoreboard.get(player)).setLine(0, "iiiiii");

	}
	
	public static void DestroyScoreboard(Player p) {
		if(scoreboard.containsKey(p)) {
			scoreboard.get(p).destroy();
			scoreboard.remove(p);
		}
	}
	
	public static void updateScoreBoard(Player p) {
		if(scoreboard.containsKey(p)) {
			List<String> content = Main.INSTANCE.sb.getConfig().getStringList("scoreboard-content");
			 int i2 = 0;
	
			 for(int i = content.size(); i > 0; i--) {
				 
				 String c = Parsethis(PlaceholderAPI.setPlaceholders(p, content.get(i2)));
				
				try {
				((ScoreBoardSign) scoreboard.get(p)).setLine(i, c);
				}catch(Error e) {
					((ScoreBoardSign) scoreboard.get(p)).setLine(i, "Error");
				}
				i2++;
			}
		}
	}
	
	
	public static String Parsethis(String txt) {
		String placeholder = txt;
		ChatColor.translateAlternateColorCodes('&', placeholder);
		placeholder = placeholder.replace("{max}", Integer.toString(Main.INSTANCE.getServer().getMaxPlayers()));
		placeholder = placeholder.replace("{players}", Integer.toString(Bukkit.getOnlinePlayers().size()));
		return placeholder;
	}
}
