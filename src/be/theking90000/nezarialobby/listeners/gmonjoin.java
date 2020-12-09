package be.theking90000.nezarialobby.listeners;


import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import be.theking90000.nezarialobby.Main;






public class gmonjoin implements Listener {

	
	//private static Main main;
	//public gmonjoin(Main main){
		//gmonjoin.main = main;
	//}
	
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();		
	p.setGameMode(GameMode.SURVIVAL);}
	String test = Main.prefix;
	//if(gm.equalsIgnoreCase("CREATIVE"));{
	//p.setGameMode(GameMode.CREATIVE);}
	//if(gm.equalsIgnoreCase("ADVENTURE"));{
	//p.setGameMode(GameMode.ADVENTURE);}
	//if(gm.equalsIgnoreCase("SPECTATOR"));{
	//p.setGameMode(GameMode.SPECTATOR);}	
		
	}


