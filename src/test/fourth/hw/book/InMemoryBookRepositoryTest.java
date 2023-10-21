package fourth.hw.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InMemoryBookRepositoryTest {
    static InMemoryBookRepository imbr;

    @BeforeAll
    static void setUp() {
        imbr = new InMemoryBookRepository();
    }

    @Test
    void checkInMemoryBookRepositoryFindById() {
        Book book = imbr.findById("1");
        assertThat(book.getId()).isEqualTo("1");
        assertThat(book.getTitle()).isEqualTo("Book1");
        assertThat(book.getAuthor()).isEqualTo("Author1");
    }
    @Test
    void checkInMemoryBookRepositoryFindAll() {
        List<Book> books = imbr.findAll();
        assertThat(books.get(0).getId()).isEqualTo("1");
        assertThat(books.get(0).getTitle()).isEqualTo("Book1");
        assertThat(books.get(0).getAuthor()).isEqualTo("Author1");
        assertThat(books.get(1).getId()).isEqualTo("2");
        assertThat(books.get(1).getTitle()).isEqualTo("Book2");
        assertThat(books.get(1).getAuthor()).isEqualTo("Author2");
    }

}
