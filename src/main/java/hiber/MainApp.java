package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);


        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");


        userService.add(user1);
        userService.add(user2);
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        Car car1 = new Car(3000, "Lamborghini Diablo");
        Car car2 = new Car(220, "Mercedes-Benz");


        car2.setUser(user2);

        carService.add(car2);

        car1.setUser(user1);
        carService.add(car1);





        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + (user.getCar() == null? "NO" : user.getCar()));
            System.out.println();
        }

        User userWithCar = userService.getUserByModelAndSeries("Mercedes-Benz", 220);
        System.out.println(userWithCar);

        context.close();
    }
}
