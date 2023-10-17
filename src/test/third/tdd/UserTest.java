package third.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    static UserRepository repository;

    @BeforeAll
    static void setUp() {
        repository = new UserRepository();
    }

    @Test
    void checkAuthenticateUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, password);
        assertTrue(accept);
    }

    @Test
    void checkAuthenticateUserNegative() {
        String name = "name";
        String password = "password";
        String wrongPassword = "wrongPassword";

        User user = new User(name, password, false);
        boolean accept = user.authenticate(name, wrongPassword);
        assertFalse(accept);
    }

    @Test
    void checkRepositoryAddAuthenticatedUserPositive() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);
        user.authenticate(name, password);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount + 1);

        User userInRepository =
                repository.data.get(repository.data.size() - 1);

        assertEquals(user, userInRepository);
    }

    @Test
    void checkRepositoryAddNotAuthenticatedUserNegative() {
        String name = "name";
        String password = "password";

        User user = new User(name, password, false);

        int currentCount = repository.data.size();
        repository.addUser(user);

        assertThat(repository.data.size())
                .isEqualTo(currentCount);
    }

    @Test
    void checkLogoutPositive() {
        String name = "name";
        String password = "password";
        boolean isAdmin = false;

        User user = new User(name, password, isAdmin);
        user.authenticate(name, password);
        boolean value = user.logout(name, password);
        assertTrue(value);
    }

    @Test
    void checkLogoutNegative() {
        String name = "name";
        String password = "password";
        boolean isAdmin = true;

        User user = new User(name, password, isAdmin);
        user.authenticate(name, password);
        boolean value = user.logout(name, password);
        assertFalse(value);
    }

    @Test
    void checkRemovalUserPositive() {
        String name = "name";
        String password = "password";
        boolean isAdmin = false;

        User user = new User(name, password, isAdmin);
        int sizeRepository = repository.data.size();
        user.authenticate(name, password);
        repository.addUser(user);
        repository.removeUser(user);
        int sizeRepositoryAfterRemove = repository.data.size();
        Assertions.assertEquals(sizeRepository, sizeRepositoryAfterRemove);
    }

    @Test
    void checkRemovalUserNegative() {
        String name = "name";
        String password = "password";
        boolean isAdmin = true;

        User user = new User(name, password, isAdmin);
//        int sizeRepository = repository.data.size();
        user.authenticate(name, password);
        repository.addUser(user);
//        repository.removeUser(user);
//        int sizeRepositoryAfterRemove = repository.data.size();
//        Assertions.assertEquals(sizeRepository + 1, sizeRepositoryAfterRemove);
        assertThatThrownBy(() -> repository.removeUser(user)).isInstanceOf(RuntimeException.class)
                .hasMessage("You cannot delete the administrator");
    }
}