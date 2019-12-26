package myapp.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class emailValidator implements Validator {
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

		if (o == null) {
			return;
		}

		String email = (String) o;
		boolean matches = EMAIL_PATTERN.matcher(email).matches();
		if (!matches) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "L'email n'est pas valide !", null);
			throw new ValidatorException(msg);
		}

	}
}