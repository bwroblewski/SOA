import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DBOperator {

    /**
     * Create a new Book.
     * @param object
     */
    public static void create(Object object) {
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


            // Save the book object
            manager.persist(object);

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
    public static <T> List<T> readAll(Class<T> c) {

        List items = null;

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

            String str = "";
            if(c==Book.class) str = "SELECT i FROM Book i";
            if(c==Author.class) str = "SELECT i FROM Author i";
            if(c==Reader.class) str = "SELECT i FROM Reader i";
            if(c==Rental.class) str = "SELECT i FROM Rental i";
            items = manager.createQuery(str,
                    c).getResultList();

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
        return items;
    }

    /**
     * Delete the existing Student.
     *
     * @param id
     */
    public static <T> void delete(int id, Class<T> c) {
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
            T item = manager.find(c, id);

            // Delete the book
            manager.remove(item);

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
     * @param object
     */
    public static void upate(Item object) {
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

            Item item = manager.find(object.getClass(),object.getId());
            item.update(object);
            manager.persist(item);

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