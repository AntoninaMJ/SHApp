package pl.antonina.shapp.activity;

import pl.antonina.shapp.user.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activities_gen")
    @SequenceGenerator(name = "activities_gen", sequenceName = "activities_sequence", allocationSize = 1)
    private Long id;
    private Name name;
    @Column(scale = 1,precision = 2)
    private Double hours;
    //private Date date;
    @ManyToMany
    private List<User> users;

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    /*public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

     */
}
