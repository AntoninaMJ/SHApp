package pl.antonina.shapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listOfUsersByParam(@RequestParam(required = false) Gender gender, @RequestParam(required = false) String name) {
        return userService.getUsers(gender, name);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping //zamiast @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody UserData userData) {
        userService.addUser(userData);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserData userData) {
        userService.updateUser(id, userData);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}