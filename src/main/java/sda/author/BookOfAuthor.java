package sda.author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BookOfAuthor {

    @Id
    @GeneratedValue
    private long id;
    private String title;

}