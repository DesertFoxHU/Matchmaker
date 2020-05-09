package me.desertfox.mm;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

/**
* @author DesertFoxHU
* @since 2020-05-09
*/
public class ArenaTest implements IArena {

	private List<Player> players = new ArrayList<>();
	private int elapsed;
	private boolean avaible = true;

	@Override
	public int getMinPlayers() {
		return 10;
	}

	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void setPlayers(List<Player> list) {
		this.players = list;
	}
	
	@Override
	public void setElapsedSec(int newValue) {
		elapsed = newValue;
	}

	@Override
	public int getElapsedSec() {
		return elapsed;
	}

	@Override
	public boolean isAvaible() {
		return avaible;
	}

	@Override
	public void setAvaible(boolean avaible) {
		this.avaible = avaible;
	}

}
