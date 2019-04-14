import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;


@ManagedBean(name = "Manager")
@SessionScoped
public class Manager {

    private boolean updateForm = false;

    private boolean createForm = false;

    private DBOperator operator = new DBOperator();

    private int id = -1;

    private String name;

    private String surname;

    private String title;

    private String isbn;

    private String year;

    private String price;

    //private List<Book> books ;

    public List<Book> getBooks() {
        return operator.readAll();
    }

    private int generateId(){
        boolean found = false;
        List<Book> books = operator.readAll();
        int id = -1;
        while(!found){
            id++;
            found = true;
            for(Book book: books) {
                if (book.getId() == id) found = false;
            }
        }
        return id;
    }

    private void resetForm(){
        id = -1;
        name="";
        surname="";
        title="";
        isbn="";
        year="";
        price="";
    }

    public void hideForms(){
        createForm = false;
        updateForm = false;
    }

    public void addBook(){
        System.out.println("Printing BookData: "+ name + ", " + surname + ", " + title + ", " + isbn + ", " + year + ", " + price);
        DBOperator.create(generateId(),this.name,this.surname,this.title,this.isbn,this.year,this.price);
    }


    public void displayAddForm(){
        resetForm();
        createForm = true;
        updateForm = false;
    }

    public void displayUpdateForm(Book book){
        id = book.getId();
        name=book.getName();
        surname=book.getSurname();
        title= book.getTitle();
        isbn=book.getIsbn();
        year= book.getYear();
        price=book.getPrice();
        createForm=false;
        updateForm=true;
    }

    public void updateBook(){
        DBOperator.upate(this.id,this.name,this.surname,this.title,this.isbn,this.year,this.price);
    }

    public void deleteBook(int id){
        DBOperator.delete(id);
    }

    public boolean isUpdateForm() {
        return updateForm;
    }

    public boolean isCreateForm() {
        return createForm;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
