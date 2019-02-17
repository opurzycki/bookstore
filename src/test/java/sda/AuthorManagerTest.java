package sda;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sda.author.Author;
import sda.author.AuthorManager;

import java.util.Optional;

public class AuthorManagerTest {

    @Test
    @DisplayName("add author to db and check if it exists")
    public void addAuthorTest(){

        //given
        Author author = new Author("Adam", "Mickiewicz");
        AuthorManager manager = new AuthorManager();

        //when
        manager.addAuthor(author);

        //then
        Optional<Author> foundAuthor = manager.findAnyAuthor();
        Assertions.assertThat(foundAuthor).hasValue(author);
    }

    @Test
    @DisplayName("add 2 authors and find one of them by surname")
    public void findSurnameTest(){
        //given
        Author author = new Author("Adam", "Mickiewicz");
        Author author2 = new Author("Juliusz", "Slowacki");
        AuthorManager manager = new AuthorManager();
        manager.addAuthor(author);
        manager.addAuthor(author2);

        //when
        Optional<Author> result = manager.findAnyBySurname("Slowacki");

        //then
        Assertions.assertThat(result.get().getSurname()).isEqualTo("Slowacki");
    }

}
