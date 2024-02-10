package hiber.dao;
import hiber.model.User;
import java.util.List;

public interface UserDao<T> {
   void add(User user);
   List<T> listUsers();
   List<User> listUsersWithCarModel(String model, int series);


}
