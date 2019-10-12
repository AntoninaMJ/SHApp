package pl.antonina.shapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(Gender gender, String name) {
        if (gender == null){
            if (name == null){
                return userRepository.findAll();
            }
            return userRepository.findByNameContains(name);
        }
        if (name == null){
            return userRepository.findByGender(gender);
        }
        return userRepository.findByGenderAndNameContains(gender, name);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void addUser(UserData userData) {
        User user = new User();
        user.setName(userData.getName());
        user.setGender(userData.getGender());
        userRepository.save(user);
    }

    public void updateUser(Long id, UserData userData) {
        User user = getUser(id);
        user.setName(userData.getName());
        user.setGender(userData.getGender());
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
