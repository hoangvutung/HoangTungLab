package ppTung.lab01;
import org.junit.Test;

public class RandomUUIDTest {
	@Test
	public void test() {
		System.out.println(RandomUUID.GenerateUUID());
		//other method
		System.out.println(RandomUUID.generateString());
	}

}
