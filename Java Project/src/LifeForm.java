/**
 * A class the keeps track of the life points of our life forms.
 * 
 * @author am5787
 */
public class LifeForm
{

	protected int lifePoints;
	protected int currentWeaponStrength = 0;
	private int numberHitsTaken = 0;

	/**
	 * Getting the number of life points the zombie has.
	 * @return The amount of life points.
	 */
	public int getLifePoints() 
	{
		return lifePoints;
	}

	/**
	 * Damaging the zombie.
	 * @param weaponStrenght The strength of damage weapon.
	 */
	public void takeHit(int weaponStrenght) 
	{
		if(weaponStrenght > 0)
		{
			numberHitsTaken = numberHitsTaken + 1;
		}
		lifePoints = lifePoints - (int)(Math.random()*(weaponStrenght + 1));
		if (lifePoints < 0)
		{
			lifePoints = 0;
		}
	}

	/**
	 * Getting the current weapon strength.
	 * @return The current weapon strength
	 */
	public int getCurrentWeaponStrength() 
	{
		return currentWeaponStrength;
	}

	/**
	 * Setting the current weapon strength.
	 * @param weaponStrength The amount the new current weapon strength will be.
	 */
	public void pickUpWeapon(int weaponStrength) 
	{
		if(currentWeaponStrength < weaponStrength)
		{
			currentWeaponStrength = weaponStrength;
		}
	}

	/**
	 * Shooting the victim.
	 * @param victim The object to take damage.
	 */
	public void shoot(LifeForm victim) 
	{
		victim.takeHit(currentWeaponStrength);
		if(currentWeaponStrength > 0)
		{
			currentWeaponStrength = currentWeaponStrength - 1;
		}
	}


	/**
	 * @return The number of hits taken by a life form;
	 */
	public int getNumberHitsTaken() 
	{
		return numberHitsTaken;
	}

}
