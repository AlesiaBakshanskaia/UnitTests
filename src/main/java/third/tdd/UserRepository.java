package third.tdd;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if(!user.isAuthenticate) return;
        data.add(user);
    }

    public void removeUser(User userToRemove) {
        userToRemove.logout(userToRemove.getName(),userToRemove.getPassword());
        if(!userToRemove.isAuthenticate) {
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).equals(userToRemove)) {
                    data.remove(i);
                }
            }
       }  else throw new RuntimeException("You cannot delete the administrator");
    }


    //    public boolean findByName(String username) {
//        for (User user : data) {
//            if (user.name.equals(username)) {
//                return true;
//            }
//        }
//        return false;
//    }
}