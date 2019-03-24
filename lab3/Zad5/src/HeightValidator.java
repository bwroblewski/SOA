import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("HeightValidator")
public class HeightValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        try {
            String gender = "Mezczyzna";
            //String gender = (String) uiComponent.getPassThroughAttributes().get("Gender");
            Integer height = Integer.parseInt(o.toString());
            if (gender.equals("Mezczyzna")){
                if(height<165){
                    FacesMessage msg =
                            new FacesMessage("Height validation failed","Wzrost zbyt mały (min 165 cm)");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msg);
                }
                if(height>200){
                    FacesMessage msg =
                            new FacesMessage("Height validation failed","Wzrost zbyt duzy (max 200 cm)");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msg);
                }
            }
            if (gender.equals("Kobieta")){
                if(height<150){
                    FacesMessage msg =
                            new FacesMessage("Height validation failed","Wzrost zbyt mały (min 150 cm)");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msg);
                }
                if(height>185){
                    FacesMessage msg =
                            new FacesMessage("Height validation failed","Wzrost zbyt duzy (max 185 cm)");
                    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(msg);
                }
            }
        }catch(NullPointerException e){
            FacesMessage msg =
                    new FacesMessage("Height validation failed","Podaj wzrost");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        catch (NumberFormatException e){
            FacesMessage msg =
                    new FacesMessage("Height validation failed","Niepoprawne dane");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        catch (ValidatorException e){
            throw e;
        }
    }
}
