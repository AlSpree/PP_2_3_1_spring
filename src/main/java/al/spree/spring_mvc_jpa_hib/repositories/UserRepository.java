package al.spree.spring_mvc_jpa_hib.repositories;

import al.spree.spring_mvc_jpa_hib.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
