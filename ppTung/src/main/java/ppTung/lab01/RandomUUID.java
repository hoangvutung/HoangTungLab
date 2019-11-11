package ppTung.lab01;

import java.security.SecureRandom;
import java.util.UUID;

public class RandomUUID {

	public static void main(String[] args) {
	}
	public static String GenerateUUID(long MSB) {
		 SecureRandom ng = new SecureRandom();
	     return "uuid= " + Long.toHexString(MSB | ng.nextLong()) 
	        			+ Long.toHexString(MSB | ng.nextLong());
	}
	public static String generateString() {
	        String uuid = UUID.randomUUID().toString();
	        return "uuid = " + uuid;
	}

}
