package ppTung.lab3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class RollerCoasterTest {

	@Test
	public void test() throws InterruptedException {
		RollerCoaster.Controler RC = new RollerCoaster.Controler();
		ArrayList<RollerCoaster.Client> threads = new ArrayList<RollerCoaster.Client>() ;
		for(int i=0;i<30;i++) {
			RollerCoaster.Client client = new RollerCoaster.Client(RC);
			client.setName("Client "+Integer.toString(i+1));
			client.start();
			threads.add(client);
		}
		for(RollerCoaster.Client c : threads) {
			c.join();
		}
		for(int i=0;i<RollerCoaster.Trips.size();i++) {
			Assert.assertEquals((Integer)10, RollerCoaster.Trips.get(i));
		}
		
	}

}
