package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserDao<T> {
   void add(User user);
//   void add(Car car);
   List<T> listUsers();

List<User> listUsersWithCarModel(String model, int series);


}
