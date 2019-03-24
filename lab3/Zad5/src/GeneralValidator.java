import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("GeneralValidator")
public class GeneralValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try{
            Integer data = Integer.parseInt(o.toString());
        }catch(NullPointerException e){
            FacesMessage msg =
                    new FacesMessage("Height validation failed","Pole wymagane");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        catch (NumberFormatException e){
            FacesMessage msg =
                    new FacesMessage("Height validation failed","Niepoprawne dane");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
