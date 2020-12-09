package be.theking90000.nezarialobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import be.theking90000.nezarialobby.Main;

public class antifaim implements Listener {
	private String w;
	private Main main;
	public antifaim(Main main2) {
		this.main = main2;
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		w = player.getWorld().getName();		
		if(main.ew.contains(w)) {
		player.setFoodLevel(20);
	}
	
}
	@EventHandler	
	public void onHungerDeplete(FoodLevelChangeEvent event) {
		
		if (event.getEntity() instanceof Player) {
			w = event.getEntity().getWorld().getName();		
			if(main.ew.contains(w)) {
		event.setCancelled(true);

		}
		}
	   }
	
	
}
