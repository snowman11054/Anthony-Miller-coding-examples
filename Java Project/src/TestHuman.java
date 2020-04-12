import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Testing the human class.
 * 
 * @author am5787
 */
public class TestHuman extends TestLifeForm
{

	/**
	 * @see TestLifeForm#createLifeForm(int)
	 */
	public LifeForm createLifeForm(int points) 
	{
		return new Human(points);
	}
	
	/**
	 * Testing if human is created properly.
	 */
	@Test
	public void testCreation() 
	{
		Human wellington = new Human(100);
		assertEquals(100, wellington.getLifePoints());
	}
	
	/**
	 *  @see TestLifeForm#pickUpWeakerWeapon()
	 */
	@Test
	public void pickUpWeakerWeapon()
	{
		Human wellington = new Human(100);
		assertEquals(0, wellington.numberWeaponsInBackPack());
		wellington.pickUpWeapon(15);
		wellington.pickUpWeapon(14);
		assertEquals(15, wellington.getCurrentWeaponStrength());
		assertEquals(1, wellington.numberWeaponsInBackPack());
		assertTrue(wellington.isCarryingWeapon(14));
	}

	/**
	 * Testing if we can hold more than on weapon in the backpack.
	 */
	@Test
	public void pickUpTwoWeakerWeapon()
	{
		Human wellington = new Human(100);
		assertEquals(0, wellington.numberWeaponsInBackPack());
		wellington.pickUpWeapon(15);
		wellington.pickUpWeapon(14);
		wellington.pickUpWeapon(12);
		assertEquals(15, wellington.getCurrentWeaponStrength());
		assertEquals(2, wellington.numberWeaponsInBackPack());
		assertTrue(wellington.isCarryingWeapon(14));
		assertTrue(wellington.isCarryingWeapon(12));
	}
	
	/**
	 * Testing if we can hold more than on weapon in the backpack.
	 */
	@Test
	public void pickUpWeaponFullBackpack()
	{
		Human wellington = new Human(100);
		assertEquals(0, wellington.numberWeaponsInBackPack());
		wellington.pickUpWeapon(15);
		wellington.pickUpWeapon(14);
		wellington.pickUpWeapon(12);
		wellington.pickUpWeapon(11);
		wellington.pickUpWeapon(10);
		wellington.pickUpWeapon(9);
		wellington.pickUpWeapon(8);
		wellington.pickUpWeapon(7);
		wellington.pickUpWeapon(6);
		wellington.pickUpWeapon(5);
		wellington.pickUpWeapon(4);
		wellington.pickUpWeapon(16);
		assertEquals(16, wellington.getCurrentWeaponStrength());
		assertEquals(10, wellington.numberWeaponsInBackPack());

		wellington.pickUpWeapon(10);
		assertEquals(16, wellington.getCurrentWeaponStrength());
		assertEquals(10, wellington.numberWeaponsInBackPack());
	}
	
	/**
	 * Testing if we can switch to the best weapon in our backpack.
	 */
	@Test
	public void testSwapBestWeapon()
	{
		Human wellington = new Human(100);
		LifeForm victim = createLifeForm(30);
		
		assertEquals(0, wellington.numberWeaponsInBackPack());
		
		wellington.pickUpWeapon(15);
		wellington.swapBestWeapon();
		
		assertEquals(15, wellington.getCurrentWeaponStrength());
		
		wellington.pickUpWeapon(15);
		wellington.pickUpWeapon(14);
		
		wellington.shoot(victim);
		wellington.shoot(victim);
		
		assertEquals(13, wellington.getCurrentWeaponStrength());
				
		wellington.swapBestWeapon();
		
		assertEquals(15, wellington.getCurrentWeaponStrength());
		
	}
}
