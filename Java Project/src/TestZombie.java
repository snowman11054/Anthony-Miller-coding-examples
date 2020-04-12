import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing the zombie class.
 * 
 * @author am5787
 */
public class TestZombie extends TestLifeForm
{
	/**
	 * @see TestLifeForm#createLifeForm(int)
	 */
	public LifeForm createLifeForm(int points) 
	{
		return new Zombie(points);
	}
	
	/**
	 * Testing to make sure the health points of a zombie can't go below zero.
	 */
	@Test
	public void negativeHealth()
	{
		LifeForm deadFred = new Zombie(50);
		while (deadFred.getLifePoints() > 0)
		{
			deadFred.takeHit(5);
			assertFalse(deadFred.getLifePoints() < 0);
		}
		
	}

	/**
	 * Zombies just have life points at creation. 
	 */
	@Test
	public void testCreation() 
	{
		LifeForm deadFred = new Zombie(50);
		assertEquals(50, deadFred.getLifePoints());
	}
	
//	/**
//	 * Testing if the zombie can take damage when hit.
//	 */
//	@Test
//	public void testTakeHit()
//	{
//		Zombie deadFred = new Zombie(50);
//		deadFred.takeHit(25);
//		assertEquals(25, deadFred.getLifePoints());
//	}
	
	/**
	 * Testing if the zombie can recover 10% of lost health.
	 */
	@Test
	public void testRecover()
	{
		int originalHealth = 50;
		int weaponStrength = 9001;
		Zombie deadFred = new Zombie(originalHealth);
		deadFred.takeHit(weaponStrength);
		int damage = originalHealth - deadFred.getLifePoints();
		deadFred.recover();
		
		assertEquals(originalHealth - damage + (damage/10), deadFred.getLifePoints());
	}
	
	/**
	 * Testing if the zombie can recover multiple times in a row.
	 */
	@Test
	public void testMultipleRecover()
	{
		int originalHealth = 50;
		int weaponStrength = 50;
		Zombie deadFred = new Zombie(originalHealth);
		
		for(int i = 0; i < 5; i++)
		{
			deadFred.takeHit(weaponStrength);
			int damage = originalHealth - deadFred.getLifePoints();
			deadFred.recover();
			
			assertEquals(originalHealth - damage + (damage/10), deadFred.getLifePoints());
		}

	}

}
