package third.tdd;

import java.util.Objects;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;
    boolean isAdmin;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public boolean authenticate(String name, String password) {

        isAuthenticate = Objects.equals(this.name, name) &&
                Objects.equals(this.password, password);
        return isAuthenticate;
    }
    public boolean logout(String name, String password) {

        if (this.name.equals(name) &&
                this.password.equals(password) && !this.isAdmin) {
            isAuthenticate = false;
            return true;
        } else return false;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}