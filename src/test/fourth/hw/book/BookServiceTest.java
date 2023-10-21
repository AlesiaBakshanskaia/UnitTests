package fourth.hw.book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


class BookServiceTest {
    BookRepository bookRepository;
    BookService bookService;
    Book book1;
    @BeforeEach
    void setUP() {
        bookRepository = mock(BookRepository.class);
        bookService = new BookService(bookRepository);
        book1 = new Book("1", "Book1", "Author1");
    }

    @Test
    void checkFindAllBooks() {
        List<Book> listAllBooks = new ArrayList<>();
        Book book2 = new Book("2", "Book2", "Author2");
        listAllBooks.add(book1);
        listAllBooks.add(book2);
        when(bookRepository.findAll()).thenReturn(listAllBooks);

        List<Book> books = bookService.findAllBooks();

        verify(bookRepository).findAll();
        assertThat(books).isNotEmpty().hasSize(2).isEqualTo(listAllBooks);
    }

    @Test
    void checkFindById() {
        when(bookRepository.findById(anyString())).thenReturn(book1);

        Book book = bookService.findBookById("1");

        assertThat(bookRepository.findById("1")).isEqualTo(book1);
    }

}