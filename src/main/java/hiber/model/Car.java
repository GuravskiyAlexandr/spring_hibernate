package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "series")
    private Integer series;

    @Column(name = "model")
    private String model;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car() {
    }

    public Car(Integer series, String firstName) {
        this.series = series;
        this.model = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getFirstName() {
        return model;
    }

    public void setFirstName(String firstName) {
        this.model = firstName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", model='"  + model+
                '}';
    }
}
