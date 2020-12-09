package be.theking90000.nezarialobby;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;





public class ConfigManager {

	private Main main;
	private FileConfiguration msgConfig = null;
	private File msgFile = null;
	
	
	public ConfigManager(Main main) {
		this.main = main;
		//saves / initailizes the config
		saveDefault();
	}
	
	public void reloadConfig() {
		if (this.msgFile == null)
			this.msgFile = new File(this.main.getDataFolder(), "messages.yml");
		
		this.msgConfig = YamlConfiguration.loadConfiguration(this.msgFile);
		
		InputStream defaultStream = this.main.getResource("messages.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream)); 
			this.msgConfig.setDefaults(defaultConfig);	
				
			}
		}
	
	public FileConfiguration getConfig() {
		if (this.msgConfig == null)
			reloadConfig();
		return this.msgConfig;
	}
	
	public void saveConfig() {
		if (this.msgConfig == null || this.msgFile == null)
			return;
		
		try {
			this.getConfig().save(this.msgFile);
		} catch (IOException e) {
			main.getLogger().log(Level.SEVERE, "Ne peux pas sauvegarder le fichier de configuration a " + this.msgFile, e);
		}
	}
	
	public void saveDefault() {
		if (this.msgFile == null)
			this.msgFile = new File(this.main.getDataFolder(), "messages.yml");
		
		if (!this.msgFile.exists()) {
			this.main.saveResource( "messages.yml", false);
		}
	}
	
	}
	
	





