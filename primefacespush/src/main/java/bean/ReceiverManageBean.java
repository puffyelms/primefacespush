package bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name="rBean")
@SessionScoped
public class ReceiverManageBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public ReceiverManageBean() {
		
	}
	
	public void receiveMessage(ActionEvent e) {
		//receive message
		System.out.println("message received");
		
		String msgFromAdmin = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("msg");
		
		FacesContext.getCurrentInstance().addMessage("outMessage", new FacesMessage(FacesMessage.SEVERITY_WARN, "New Message", msgFromAdmin));
		
	}
}
