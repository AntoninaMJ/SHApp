package pl.antonina.shapp.activity;

import pl.antonina.shapp.user.User;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.List;

public class ActivityData {

    private Name name;
    private Double hours;
    //private Date date;
    private List<Long> usersId;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public List<Long> getUsersId() {
        return usersId;
    }

    public void setUsersId(List<Long> usersId) {
        this.usersId = usersId;
    }

    /*
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

     */
}
