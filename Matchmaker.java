#package me.desertfox.mm;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public class Matchmaker {

	private JavaPlugin plugin;
	public static List<IArena> arenas = new ArrayList<>();
	
	public void startMatchmaker(JavaPlugin plugin, int minPlayer, int maxPlayer, int delay) {
		this.plugin = plugin;
		
		new BukkitRunnable() {
			
			public void run() {
				
				for(IArena arena : arenas) {
					
					if(!arena.isAvaible()) {
						continue;
					}
					
					arena.setElapsedSec(arena.getElapsedSec()+1);
					
					WaitingTickEvent event = new WaitingTickEvent(arena, arena.getElapsedSec());
					Bukkit.getPluginManager().callEvent(event);
					
					if(arena.getWaitingPlayers().size() < arena.getMinPlayers()) {
						continue;
					}
					
					foundMatch(arena, delay);
				}

			}
			
		}.runTaskTimer(plugin, 0, 1*20);
		
	}
	
	protected void foundMatch(IArena arena, int delay) {
		
		if(delay <= 0) {
			MatchReadyEvent event = new MatchReadyEvent(arena);
			Bukkit.getPluginManager().callEvent(event);
			
			arena.setAvaible(false);
			arena.setElapsedSec(0);
			return;
		}
		
		new BukkitRunnable() {
			
			public void run() {
				foundMatch(arena, 0);
			}
			
		}.runTaskLater(plugin, delay);
	}
	
}
