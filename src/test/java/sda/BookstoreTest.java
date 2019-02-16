package sda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class BookstoreTest {
    @DisplayName("should add new book")
    @Test
    void test() throws Exception {
        //given
        BookStoreManager manager = createBookStore();

        //when
        manager.add("Thinking in Java", "Bruce Eckel");

        //then
        Collection<Book> allBooks = manager.findAll();
        Assertions.assertThat(allBooks).hasSize(1);
    }

    private BookStoreManager createBookStore() {
//        return new JdbcBookStoreManager();
         return new JpaBookStoreManager();
    }
}
