package sda;

import java.util.Collection;

public interface BookStoreManager {

    void add(String title, String author);

    Collection<Book> findAll();


}
