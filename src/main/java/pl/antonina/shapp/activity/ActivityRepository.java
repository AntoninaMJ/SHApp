package pl.antonina.shapp.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.antonina.shapp.user.User;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByName(Name name);
    List<Activity> findByUsers_id(Long id);
}
