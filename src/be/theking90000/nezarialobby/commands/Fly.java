package be.theking90000.nezarialobby.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.theking90000.nezarialobby.Main;
import me.clip.placeholderapi.PlaceholderAPI;

public class Fly implements CommandExecutor {

	public static ArrayList<String> fp ;
	

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(cmd.getName().equalsIgnoreCase("fly")) {
				if(args.length == 0) {
					if(Main.INSTANCE.ew.contains(p.getWorld().getName())) {
					if(!p.hasPermission("nezarialobby.fly.use")){
						if(p.getAllowFlight() == true) {							
					       String fmoff = Main.cfgm.getConfig().getString("command-reply.fly-mode-off");
					       if(Main.ph) {
					         fmoff = PlaceholderAPI.setPlaceholders(p , fmoff);	
					       }
					       else {
					    	   fmoff = ChatColor.translateAlternateColorCodes('&', fmoff);
					       }
					       p.sendMessage(Main.prefix + ChatColor.RESET + " " + fmoff );
					       return true;
						}
				       
					
						String fm = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("command-reply.fly-no-permission"));
				           p.sendMessage(Main.prefix + ChatColor.RESET + " " + fm );
					}  
				
				if(p.hasPermission("nezarialobby.fly.use")) {
				if(p.getAllowFlight() == false){
			         p.setAllowFlight(true);	
			         String fmon = Main.cfgm.getConfig().getString("command-reply.fly-mode-on");
			         if(Main.ph) {
				         fmon = PlaceholderAPI.setPlaceholders(p , fmon);	
				       }
				       else {
				    	   fmon = ChatColor.translateAlternateColorCodes('&', fmon);
				       }
			         p.sendMessage(Main.prefix + ChatColor.RESET + " " + fmon );
			         return true;
			      }
			       p.setAllowFlight(false);
			       String fmoff = Main.cfgm.getConfig().getString("command-reply.fly-mode-off");
			       if(Main.ph) {
				         fmoff = PlaceholderAPI.setPlaceholders(p , fmoff);	
				       }
				       else {
				    	   fmoff = ChatColor.translateAlternateColorCodes('&', fmoff);
				       }	       
			       p.sendMessage(Main.prefix + ChatColor.RESET + " " + fmoff );
			     return true;
			   }
			}
			  
			 }
			}
			 }
		return false;

				
			}
}
		