package be.theking90000.nezarialobby.listeners;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;


import be.theking90000.nezarialobby.Main;

import be.theking90000.nezarialobby.commands.Edit;
import be.theking90000.nezarialobby.commands.Fly;
import be.theking90000.nezarialobby.commands.Spawn;
import be.theking90000.nezarialobby.runnables.ScoreBoardRunnable;






public class Load {
	

	
	
	private Main main;
	public Load(Main main) {
		this.main = main;
	}

	
	
	
	public void LoadL(){
		
		//importer les variables des modules
		
		
			boolean invincible = main.getConfig().getBoolean("modules.invincible");
			boolean antif = main.getConfig().getBoolean("modules.anti-faim");
			boolean soj = main.getConfig().getBoolean("modules.spawn-on-join");
			boolean ag = main.getConfig().getBoolean("modules.anti-grief");
			boolean gmj = main.getConfig().getBoolean("modules.change-gamemode-on-join");
			boolean wc = main.getConfig().getBoolean("modules.weather-clear");			
			boolean spawn = main.getConfig().getBoolean("modules.spawn");
			boolean antid = main.getConfig().getBoolean("modules.anti-item-drop");
			boolean fly = main.getConfig().getBoolean("modules.fly");
			//boolean scoreboard = main.getConfig().getBoolean("modules.scoreboard");
			boolean antifa = main.getConfig().getBoolean("modules.antifall");
			String mai = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.invincible"));
			String maaf = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.anti-faim"));
			String masoj = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.spawn-on-join"));
			String ags = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.anti-grief"));
			String gmjs = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.gamemode-on-join"));
			String wcs = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.weather-clear"));
			String spwns = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.spawn"));
			String antids = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.anti-item-drop"));
			String flys = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.fly"));
			String sbs = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.scoreboard"));
			String antifs = ChatColor.translateAlternateColorCodes('&', Main.cfgm.getConfig().getString("modules-activated.antifall"));
			
			
			//importer le module si la variable est sur true
			if(invincible)  {
				
				main.getServer().getPluginManager().registerEvents(new invincible(main), main);	
			    Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + mai);
			}
			
			
		    if(antif) {
		    	
		    	main.getServer().getPluginManager().registerEvents(new antifaim(main), main);
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix +  maaf);
		    }
		    
		    if(soj) {
		    	
		    	main.getServer().getPluginManager().registerEvents(new spawnonjoin(main), main);
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix +  masoj);
		    }
		    
		    if(ag) {
		    	
		    	main.getServer().getPluginManager().registerEvents(new antigrief(main), main);
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + ags);
		    	main.getCommand("edit").setExecutor(new Edit(main));		    	
		    }
		   
		    if(gmj) {
		    	main.getServer().getPluginManager().registerEvents(new gmonjoin(), main );
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + gmjs);
		    }
		   
		    
		    
		    if(wc) {
		    	main.getServer().getPluginManager().registerEvents(new weatherclear(main), main);
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + wcs);
		    }
		    
		    if(spawn) {
		    	main.getCommand("spawn").setExecutor(new Spawn(main));
		    	main.getCommand("setspawn").setExecutor(new Spawn(main));
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + spwns);
		    }
		    
		    if(antid) {
		    	main.getServer().getPluginManager().registerEvents(new antid(), main);
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + antids);
		    }
		    
		    if(fly) {
		    	main.getCommand("fly").setExecutor(new Fly());
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + flys);
		    }
		    
		    if(antifa) {
		    	//main.getServer().getPluginManager().registerEvents(new antifall(main), main);
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + antifs);
		    }
		   // if(scoreboard) {
		    //	main.getServer().getPluginManager().registerEvents(new scoreboard(), main);
		    //	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + sbs);
		    //}
		    Main.INSTANCE.getServer().getPluginManager().registerEvents(new playerjoin(), main);
		    if(Main.INSTANCE.getConfig().getBoolean("modules.scoreboard")) {    	
		    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + sbs);
		    	long timer = Main.INSTANCE.sb.getConfig().getLong("update-placeholders");
		    	new ScoreBoardRunnable().runTaskTimer(main, 0L, timer);
		    }
		  
		    
		    

	}


	//public static ArrayList<String> ew = (ArrayList<String>) main.getConfig().getStringList("enabledworld");
    

}
