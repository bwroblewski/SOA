import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "Manager")
@SessionScoped
public class Manager {

    private Reader reader;

    private Author author;

    private Book book;

    private Rental rental;

    private List<Book> books = DBOperator.readAll(Book.class);

    private List<Author> authors = DBOperator.readAll(Author.class);

    private List<Reader> readers = DBOperator.readAll(Reader.class);

    private List<Rental> rentals = DBOperator.readAll(Rental.class);

    private <T extends Item> int generateId(List<T> list){
        boolean found = false;
        int id = -1;
        while(!found){
            found = true;
            id++;
            for(Item v :list){
                if(v.getId()==id) found =false;
            }
        }
        return id;
    }

    public List<Book> getBooks(){
        return books;
    }

    public List<Author> getAuthors(){
        return authors;
    }

    public List<String> getAuthorNames(){
            List<String> list = new ArrayList<String>();
            for(Author author: authors){
                list.add(author.getName() + " " + author.getSurname());
            }
            return list;

    }

    public List<String> getBookTitles(){
        List<String> list = new ArrayList<String>();
        for(Book book: books){
            list.add(book.getTitle());
        }
        return list;
    }

    public List<Reader> getReaders(){
        return readers;
    }

    public List<String> getReaderNames(){
        List<String> list =  new ArrayList<String>();
        for(Reader reader: readers){
                list.add(reader.getName() + " " + reader.getSurname());
            }
        return list;
    }

    public List<Rental> getRentals(){
        return rentals;
    }

    public void delete(int id,Object c){
        if(c.getClass()==Book.class) for(Book v: books){
            if(v.getId()== id) books.remove(v);
        };
        if(c.getClass()==Reader.class)  for(Reader v:readers){
            if(v.getId()== id) readers.remove(v);
        };
        if(c.getClass()==Rental.class) for(Rental v:rentals){
            if(v.getId()== id) rentals.remove(v);
        };
        if(c.getClass()==Author.class)  for(Author v:authors){
            if(v.getId()== id) authors.remove(v);
        };
        DBOperator.delete(id,c.getClass());
    }

    public void createReader(){
        System.out.println(">>>>>>>>>>>>>>PRINTING DATA: " + reader.getName() + " " + reader.getSurname()
                + "\n................. \n............\n..........\n............\n\n\n\n\n........................\n");
        reader.setId(generateId(readers));
        readers.add(reader);
        DBOperator.create(reader);
        reader = new Reader();
    }

    public void createAuthor() {
        author.setId(generateId(authors));
        authors.add(author);
        DBOperator.create(author);
        author = new Author();
}

    public void createBook(){
        book.setId(generateId(books));
        books.add(book);
        DBOperator.create(book);
        book = new Book();
    }

    public void createRental(){
        rental.setId(generateId(rentals));
        rentals.add(rental);
        DBOperator.create(rental);
        rental = new Rental();
    }

    public void updateReader(){
        for(Reader v:readers){
            if(v.getId()== reader.getId()) v.update(reader);
        }
        DBOperator.upate(reader);
    }

    public void updateAuthor() {
        for(Author v:authors){
            if(v.getId()==author.getId()) v.update(author);
        }
        DBOperator.upate(author);
    }

    public void updateBook(){
        for(Book v:books){
            if(v.getId()== book.getId()) v.update(book);
        }
        DBOperator.upate(book);
    }

    public void updateRental(){
        for(Rental v:rentals){
            if(v.getId()== rental.getId()) v.update(rental);
        }
        DBOperator.upate(rental);
    }

    public boolean isAuthorUpdateForm() {
        return authorUpdateForm;
    }

    public boolean isReaderUpdateForm() {
        return readerUpdateForm;
    }

    public boolean isBookUpdateForm() {
        return bookUpdateForm;
    }

    public boolean isRentalUpdateForm() {
        return rentalUpdateForm;
    }

    public boolean isAuthorCreateForm() {
        return authorCreateForm;
    }

    public boolean isReaderCreateForm() {
        return readerCreateForm;
    }

    public boolean isBookCreateForm() {
        return bookCreateForm;
    }

    public boolean isRentalCreateForm() {
        return rentalCreateForm;
    }

    private boolean authorUpdateForm = false;

    private boolean readerUpdateForm = false;

    private boolean bookUpdateForm = false;

    private boolean rentalUpdateForm = false;

    private boolean authorCreateForm = false;

    private boolean readerCreateForm = false;

    private boolean bookCreateForm = false;

    private boolean rentalCreateForm = false;

