package be.theking90000.nezarialobby;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ScoreBoardConfig {
	private Main main;
	private FileConfiguration scConfig = null;
	private File scfile = null;
	
	public ScoreBoardConfig(Main main) {
		this.main = main;
		//saves / initailizes the config
		saveDefault();
	}
	
	public void reloadConfig() {
		if (this.scfile == null)
			this.scfile = new File(this.main.getDataFolder(), "scoreboard.yml");
		
		this.scConfig = YamlConfiguration.loadConfiguration(this.scfile);
		
		InputStream defaultStream = this.main.getResource("scoreboard.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream)); 
			this.scConfig.setDefaults(defaultConfig);	
				
			}
		}
	
	public FileConfiguration getConfig() {
		if (this.scConfig == null)
			reloadConfig();
		return this.scConfig;
	}
	
	public void saveConfig() {
		if (this.scConfig == null || this.scfile == null)
			return;
		
		try {
			this.getConfig().save(this.scfile);
		} catch (IOException e) {
			main.getLogger().log(Level.SEVERE, "Ne peux pas sauvegarder le fichier scoreboard.yml" + this.scfile, e);
		}
	}
	
	public void saveDefault() {
		if (this.scfile == null)
			this.scfile = new File(this.main.getDataFolder(), "scoreboard.yml");
		
		if (!this.scfile.exists()) {
			this.main.saveResource( "scoreboard.yml", false);
		}
	}
}
