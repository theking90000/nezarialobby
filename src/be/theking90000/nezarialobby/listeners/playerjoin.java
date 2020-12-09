package be.theking90000.nezarialobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import be.theking90000.nezarialobby.Main;
import be.theking90000.nezarialobby.scoreboard.ScoreBoardManager;

public class playerjoin implements Listener {


	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		if(Main.INSTANCE.getConfig().getBoolean("modules.scoreboard")) {
			
				new ScoreBoardManager(player).loadScoreBoard();

		}
	}
	
}
