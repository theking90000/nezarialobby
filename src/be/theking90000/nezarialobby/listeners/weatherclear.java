package be.theking90000.nezarialobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

import be.theking90000.nezarialobby.Main;

public class weatherclear implements Listener {
	private String w;
	private static Main main;
	
	public weatherclear(Main main2) {
		weatherclear.main = main2;
	}
	@EventHandler
	public void onWeather(WeatherChangeEvent event) {
		w = event.getWorld().getName();
		if(main.ew.contains(w)) {
		event.setCancelled(true);
		
	}

}
}
