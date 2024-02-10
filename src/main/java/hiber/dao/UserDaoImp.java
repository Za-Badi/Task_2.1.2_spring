package hiber.dao;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public List<User> listUsersWithCarModel(String carModel, int carSeries) {
      String q = (" select a from  User  a inner join a.car WHERE a.car.model=  :model and a.car.series=  :series");
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(q).setParameter("model", carModel).setParameter("series", carSeries);
      return query.getResultList();
   }



}
