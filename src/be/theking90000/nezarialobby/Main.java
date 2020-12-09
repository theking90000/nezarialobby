package be.theking90000.nezarialobby;




import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import be.theking90000.nezarialobby.listeners.Load;
import be.theking90000.nezarialobby.scoreboard.ScoreBoardManager;


public class Main extends JavaPlugin implements Listener {
	public static Location spawnl;
	public static Double x;
	public static Double y;
	public static Double z ;
	public static String World;
	public static ConfigManager cfgm;
	public ScoreBoardConfig sb;
	private Load lstn;
    public static String prefix;   
    public static String worlds;
    public List<String> ew;
    public static Boolean ph;
	public static Plugin main;
	public static Main INSTANCE;
	
@Override
	public void onEnable() {
	
		INSTANCE = this;
	


		saveDefaultConfig();
		Bukkit.getServer().getConsoleSender().sendMessage("[NezariaLobby]" + ChatColor.GREEN + "le fichier config.yml a ete charge");
		
		cfgm = new ConfigManager(this);																				
		sb = new ScoreBoardConfig(this);
		prefix = ChatColor.translateAlternateColorCodes('&', cfgm.getConfig().getString("plugin-prefix"));
		worlds = ChatColor.translateAlternateColorCodes('&', cfgm.getConfig().getString("consoles-worlds-enabled"));
	    Bukkit.getServer().getConsoleSender().sendMessage("[NezariaLobby]" + ChatColor.GREEN + "Le prefix du plugin est maintenant : " + ChatColor.RESET + prefix);
	    Bukkit.getServer().getConsoleSender().sendMessage("[NezariaLobby]" + ChatColor.GREEN + "Le plugin vient de demarrer");
	    
	    
	    
		if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {      
	        Bukkit.getPluginManager().registerEvents(this, this);
	        Bukkit.getServer().getConsoleSender().sendMessage(prefix + " " + ChatColor.RESET + "Dependance PlaceHolderApi Found !");
	       ph = true;
	    } else {
	        Bukkit.getServer().getConsoleSender().sendMessage(prefix + " " + ChatColor.RESET + "Dependance PlaceHolderApi Not Found");
	        ph = false;
	    }
		
		
		
	    ew = getConfig().getStringList("enabledworld");
	    Bukkit.getServer().getConsoleSender().sendMessage(prefix + " " + ChatColor.RESET + worlds + "" + ChatColor.YELLOW + ew);
	    
	    
	    
		listenersLoad();
		
		
		
		
		
		
		
		
		
				
		
		
		
		
		
		
		
		
		
			
			
		}
	
	@Override
public void onDisable() {
		for(Player player : Bukkit.getOnlinePlayers()) {
			
			ScoreBoardManager.DestroyScoreboard(player);
			
		}
	}

	
	


	 public void listenersLoad() {
		 lstn = new Load(this);
		 lstn.LoadL();		 		 
	 }
	
	 
	 
	
			
		
		
	 
	
     
		
		
	}



