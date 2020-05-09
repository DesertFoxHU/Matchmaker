#package me.desertfox.mm;

import java.util.List;

import org.bukkit.entity.Player;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public interface IArena {

	public int getMinPlayers();
	
	public List<Player> getWaitingPlayers();
	
	public void setWaitingPlayers(List<Player> list);
	
	public void setElapsedSec(int newValue);
	
	public int getElapsedSec();
	
	public boolean isAvaible();
	
	public void setAvaible(boolean avaible);
	
}
