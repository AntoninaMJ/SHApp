package pl.antonina.shapp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.antonina.shapp.user.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByGender(Gender gender);
    List<User> findByNameContains(String name);
    List<User> findByGenderAndNameContains(Gender gender, String name);
}