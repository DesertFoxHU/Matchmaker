package me.desertfox.mm;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public interface IArena {

	public int getMinPlayers();
	
	public List<Player> getPlayers();
	
	public void setPlayers(List<Player> list);
	
	public void setElapsedSec(HashMap<Player, Integer> newHash);
	
	public HashMap<Player, Integer> getElapsedSec();
	
	public boolean isAvaible();
	
	public void setAvaible(boolean avaible);
	
}
