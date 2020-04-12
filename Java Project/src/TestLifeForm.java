import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing if we can keep track of the life points of our life forms.
 * 
 * @author am5787
 */
public abstract class TestLifeForm 
{
	/**
	 * Create a life form appropriate to the subclass we are testing.
	 * @param points The number of life points the life form should be given.
	 * @return The new object.
	 */
	public abstract LifeForm createLifeForm(int points);
	
	
	/**
	 * The life forms should lose life points matching the strength of a hit when 
	 * it is whacked. The number of life points subtracting should be uniformly 
	 * distributed between 0 and the strength of the weapon.
	 */
	@Test
	public void hitsHurtRandomly() {
		int originalHealth = 50;
		int weaponStrength = 5;
		int[] damage = new int[weaponStrength + 1];
		int numberOfHits = 10000;
		
		for(int i = 0; i < numberOfHits; i++)
		{
			LifeForm deadFred = createLifeForm(originalHealth);
			deadFred.takeHit(weaponStrength);
			damage[originalHealth - deadFred.getLifePoints()]++;
		}
		
		int hitsPerDamage = numberOfHits / (weaponStrength + 1);
		int epsilon = (int)(hitsPerDamage * 0.15);
		for(int i = 0; i < damage.length; i++)
		{
			assertTrue("Not enough examples of damage = " + i, (hitsPerDamage - epsilon) < damage[i]);
			assertTrue("Too many examples of damage = " + i, (hitsPerDamage + epsilon) > damage[i]);
		}
	}
	
	/**
	 * Testing if we can have our life forms pick up weapons.
	 */
	@Test
	public void testWeaponStrength()
	{
		LifeForm it = createLifeForm(50);
		assertEquals(0, it.getCurrentWeaponStrength());
		
		it.pickUpWeapon(15);
		assertEquals(15, it.getCurrentWeaponStrength());
	}
	
	/**
	 * Testing that we don't pick up a weaker weapons.
	 */
	@Test
	public void pickUpWeakerWeapon()
	{
		LifeForm it = createLifeForm(50);
		it.pickUpWeapon(15);
		it.pickUpWeapon(14);
		assertEquals(15, it.getCurrentWeaponStrength());
	}

	/**
	 * Testing that the weapon looses durability after each use.
	 */
	@Test
	public void testShooting()
	{
		LifeForm it = createLifeForm(50);
		LifeForm victim = createLifeForm(30);
		it.pickUpWeapon(12);
		it.shoot(victim);
		assertEquals(11, it.getCurrentWeaponStrength());
		assertEquals(1, victim.getNumberHitsTaken());
	}
	
	/**
	 * Testing that we can count the number of hits.
	 */
	@Test
	public void testHitCount()
	{
		LifeForm it = createLifeForm(30);
		assertEquals(0, it.getNumberHitsTaken());
		it.takeHit(5);
		assertEquals(1, it.getNumberHitsTaken());
		it.takeHit(5);
		assertEquals(2, it.getNumberHitsTaken());
	}

	/**
	 * Testing that we can't count hits that have no weapon strength.
	 */
	@Test
	public void testShootingNoWeaponStrength()
	{
		LifeForm it = createLifeForm(50);
		LifeForm victim = createLifeForm(30);
		it.shoot(victim);
		assertEquals(0, it.getCurrentWeaponStrength());
		assertEquals(0, victim.getNumberHitsTaken());
		assertEquals(30, victim.getLifePoints());
	}

}
