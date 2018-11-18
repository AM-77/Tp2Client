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
import javafx.scene.paint.Color;

public class FXMLDocumentController  implements Initializable {

	private static State state;
	private static IStock stockImpl;
	
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
		if(isValidInput(create_id, create_q, create_confirm)){

			try{
				if(stockImpl.createArticle(create_id.getText().trim(), Integer.parseInt(create_q.getText().trim()))){
					confirmMessage(create_confirm, "The article was created succefully");
				}else{
					errorMessage(create_confirm, "There was an error, please try again.");
				}
			}catch(Exception e){
				errorMessage(create_confirm, "The article already exists.");
			}
		} 
	}
	
	@FXML
	public void onSale(){
		if(isValidInput(sale_id, sale_q, sale_confirm)){
			try{
				if(stockImpl.sale(sale_id.getText().trim(), Integer.parseInt(sale_q.getText().trim()))){
					confirmMessage(sale_confirm, "The article was sold succefully");
				}else{
					errorMessage(sale_confirm, "The article quntity insuffisable. Only " +  stockImpl.state(sale_id.getText().trim()).getq() + " item left." );
				}
			}catch(Exception e){
				
				System.out.println(e.getMessage());
				errorMessage(sale_confirm, "The article '" + sale_id.getText().trim() + "' does not exist.");
			}	
		}
	}
	
	@FXML
	public void onAppro(){
		if(isValidInput(prov_id, prov_q, prov_confirm)){
			try{
				if(stockImpl.provision(prov_id.getText().trim(), Integer.parseInt(prov_q.getText().trim()))){
					confirmMessage(prov_confirm, "The article was provided succefully");
				}else{
					errorMessage(prov_confirm, "There was an error, please try again.");
				}
			}catch(Exception e){
				errorMessage(prov_confirm, "The article '" + prov_id.getText().trim() + "' does not exist.");
			}	
		}
	}
	
	@FXML
	public void onState(){
		if(isValidInput(state_id, _state_q, state_confirm)){
			try{
				state = (State) stockImpl.state(state_id.getText().trim());
				state_q.setText(state.getq() + " item.");

				state_l_op.setText(state.getLastOp().toString().substring(0, 10) + " at" + state.getLastOp().toString().substring(10, state.getLastOp().toString().length()-2));
				
				confirmMessage(state_confirm, "");
			}catch(Exception e){
				
				state_q.setText("");
				state_l_op.setText("");
				
				errorMessage(state_confirm, "The article '" + state_id.getText().trim() + "' does not exist.");
			}	
		}
	}
	
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    	try {
    		
    		System.setProperty("java.rmi.server.hostname","10.42.0.1");
			System.setSecurityManager(new SecurityManager());
			Registry registry = LocateRegistry.getRegistry(1099);
			stockImpl =  (IStock) registry.lookup("stockImpl");	
			
		} catch (Exception e) {
			System.err.println("There was an error in intialize :" + e.getMessage());
		}
    	
    }  
    
    public void errorMessage(Label l, String msg){
    	l.setText(msg);
    	l.setTextFill(Color.web("#E11919"));
    }
    
    public void confirmMessage(Label l, String msg){
    	l.setText(msg);
    	l.setTextFill(Color.web("#119955"));
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
