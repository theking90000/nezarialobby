package be.theking90000.nezarialobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import be.theking90000.nezarialobby.ConfigManager;
import be.theking90000.nezarialobby.Main;
import be.theking90000.nezarialobby.ScoreBoardConfig;

public class scoreboard implements Listener {
	
	
	private ConfigManager cf;
	private ScoreBoardConfig sb;
	
	public Score score;
	
	
	ScoreboardManager manager = Bukkit.getScoreboardManager();
    
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
	//Player p = e.getPlayer();
	Scoreboard board = manager.getNewScoreboard();
	Objective objective = board.registerNewObjective("NezariaLobby", "dummy");             
	objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	String title = cf.getConfig().getString("scoreboard-name");
	if(Main.ph) {
		//title = PlaceholderAPI.setPlaceholders(p , title);
	}
	else {
		title = ChatColor.translateAlternateColorCodes('&', title);
	}
	objective.setDisplayName(title);
	int i = sb.getConfig().getStringList("list").size();
	for (String s : sb.getConfig().getStringList("list")) {
	objective.getScore(s).setScore(i);
	i = i-1;
	}
	//int size = sb.getConfig().getStringList("Lines").size();
	//for (String s : sb.getConfig().getStringList("Lines")) {
	   // objective.getScore(s).setScore(size);
	    //size--;
	}
	
	}
   // }


   

