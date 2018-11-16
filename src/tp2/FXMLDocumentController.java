package tp2;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class FXMLDocumentController  implements Initializable {

	@FXML
	public Button create_btn;
	@FXML
	public Button sale_btn;
	@FXML
	public Button prov_btn;
	@FXML
	public Button state_btn;
	@FXML
	public Label create_confirm;
	@FXML
	public Label sale_confirm;
	@FXML
	public Label prov_confirm;
	@FXML
	public Label state_confirm;
	@FXML
	public Label state_q;
	@FXML
	public Label state_l_op;
	@FXML
	public TextField create_id;
	@FXML
	public TextField create_q;
	@FXML
	public TextField sale_id;
	@FXML
	public TextField sale_q;
	@FXML
	public TextField prov_id;
	@FXML
	public TextField prov_q;
	@FXML
	public TextField state_id;
	@FXML
	public TextField _state_q;

	@FXML
	public void onCreate(){

	}
	
	@FXML
	public void onSale(){

	}
	
	@FXML
	public void onAppro(){
		
	}
	
	@FXML
	public void onState(){

	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	try {
			System.setSecurityManager(new SecurityManager());
			Registry registry = LocateRegistry.getRegistry(1099);
			stockImpl =  (IStock) registry.lookup("stockImpl");	
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    }  
    
    public void errorMessage(Label l, String msg){
    	l.setText(msg);
    }
    
    public void confirmMessage(Label l, String msg){
    	l.setText(msg);
    }
    
    public boolean isValidInput(TextField id, TextField q, Label confirm){
    			
		if(! id.getText().trim().equals("")){
			try{
				if(Integer.parseInt(q.getText().trim()) >=0){
					return true;
				}else{
					errorMessage(confirm, "Please enter a valid quantity number.");
					return false;
				}
			}catch(Exception e){
				errorMessage(confirm, "Please enter a valid quantity number.");
			}
		}else{
			errorMessage(confirm, "Please enter a valid article ID.");
		} 
    	
    	return false;
    }
        
}
