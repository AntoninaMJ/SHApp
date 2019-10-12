package pl.antonina.shapp.activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.antonina.shapp.user.User;
import pl.antonina.shapp.user.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserService userService;

    public List<ActivityToGet> getActivitiesByName(Name name) {
        return activityRepository.findByName(name).stream()
                .map(this::mapActivityToGet)
                .collect(Collectors.toList());
    }

    public ActivityToGet getActivity(Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow(ActivityNotFoundException::new);
        return mapActivityToGet(activity);
    }

    public List<ActivityToGet> getActivitiesByUserId(Long userId) {
        return activityRepository.findByUsers_id(userId).stream()
                .map(this::mapActivityToGet)
                .collect(Collectors.toList());
    }

    public void addActivity(ActivityData activityData) {
        Activity activity = mapActivity(activityData, new Activity());
        activityRepository.save(activity);
    }

    public void updateActivity(Long id, ActivityData activityData) {
        Activity activity = mapActivity(activityData, activityRepository.getOne(id));
        activityRepository.save(activity);
    }

    public void deleteActivity(Long id) {
        activityRepository.deleteById(id);
    }

    public ActivityToGet mapActivityToGet(Activity activity) {
        ActivityToGet activityToGet = new ActivityToGet();
        activityToGet.setId(activity.getId());
        activityToGet.setHours(activity.getHours());
        //activityToGet.setDate(activity.getDate());
        activityToGet.setName(activity.getName());
        activityToGet.setUsersId(activity.getUsers().stream()
                .map(User::getId)
                .collect(Collectors.toList()));
        return activityToGet;
    }

    private Activity mapActivity(ActivityData activityData, Activity activity) {
        //activity.setDate(activityData.getDate());
        activity.setHours(activityData.getHours());
        activity.setName(activityData.getName());
        activity.setUsers(activityData.getUsersId().stream()
                .map(userService::getUser)
                .collect(Collectors.toList()));
        return activity;
    }
}
