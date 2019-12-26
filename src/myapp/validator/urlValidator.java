package myapp.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("urlValidator")
public class urlValidator implements Validator {
	private static final Pattern URL_PATTERN = Pattern.compile("^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$");

	@Override
	public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

		if (o == null) {
			return;
		}

		String url = (String) o;
		boolean matches = URL_PATTERN.matcher(url).matches();
		if (!matches) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "L'URL n'est pas valide !", null);
			throw new ValidatorException(msg);
		}

	}
}