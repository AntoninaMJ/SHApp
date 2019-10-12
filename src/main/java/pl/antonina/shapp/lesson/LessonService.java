package pl.antonina.shapp.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.antonina.shapp.user.User;
import pl.antonina.shapp.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private UserService userService;

    public List<LessonToGet> getAllLessons() {
        return lessonRepository.findAll().stream().map(this::mapLessonToGet)
                .collect(Collectors.toList());
    }

    public List<LessonToGet> getLessonsByName(String name) {
        return lessonRepository.findByNameContains(name).stream()
                .map(this::mapLessonToGet)
                .collect(Collectors.toList());
    }

    public List<LessonToGet> getLessonsByUserId(Long userId) {
        return lessonRepository.findByUsers_id(userId).stream()
                .map(this::mapLessonToGet)
                .collect(Collectors.toList());
    }

    public void addLesson(LessonData lessonData) {
        lessonRepository.save(mapLesson(new Lesson(), lessonData));
    }

    public void updateLesson(Long id, LessonData lessonData) {
        Lesson lesson = lessonRepository.getOne(id);
        lessonRepository.save(mapLesson(lesson, lessonData));

    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    private Lesson mapLesson(Lesson lesson, LessonData lessonData){
        lesson.setName(lessonData.getName());
        lesson.setPoints(lessonData.getPoints());
        lesson.setUsers(lessonData.getUsersId().stream()
                .map(userService::getUser)
                .collect(Collectors.toList()));
        return lesson;
    }

    private LessonToGet mapLessonToGet (Lesson lesson){
        LessonToGet lessonToGet = new LessonToGet();
        lessonToGet.setId(lesson.getId());
        lessonToGet.setName(lessonToGet.getName());
        lessonToGet.setPoints(lesson.getPoints());
        lessonToGet.setUsersId(lesson.getUsers().stream()
                .map(User::getId)
                .collect(Collectors.toList()));
        return lessonToGet;
    }
}