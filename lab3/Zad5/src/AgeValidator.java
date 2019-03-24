import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("AgeValidator")
public class AgeValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            Integer value = Integer.parseInt(o.toString());
        }catch (NullPointerException e){
            FacesMessage msg =
                    new FacesMessage("Age validation failed","Podaj Wiek");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        Integer value = Integer.parseInt(o.toString());
        if (value> 100 || value <10){
            FacesMessage msg =
                    new FacesMessage("Mail validation failed","Niepoprawny wiek");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        facesContext.getAttributes().get("plec");
    }
}
