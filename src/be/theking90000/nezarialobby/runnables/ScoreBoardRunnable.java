package be.theking90000.nezarialobby.runnables;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import be.theking90000.nezarialobby.Main;
import be.theking90000.nezarialobby.scoreboard.ScoreBoardManager;

public class ScoreBoardRunnable extends BukkitRunnable{

	@Override
	public void run() {
		if(Main.INSTANCE.getConfig().getBoolean("modules.scoreboard")) {
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(!ScoreBoardManager.scoreboard.containsKey(player)) {
					if(Main.INSTANCE.ew.contains(player.getWorld().getName())) {
					new ScoreBoardManager(player).loadScoreBoard();
					}
				}
				else {
					if(!Main.INSTANCE.ew.contains(player.getWorld().getName())) {
					ScoreBoardManager.DestroyScoreboard(player);
					}else {
					ScoreBoardManager.updateScoreBoard(player);
					}
					}
				
			}
		}
	}
}
