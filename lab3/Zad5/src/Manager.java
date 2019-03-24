import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.security.KeyStore;

@ManagedBean(name = "Manager")
@SessionScoped
public class Manager {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String[] genders = {"Kobieta", "Mezczyzna"};

    public String[] getGenders() {
        return genders;
    }

    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String[] ed_types = {"Podstawowe","Srednie", "Wyzsze"};

    public String[] getEd_types() {
        return ed_types;
    }

    private String education;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    private Integer height;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    private boolean male = false;

    public boolean isMale() {
        return male;
    }

    private boolean female = false;

    public boolean isFemale() {
        return female;
    }

    private Integer breast;

    public Integer getBreast() {
        return breast;
    }

    public void setBreast(Integer breast) {
        this.breast = breast;
    }

    private String[] cups = {"A","B","C","D","E","F","G","H"};

    public String[] getCups() {
        return cups;
    }

    private String cup;

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    private Integer waist;

    public Integer getWaist() {
        return waist;
    }

    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    private Integer hips;

    public Integer getHips() {
        return hips;
    }

    public void setHips(Integer hips) {
        this.hips = hips;
    }

    private Integer ribcage;

    public Integer getRibcage() {
        return ribcage;
    }

    public void setRibcage(Integer ribcage) {
        this.ribcage = ribcage;
    }

    private Integer belt;

    public Integer getBelt() {
        return belt;
    }

    public void setBelt(Integer belt) {
        this.belt = belt;
    }

    private boolean extra = false;

    public boolean isExtra() {
        return extra;
    }

    public void toggleExtra(){
        extra = true;
    }

    private String[] question1 = {"do 100zl", "100-500zl", "500-100zl", "powyzej 1000zl"};

    public String[] getQuestion1() {
        return question1;
    }

    private String answer1;

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    private String[] question2 = {"Codziennie", "Raz w tygodniu", "Raz w miesiacu", "Raz w roku"};

    public String[] getQuestion2() {
        return question2;
    }

    private String answer2;

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    private String[] question3 = {"Kolorowo-jaskrawych","Stonowanych szarosciach","W czerni i bieli","W samej czerni"};

    public String[] getQuestion3() {
        return question3;
    }

    private String[] answer3;

    public String[] getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String[] answer3) {
        this.answer3 = answer3;
    }

    private String[] questionf = {"garsonki","bluzki","spodniczki","spodnie"};

    public String[] getQuestionf() {
        return questionf;
    }

    private String[] questionm = {"spodnie", "spodenki","koszule","krawaty","garnitury"};

    public String[] getQuestionm() {
        return questionm;
    }

    private String[] answer;

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public void dispGender(){
        if(gender.equals("Mezczyzna")){
            male = true;
            female = false;
        }
        if(gender.equals("Kobieta")){
            male = false;
            female = true;
        }
    }

}
