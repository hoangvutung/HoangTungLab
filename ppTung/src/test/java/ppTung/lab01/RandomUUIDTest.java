package ppTung.lab01;
import org.junit.Assert;
import org.junit.Test;

public class RandomUUIDTest {
	@Test
	public void test() {
		String s1=RandomUUID.GenerateUUID();
		String s2= RandomUUID.generateString();
		Assert.assertEquals(s1.length(),s2.length());
	}

}
