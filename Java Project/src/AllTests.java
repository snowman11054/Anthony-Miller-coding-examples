import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs all of the tests in our game.
 * 
 * @author am5787
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			TestZombie.class,
			TestHuman.class
		})

public class AllTests 
{
	
}
