package be.theking90000.nezarialobby.listeners;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import be.theking90000.nezarialobby.Main;
import be.theking90000.nezarialobby.commands.Edit;

public class antigrief implements Listener {
	private String w;
	private Main main;
	public antigrief(Main main2) {
		this.main = main2;
	}
	
	@EventHandler
	public void onBreakBlock(BlockBreakEvent event) {
		Player p = event.getPlayer();
		if(p instanceof Player) {
			w = p.getWorld().getName();		
			if(main.ew.contains(w)) {
			if(Edit.IT1.contains(p)){			
			return;
		}
			else  {
			
			event.setCancelled(true);
		}
		
	}
		}
	}	

	
	@EventHandler
	public void onPlaceBlock(BlockPlaceEvent event) {
		Player p = event.getPlayer();
		if(p instanceof Player) {
			w = p.getWorld().getName();		
			if(main.ew.contains(w)) {
			if(Edit.IT1.contains(p)){
				return;
			}
			else {
				
				event.setCancelled(true);
			}
		}
		}
	}
		
	
	
	@EventHandler
    public void onClickSlot(InventoryClickEvent e) {
		if(main.getConfig().getBoolean("modules.anti-move-item")) {
		HumanEntity p = e.getWhoClicked();
		w = p.getWorld().getName();
		if(main.ew.contains(w)) {
		if(p instanceof Player) {
			if(Edit.IT1.contains(p)) {
				return;
			}
		
			else {
		e.setCancelled(true);
			}
		}
	}
	}
}
	@EventHandler
	public void Click(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		w = p.getWorld().getName();
		if(main.ew.contains(w)) {
		if(p instanceof Player) {
			if(Edit.IT1.contains(p)) {
				return;
			}
			if(event.getClickedBlock() == null) {
				return;
			}
		if(event.getClickedBlock().getType() == Material.CHEST) {
				event.setCancelled(true);
				
			}
			
		if(event.getClickedBlock().getType() == Material.TRAPPED_CHEST) {
				event.setCancelled(true);
				
			}
		
		if(event.getClickedBlock().getType() == Material.ACACIA_DOOR) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.WOODEN_DOOR) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.BIRCH_DOOR) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.DARK_OAK_DOOR) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.JUNGLE_DOOR) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.SPRUCE_DOOR) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.TRAP_DOOR) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.SOIL) {
			event.setCancelled(true);
		}
		if(event.getClickedBlock().getType() == Material.STONE_BUTTON) {
			event.setCancelled(true);
				
		}
		if(event.getClickedBlock().getType() == Material.WOOD_BUTTON) {
			event.setCancelled(true);
			
		}
		if(event.getClickedBlock().getType() == Material.LEVER) {
			event.setCancelled(true);
			
		}
		if(event.getAction().equals(Action.PHYSICAL)){
			if(event.getClickedBlock().getType() == Material.STONE_PLATE){
				event.setCancelled(true);
			}
		}
		if(event.getAction().equals(Action.PHYSICAL)){
			if(event.getClickedBlock().getType() == Material.GOLD_PLATE){
			event.setCancelled(true);
			}
		}
			
			}
		if(event.getAction().equals(Action.PHYSICAL)){
			if(event.getClickedBlock().getType() == Material.WOOD_PLATE){
			event.setCancelled(true);
			}
		}	
		
			}
		
	    
		
		
	return;
	}
	
	@EventHandler
	public void onPlayerEmptyBucket(PlayerBucketEmptyEvent e) {
		Player p = e.getPlayer();
		w = p.getWorld().getName();
		if(main.ew.contains(w)) {
		if(p instanceof Player) {
			if(Edit.IT1.contains(p)) {
				return;
			}
			e.setCancelled(true);
	}
		}
	}
	
	}
	
	
	