    public void dispAuthorUpdateForm(Author author){
        this.author=author;
        authorUpdateForm  = true;
        readerUpdateForm = false;
        bookUpdateForm = false;
        rentalUpdateForm = false;
        authorCreateForm  = false;
        readerCreateForm = false;
        bookCreateForm = false;
        rentalCreateForm = false;
    }

    public void dispReaderUpdateForm(Reader reader){
        this.reader = reader;
        authorUpdateForm  = false;
        readerUpdateForm = true;
        bookUpdateForm = false;
        rentalUpdateForm = false;
        authorCreateForm  = false;
        readerCreateForm = false;
        bookCreateForm = false;
        rentalCreateForm = false;
    }

    public void dispBookUpdateForm(Book book){
        this.book = book;
        authorUpdateForm  = false;
        readerUpdateForm = false;
        bookUpdateForm = true;
        rentalUpdateForm = false;
        authorCreateForm  = false;
        readerCreateForm = false;
        bookCreateForm = false;
        rentalCreateForm = false;
    }

    public void dispRentalUpdateForm(Rental rental){
        this.rental=rental;
        authorUpdateForm  = false;
        readerUpdateForm = false;
        bookUpdateForm = false;
        rentalUpdateForm = true;
        authorCreateForm  = false;
        readerCreateForm = false;
        bookCreateForm = false;
        rentalCreateForm = false;
    }

    public void dispAuthorCreateForm(){
        this.author = new Author();
        authorUpdateForm  = false;
        readerUpdateForm = false;
        bookUpdateForm = false;
        rentalUpdateForm = false;
        authorCreateForm  = true;
        readerCreateForm = false;
        bookCreateForm = false;
        rentalCreateForm = false;
    }

    public void dispReaderCreateForm(){
        this.reader = new Reader();
        authorUpdateForm  = false;
        readerUpdateForm = false;
        bookUpdateForm = false;
        rentalUpdateForm = false;
        authorCreateForm  = false;
        readerCreateForm = true;
        bookCreateForm = false;
        rentalCreateForm = false;
    }

    public void dispBookCreateForm(){
        this.book = new Book();
        authorUpdateForm  = false;
        readerUpdateForm = false;
        bookUpdateForm = false;
        rentalUpdateForm = false;
        authorCreateForm  = false;
        readerCreateForm = false;
        bookCreateForm = true;
        rentalCreateForm = false;
    }

    public void dispRentalCreateForm(){
        this.rental = new Rental();
        authorUpdateForm  = false;
        readerUpdateForm = false;
        bookUpdateForm = false;
        rentalUpdateForm = false;
        authorCreateForm  = false;
        readerCreateForm = false;
        bookCreateForm = false;
        rentalCreateForm = true;
    }

    public Date getReturnDate() {
        return rental.getReturnDate();
    }

    public void setReturnDate(Date returnDate) {
        if(returnDate!=null)this.rental.setReturnDate(returnDate);
    }

    public Date getRentalDate() {
        return rental.getRentalDate();
    }

    public void setRentalDate(Date rentalDate) {
        if(rentalDate!=null)this.rental.setRentalDate(rentalDate);
    }

    public Reader getRentalReader() {
        return rental.getReader();
    }

    public void setRentalReader(Reader rentalReader) {
        if(rentalReader!=null)this.rental.setReader(rentalReader);
    }

    public Book getRentalBook() {
        return rental.getBook();
    }

    public void setRentalBook(Book rentalBook) {
        this.rental.setBook(rentalBook);
    }

    public String getReaderName() {
        return reader.getName();
    }

    public void setReaderName(String readerName) {
        if(readerName!=null)this.reader.setName(readerName);
    }

    public String getReaderSurname() {
        return reader.getSurname();
    }

    public void setReaderSurname(String readerSurname) {
        if (readerSurname!=null)this.reader.setSurname(readerSurname);
    }

    public String getAuthorName() {
        return author.getName();
    }

    public void setAuthorName(String authorName) {
        this.author.setName(authorName);
    }

    public String getAuthorSurname() {
        return author.getSurname();
    }

    public void setAuthorSurname(String authorSurname) {
        this.author.setSurname(authorSurname);
    }

    public String getBookTitle() {
        return book.getTitle();
    }

    public void setBookTitle(String bookTitle) {
        this.book.setTitle(bookTitle);
    }

    public Author getBookAuthor() {
        return book.getAuthor();
    }

    public void setBookAuthor(Author bookAuthor) {
        this.book.setAuthor(bookAuthor);
    }

}
