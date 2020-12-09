package be.theking90000.nezarialobby.listeners;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import be.theking90000.nezarialobby.Main;

public class invincible implements Listener {


private Main main;	
public Load load;
private String w;
	
	public invincible(Load load) {
		this.load = load;
	}
	
	
	
	
	public invincible(Main main2) {
		this.main = main2;
	}


	@EventHandler	
	//public void onJoin(PlayerJoinEvent event) {
		//Player p = event.getPlayer();
		//String w = p.getWorld().getName();
		//ArrayList<String> ew = (ArrayList<String>) main.getConfig().getStringList("enabledworld");
		//if(ew.contains("[" + w + "]")){
		//Player player = event.getPlayer();
				//player.setHealthScale(20);
		//}
		//}
	public void onHit(EntityDamageEvent event) {
		Entity e = event.getEntity();
		w = e.getWorld().getName();		
		if(main.ew.contains(w)) {
			if (event.getEntity() instanceof Player) {
			if(event.getCause().equals(DamageCause.VOID)) {
				if(main.getConfig().getBoolean("modules.antifall")) {
				event.setCancelled(true);
				if(main.getConfig().getBoolean("location.spawn.set")) {
				double x = main.getConfig().getDouble("location.spawn.x");
				double y = main.getConfig().getDouble("location.spawn.y");
				double z = main.getConfig().getDouble("location.spawn.z");
				float pitch = main.getConfig().getInt("location.spawn.pitch");
				float yaw = main.getConfig().getInt("location.spawn.yaw");
				String World = main.getConfig().getString("location.spawn.world");			
			    Location spawnl = new Location(Bukkit.getWorld(World), x, y, z, yaw , pitch);
			    e.teleport(spawnl);
				}
				else {
					event.setCancelled(false);
				}
				}
			return;
			}
			else{
			event.setCancelled(true);
			}
			}
			
		
		
	}
	}
		
	}

