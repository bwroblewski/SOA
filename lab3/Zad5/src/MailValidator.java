import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("MailValidator")
public class MailValidator implements Validator {

    private String regex = "^(.+)@(.+)$";

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String mailValue = o.toString();

            if (mailValue.equals("")){
                FacesMessage msg =
                        new FacesMessage("Mail validation failed","Podaj Mail");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
            if (!mailValue.matches(regex)){
                FacesMessage msg =
                        new FacesMessage("Mail validation failed","Niepoprawny adres mail");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }

    }
}
