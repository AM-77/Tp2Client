package tp2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStock extends Remote{
		
	void createArticle(String id, int q_init) throws RemoteException;
	
	boolean sale(String id, int q) throws RemoteException;
	
	void provision(String id, int q) throws RemoteException;
	
	State state(String id) throws RemoteException;
	
}
