package fourth.hotel;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class BookingServiceTest {
    @Test
    void bookingTestPositive() {
        HotelService hotelService = mock(HotelService.class);
        BookingService bookingService = new BookingService(hotelService);
        when(hotelService.isRoomAvailable(2)).thenReturn(true);

        boolean check = bookingService.bookRoom(2);

        verify(hotelService, times(1)).isRoomAvailable(2);
        assertThat(check).isEqualTo(true);
    }
}