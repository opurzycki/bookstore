package sda.author;

import javax.persistence.*;
import java.util.Optional;

public class AuthorManager {

    private EntityManager manager;
    public AuthorManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        manager = factory.createEntityManager();
    }

    public void addAuthor(Author author){
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(author);
        transaction.commit();
    }

    public void addBookToExistingAuthor(BookOfAuthor book, long id){

    }

    public Optional<Author> findAnyAuthor() {
        Author result = manager.createQuery("SELECT author from Author author", Author.class).getSingleResult();
        return Optional.ofNullable(result);
    }

    public Optional<Author> findAnyBySurname(String surname){
        TypedQuery<Author> query = manager.createQuery("SELECT author from Author author where author.surname=:surname",
                Author.class);
        query.setParameter("surname", surname);
        return Optional.ofNullable(query.getSingleResult());
    }
}
