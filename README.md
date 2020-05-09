**Using:**

First of all: You need to load the Matchmaker class!

```java
public class YourMain extends JavaPlugin {
  public void onEnable(){
    new Matchmaker().startMatchmaker(this, 10 /*See explaination below*/);
  }
}
```

*startMatchmaker(this, **int delay**) <- delay in seconds. If the matchmaker finds a match it will wait this many seconds before truly activeting the arena*<br>
*Why is this good? Because if the arena reach the min player count and if the delay is 0, then that arena will never have more than minimum player count*

Then you need to make your own Arena class, which implementing the **IArena**

**For example:**
```java
public class ArenaTest implements IArena {

	private List<Player> players = new ArrayList<>();
	private HashMap<Player, Integer> elapsed = new HashMap<>();
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
	public void setElapsedSec(HashMap<Player, Integer> newHash) {
		elapsed = newHash;
	}

	@Override
	public HashMap<Player, Integer> getElapsedSec() {
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
```

**Dont forget to add your arena to Matchmaker.arenas list**
```java
ArenaTest arena = new ArenaTest();
Matchmaker.arenas.add((IArena) arena);
```

**Good to know:**<br>
- The Matchmaker ignore the arena if that is not avaible
- The elapsedSec will be set to 0 after found a match
- The List<Player> in IArena will be the same after found a match
- The Matchmaker dont know how many the max players, so you need to control it.
- You need to write your own join & leave things.
- After the match is ended, you need set back the arena. (Clearing the players, make avaible again)
	
**Events**
- MatchReadyEvent: called when the matchmaker found a match, you dont need to change the avaible status!
- WaitingTickEvent: called when the matchmaker try to make a match, you can get the elapsedSec, so for example you can send to every waiting Player how much time elapsed until joined to the waiting list
