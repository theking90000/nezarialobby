package be.theking90000.nezarialobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import be.theking90000.nezarialobby.commands.Edit;

public class antid implements Listener {

	
	@EventHandler
	public void OnDropItem(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		if(p instanceof Player)
		if(Edit.IT1.contains(p)){
			return;
		}
		else {
			event.setCancelled(true);
		}
	}
}
