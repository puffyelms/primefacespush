package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.push.PushContext;
import org.primefaces.push.PushContextFactory;

@ManagedBean(name="adminBean")
@SessionScoped
public class AdminManagedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public AdminManagedBean(){
		
	}
	
	public void sendMessage(ActionEvent event) {
		PushContext pushContext = PushContextFactory.getDefault().getPushContext();
		pushContext.push("/notification", message);
		System.out.println("message="+message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
