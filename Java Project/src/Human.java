/**
 * The human for our game.
 * 
 * @author am5787
 */
public class Human extends LifeForm
{
	private int[] backpack = new int[10];
	private int numberWeaponsInBackPack = 0;

	/**
	 * Creating the human.
	 * @param startingLifePoints The life points the human starts with.
	 */
	public Human(int startingLifePoints) 
	{
		lifePoints = startingLifePoints;
	}

	/**
	 * @see LifrForm#pickUpWeapon(int)
	 */
	public void pickUpWeapon(int weaponStrength) 
	{
		//If we don't have any weapons.
		if(currentWeaponStrength == 0)
		{
			currentWeaponStrength = weaponStrength;
		}
		
		//If we get a better weapon than our current weapon and our backpack is not full.
		else if((currentWeaponStrength <= weaponStrength) && (numberWeaponsInBackPack < 10))
		{
			int temp = currentWeaponStrength;
			currentWeaponStrength = weaponStrength;
			backpack[numberWeaponsInBackPack] = temp;
			numberWeaponsInBackPack = numberWeaponsInBackPack + 1;
		}
		
		//If we get a better weapon than our current weapon and our backpack is full.
		else if((currentWeaponStrength < weaponStrength) && (numberWeaponsInBackPack == 10))
		{
			currentWeaponStrength = weaponStrength;
		}
		
		//If we get a weaker weapon than our current weapon but our backpack is not full.
		else if((currentWeaponStrength > weaponStrength) && (numberWeaponsInBackPack < 10))
		{
			backpack[numberWeaponsInBackPack] = weaponStrength;
			numberWeaponsInBackPack = numberWeaponsInBackPack + 1;
		}
	}
	
	/**
	 * Getting the number of weapons in the backpack.
	 * @return The number of weapons in the backpack.
	 */
	public int numberWeaponsInBackPack() 
	{
		int count = 0;
		for(int i = 0; i < backpack.length; i++)
		{
			if (backpack[i] > 0)
			{
				count = count + 1;
			}
		}
		return count;
	}

	/**
	 * Checking that we have a specific weapon in the backpack.
	 * @param otherWeapon The weapon we are looking for.
	 * @return If we have the weapon we are looking for.
	 */
	public boolean isCarryingWeapon(int otherWeapon) 
	{
		for(int i = 0; i < backpack.length; i++)
		{
			if (backpack[i] == otherWeapon)
			{
				return true;
			}
		}
	return false;
	}

	/**
	 * Swapping to the best weapon in our backpack.
	 */
	public void swapBestWeapon() 
	{
		for(int i = 0; i < backpack.length -1 ; i++)
		{
			for(int j = 0; j < backpack.length -1; j++)
			{
				if(backpack[j] < backpack[j + 1])
				{
					int temp = backpack[j];
					backpack[j] = backpack[j + 1];
					backpack[j + 1] = temp;
				}
			}
		}
		
		if(currentWeaponStrength < backpack[0])
		{
			int temp = backpack[0];
			backpack[0] = currentWeaponStrength;
			currentWeaponStrength = temp;
		}
	}

}
