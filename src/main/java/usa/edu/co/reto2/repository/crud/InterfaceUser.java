package usa.edu.co.reto2.repository.crud;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import usa.edu.co.reto2.model.User;

/**
 *
 * @author karen
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    //List<User> findBybirthDay(Date date);
    Optional<User> findByEmailAndPassword(String email, String password);
    // Optional<User>  findByNameorEmail(String name,String email);
    //List<User> findByMonthBirthtDay(string monthBirthtDay);
    
    
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
    //optional<User> findTopByOrderByIdDesc();
}
