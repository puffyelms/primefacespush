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
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pushContext.push("/notification", message+i);
//			System.out.println("message sent="+message+i);
		}

	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
