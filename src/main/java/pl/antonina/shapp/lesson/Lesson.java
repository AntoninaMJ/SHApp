package pl.antonina.shapp.lesson;

import pl.antonina.shapp.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lessons_gen")
    @SequenceGenerator(name = "lessons_gen", sequenceName = "lessons_sequence", initialValue = 1)
    private Long id;
    private String name;
    private int points;
    @ManyToMany
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
