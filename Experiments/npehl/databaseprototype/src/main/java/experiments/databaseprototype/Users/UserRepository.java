package experiments.databaseprototype.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author Nick Pehl, Cam Lettieri
 * 
 */ 
public interface UserRepository extends JpaRepository<User, Long> 
{
	    
	    User findById(int id);

	   // @Transactional
	    void deleteById(int id);
}
