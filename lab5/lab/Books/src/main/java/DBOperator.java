import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DBOperator {

    /**
     * Create a new Book.
     * @param id
     * @param name
     * @param surname
     * @param title
     * @param isbn
     * @param year
     * @param price
     */
    public static void create(int id, String name,  String surname,  String title,  String isbn, String year, String price) {
        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {


            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new Book object
            Book book = new Book();
            book.setId(id);
            book.setName(name);
            book.setSurname(surname);
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setYear(year);
            book.setPrice(price);

            // Save the book object
            manager.persist(book);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Read all the Books.
     *
     * @return a List of Books
     */
    public static List<Book> readAll() {

        List books = null;

        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of books
            books = manager.createQuery("SELECT s FROM Book s",
                    Book.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return books;
    }

    /**
     * Delete the existing Student.
     *
     * @param id
     */
    public static void delete(int id) {
        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Book object
            Book book = manager.find(Book.class, id);

            // Delete the book
            manager.remove(book);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    /**
     * Update the existing Student.
     *
     * @param id
     * @param name
     * @param surname
     * @param title
     * @param isbn
     * @param year
     * @param price
     */
    public static void upate(int id, String name,  String surname,  String title,  String isbn, String year, String price) {
        // Create an EntityManager
        EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
                .createEntityManagerFactory("JPA-Zajecia");
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get the Book object
            Book book = manager.find(Book.class, id);

            // Change the values
            book.setName(name);
            book.setSurname(surname);
            book.setIsbn(isbn);
            book.setTitle(title);
            book.setYear(year);
            book.setPrice(price);

            // Update the book
            manager.persist(book);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }
}
