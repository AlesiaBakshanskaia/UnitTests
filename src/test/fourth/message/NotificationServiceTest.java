package fourth.message;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;




class NotificationServiceTest {
    @Test
    void messageServiceTest() {
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        messageService.sendMessage("Hello", "Vasia");

        verify(messageService, times(1)).sendMessage("Hello", "Vasia");
    }
}