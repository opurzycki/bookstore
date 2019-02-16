package sda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;

public class JpaBookStoreManager implements BookStoreManager {

    private EntityManager entityManager;

    public JpaBookStoreManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void add(String title, String author) {
        Book book = new Book(title, author);
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT bookObj FROM Book bookObj").getResultList();
    }
}
