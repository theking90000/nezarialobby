package be.theking90000.nezarialobby.commands;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import be.theking90000.nezarialobby.Main;

public class Spawn implements CommandExecutor {

	private Main main;
	
	public static Location spawnl;
	
	public Spawn(Main main) {
		this.main = main;
	}
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {			
			if(cmd.getName().equalsIgnoreCase("spawn")) {
				Player player = (Player) sender;
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
					System.out.println();
				}
			}
		}
			
			

			if(cmd.getName().equalsIgnoreCase("setspawn") && args.length == 0) {
				Player player = (Player) sender;				
				Location l = player.getLocation();
				double x = l.getX();
				double y = l.getY();
				double z = l.getZ();
				float pitch = l.getPitch();
				float yaw = l.getYaw();
				Boolean True = true;
				
				main.getConfig().set("location.spawn.x", x);
				main.getConfig().set("location.spawn.y", y);
				main.getConfig().set("location.spawn.z", z);
				main.getConfig().set("location.spawn.pitch", pitch);
				main.getConfig().set("location.spawn.yaw", yaw);
				main.getConfig().set("location.spawn.world", player.getWorld().getName());
				main.getConfig().set("location.spawn.set", True);
				
				main.saveConfig();
				main.reloadConfig();
				

				player.sendMessage("§2[NEZARIA LOBBY] Vous avez mis le spawn du monde");
			}
		
		
		return false;
		}
	}


