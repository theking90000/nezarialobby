package be.theking90000.nezarialobby.listeners;





import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import be.theking90000.nezarialobby.Main;














public class spawnonjoin implements Listener {

	
 private Main main;
	
	
	
	public spawnonjoin(Main main) {
		this.main = main;
	}
	
	

	
    
	 @EventHandler
	  public void onJoin(PlayerJoinEvent event) {

	    Player player = event.getPlayer();
	    if(main.getConfig().getBoolean("location.spawn.set")) {		
			double x = main.getConfig().getDouble("location.spawn.x");
			double y = main.getConfig().getDouble("location.spawn.y");
			double z = main.getConfig().getDouble("location.spawn.z");
			float pitch = main.getConfig().getInt("location.spawn.pitch");
			float yaw = main.getConfig().getInt("location.spawn.yaw");
			String World = main.getConfig().getString("location.spawn.world");			
		    Location spawnl = new Location(Bukkit.getWorld(World), x, y, z, yaw , pitch);
	    player.teleport(spawnl);
	    }
	    else {	    	
	    	player.sendMessage("pas de spawn trouve");
	    }
	    
	  }

	}

	
	

		
	
    
		
	
	



		
	
	

