#package me.desertfox.mm;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public class MatchReadyEvent extends Event {

	private IArena arena;
	
	public MatchReadyEvent(IArena arena) {
		super();
		this.arena = arena;
	}

	public IArena getArena() {
		return arena;
	}
	
	public List<Player> getPlayers(){
		return arena.getWaitingPlayers();
	}

	public static HandlerList handler = new HandlerList();
	
	@Override
	public HandlerList getHandlers() {
		return handler;
	}
	
	public static HandlerList getHandlerList() {
		return handler;
	}
	
}
