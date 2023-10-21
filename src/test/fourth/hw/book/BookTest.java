package fourth.hw.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class BookTest {
    Book book;

    @BeforeEach
    void setUp() {
       book = new Book("3", "Book3", "Author3");
    }

    @Test
    void checkGetId() {
        String id = book.getId();
        assertThat(id).isEqualTo("3");
    }

    @Test
    void checkGetTitle() {
        String title = book.getTitle();
        assertThat(title).isEqualTo("Book3");
    }
    @Test
    void checkGetAuthor() {
        String author = book.getAuthor();
        assertThat(author).isEqualTo("Author3");
    }
    @Test
    void checkSetId() {
        book.setId("4");
        String id = book.getId();
        assertThat(id).isEqualTo("4");
    }

    @Test
    void checkSetTitle() {
        book.setTitle("Book4");
        String title = book.getTitle();
        assertThat(title).isEqualTo("Book4");
    }
    @Test
    void checkSetAuthor() {
        book.setAuthor("Author4");
        String author = book.getAuthor();
        assertThat(author).isEqualTo("Author4");
    }
    @Test
    void checkBook() {
        Book book2 = new Book("5");
        assertThat(book2.getId()).isEqualTo("5");
        assertThat(book2.getTitle()).isNull();
        assertThat(book2.getAuthor()).isNull();
    }

}
