package ppTung.test1;

import static org.junit.Assert.*;

import org.junit.Test;

import ppTung.lab01.RandomUUID;

public class TestRandomUUID {

	@Test
	public void test() {
		System.out.println(RandomUUID.GenerateUUID(0x800L));
		//other method
		System.out.println(RandomUUID.generateString());
	}

}
