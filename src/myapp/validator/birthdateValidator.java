package myapp.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("birthdateValidator")
public class birthdateValidator implements Validator {

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

		if (o == null) {
			return;
		}
		
		boolean enter = false;
		
		if (enter == false) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "L'URL n'est pas valide !", null);
			throw new ValidatorException(msg);
		}

	}
}