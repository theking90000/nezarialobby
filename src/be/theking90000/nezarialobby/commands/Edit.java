package be.theking90000.nezarialobby.commands;


import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.theking90000.nezarialobby.Main;



public class Edit implements CommandExecutor {
	//private static Main main;
	

	public  Edit(Main main) {
	}

   public static ArrayList <Player> IT1 = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;				
			if(cmd.getName().equalsIgnoreCase("edit")) {			
				if(IT1.contains(player)) {
					IT1.remove(player);
					player.setGameMode(GameMode.SURVIVAL);
					String sm = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("command-reply.build-mode-off"));
					player.sendMessage(Main.prefix + ChatColor.RESET + " " + sm);
					return true;
				}
					if(player.hasPermission("nezarialobby.edit") && !IT1.contains(player)) {	
						IT1.add(player);	
						player.setGameMode(GameMode.CREATIVE);
						String sm = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("command-reply.build-mode-on"));
						player.sendMessage(Main.prefix + ChatColor.RESET + " " + sm);
						return true;
					}	
					
			 
					
					
			

				  }
			if(!player.hasPermission("nezarialobby.edit")) {
					  player.sendMessage("vous n'avez pas la permission nezarialobby.edit");
					  return true;
				  }
		}
		return false;		
				 
			  }
					
						
						
						
					
				
				
			
		
		
		
	

}
