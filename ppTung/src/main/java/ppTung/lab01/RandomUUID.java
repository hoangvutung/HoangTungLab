package ppTung.lab01;

import java.security.SecureRandom;
import java.util.UUID;

public class RandomUUID {

	
	public static String GenerateUUID() {
		 SecureRandom rng = new SecureRandom();
	     String value= Long.toHexString(rng.nextLong())+ Long.toHexString(rng.nextLong());
	     String uuid = new String();
	     int count=0;
	     for(int i=0;i<36;i++) {
	    	 if(i==8 || i==13 || i==18 || i==23) uuid+= '-';
	    	 else uuid+= value.charAt(count++);
	     }
	     return uuid;
	}
	public static String generateString() {
	        String uuid = UUID.randomUUID().toString();
	        return uuid;
	}

}
