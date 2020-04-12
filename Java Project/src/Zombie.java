/**
 * The zombie for our game.
 * 
 * @author am5787
 */
public class Zombie extends LifeForm
{
	private int startingLifePoints;
	
	/**
	 * Creating the zombie.
	 * @param startingLifePoints The life points the zombie starts with.
	 */
	public Zombie(int startingLifePoints) 
	{
		this.startingLifePoints =startingLifePoints;
		lifePoints = startingLifePoints;
	}


	/**
	 * Recovering health points after a hit.
	 */
	public void recover()
	{
		int damage = startingLifePoints - lifePoints; 
		lifePoints = lifePoints + (damage / 10);
	}

}
