package tp2;

import java.rmi.Remote;
//import java.rmi.RemoteException;

public interface IStock extends Remote{
		
	boolean createArticle(String id, int q_init) throws /* RemoteException, */ Exception;
	
	boolean sale(String id, int q) throws /* RemoteException, */ Exception;
	
	boolean provision(String id, int q) throws /* RemoteException, */ Exception;
	
	State state(String id) throws /* RemoteException, */ Exception;
	
}
