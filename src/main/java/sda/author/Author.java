package sda.author;


import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;

    @OneToMany
    private Collection<BookOfAuthor> books;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Author(){

    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getSurname() {
        return surname;
    }
}
