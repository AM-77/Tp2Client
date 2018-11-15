package tp2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StockClient {
	
	public static void main(String[] args) {

		try {
			System.setSecurityManager(new SecurityManager());
			Registry registry = LocateRegistry.getRegistry(1099);
			IStock stockImpl =  (IStock) registry.lookup("stockImpl");
					
			State state = stockImpl.state("cool");
			System.out.println(state.getLastOp());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
