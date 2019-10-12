package pl.antonina.shapp.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.antonina.shapp.user.User;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<ActivityToGet> listOfActivitiesByName(@RequestParam (required = false) Name name){
        return activityService.getActivitiesByName(name);
    }

    @GetMapping("/{id}")
    public ActivityToGet getActivity(@PathVariable Long id){
        return activityService.getActivity(id);
    }

    @GetMapping("/byUser/{userId}")
    public List<ActivityToGet> getActivitiesByUserId(@PathVariable Long userId){
        return activityService.getActivitiesByUserId(userId);
    }

    @PostMapping
    public void addActivity(@RequestBody ActivityData activityData){
        activityService.addActivity(activityData);
    }

    @PutMapping("/{id}")
    public void updateActivity(@PathVariable Long id, @RequestBody ActivityData activityData){
        activityService.updateActivity(id, activityData);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable Long id){
        activityService.deleteActivity(id);
    }
}
