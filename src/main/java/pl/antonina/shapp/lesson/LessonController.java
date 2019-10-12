package pl.antonina.shapp.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @GetMapping
    public List<LessonToGet> getAllLessons(){
        return lessonService.getAllLessons();
    }

    @GetMapping("/{name}")
    public List<LessonToGet> getLessonsByName(@PathVariable String name){
        return lessonService.getLessonsByName(name);
    }

    @GetMapping("/byUser/{userId}")
    public List<LessonToGet> getLessonsByUserId(@PathVariable Long userId){
        return lessonService.getLessonsByUserId(userId);
    }

    @PostMapping
    public void addLesson(@RequestBody LessonData lessonData){
        lessonService.addLesson(lessonData);
    }

    @PutMapping("/{id}")
    public void updateLesson(@PathVariable Long id, @RequestBody LessonData lessonData){
        lessonService.updateLesson(id, lessonData);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id){
        lessonService.deleteLesson(id);
    }




}
