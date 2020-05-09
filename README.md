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
```

**Dont forget to add your arena to Matchmaker.arenas list**
```java
ArenaTest arena = new ArenaTest();
Matchmaker.arenas.add((IArena) arena);
```

**Good to know:**
