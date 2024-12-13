package tin.tinproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class TinProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TinProjectApplication.class, args);
//
//		UserService userService = context.getBean(UserService.class);
//
//		userService.createUser("John Doe1321331", "john@example.com21223332");
//		userService.createUser("Jane Doe13332323232322321", "jane@example.com22323232223232323233");
//
//		userService.getAllUsers().forEach(user -> {
//			System.out.println("ID: " + user.getId());
//			System.out.println("Name: " + user.getName());
//			System.out.println("Email: " + user.getEmail());
//			System.out.println("Created At: " + user.getCreatedAt());
//			System.out.println("----------------------------");
//		});
	}
}
