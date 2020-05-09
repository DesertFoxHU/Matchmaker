package me.desertfox.mm;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public class WaitingTickEvent extends Event {
	
	private IArena arena;
	
	public WaitingTickEvent(IArena arena) {
		super();
		this.arena = arena;
	}

	public IArena getArena() {
		return arena;
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
