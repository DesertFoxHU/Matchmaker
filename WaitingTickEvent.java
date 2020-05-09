#package me.desertfox.mm;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public class WaitingTickEvent extends Event {
	
	private IArena arena;
	private int waitedSec;
	
	public WaitingTickEvent(IArena arena, int waitedSec) {
		super();
		this.arena = arena;
		this.waitedSec = waitedSec;
	}

	public IArena getArena() {
		return arena;
	}
	
	public int getWaitedSec() {
		return waitedSec;
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
