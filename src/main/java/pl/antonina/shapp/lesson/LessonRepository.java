package pl.antonina.shapp.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByNameContains(String name);
    List<Lesson> findByUsers_id(Long userId);
}
