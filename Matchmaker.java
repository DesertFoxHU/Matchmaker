package me.desertfox.mm;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public class Matchmaker {

	private JavaPlugin plugin;
	public static List<IArena> arenas = new ArrayList<>();
	
	public void startMatchmaker(JavaPlugin plugin, int delay) {
		this.plugin = plugin;
		
		new BukkitRunnable() {
			
			public void run() {
				
				for(IArena arena : arenas) {
					
					if(!arena.isAvaible()) {
						continue;
					}
					
					for(Player p : arena.getElapsedSec().keySet()) {
						int val = arena.getElapsedSec().get(p);
						val++;
						arena.getElapsedSec().replace(p, val);
					}
					
					WaitingTickEvent event = new WaitingTickEvent(arena);
					Bukkit.getPluginManager().callEvent(event);
					
					if(arena.getPlayers().size() < arena.getMinPlayers()) {
						continue;
					}
					
					foundMatch(arena, delay);
				}

			}
			
		}.runTaskTimer(plugin, 0, 1*20);
		
	}
	
	protected void foundMatch(IArena arena, int delay) {
		
		if(delay <= 0) {
			
			if(arena.getPlayers().size() < arena.getMinPlayers()) {
				return;
			}
			
			MatchReadyEvent event = new MatchReadyEvent(arena);
			Bukkit.getPluginManager().callEvent(event);
			
			arena.setAvaible(false);
			arena.getElapsedSec().clear();
			return;
		}
		
		new BukkitRunnable() {
			
			public void run() {
				foundMatch(arena, 0);
			}
			
		}.runTaskLater(plugin, delay);
	}
	
	public static IArena getPlaying(Player p) {
		for(IArena arena : arenas) {
			if(arena.getPlayers().contains(p)) {
				return arena;
			}
		}
		return null;
	}
	
}
