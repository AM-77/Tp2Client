package tp2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage; */

public class StockClient /* extends Application */{
	
	private static State state;
	private static IStock stockImpl;
	
	public static void main(String[] args) throws Exception{
		//launch(args);
		
		System.setProperty("java.rmi.server.hostname","192.168.43.239");
		System.setSecurityManager(new SecurityManager());
		Registry registry = LocateRegistry.getRegistry(1099);
		stockImpl =  (IStock) registry.lookup("stockImpl");	
		
		System.out.println(stockImpl.sale("cool",  11000));
		
		state = stockImpl.state("cool");
		
		System.out.println(state.getLastOp());
		
	}
/*	
	@Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Tp2Client.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Tp2 Client Side");
        
        stage.show();
    }
	*/
}
