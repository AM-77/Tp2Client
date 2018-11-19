package tp2;

import java.rmi.Remote;

public interface IStock extends Remote{
		
	boolean createArticle(String id, int q_init) throws Exception;
	
	boolean sale(String id, int q) throws Exception;
	
	boolean provision(String id, int q) throws Exception;
	
	State state(String id) throws Exception;
	
}
