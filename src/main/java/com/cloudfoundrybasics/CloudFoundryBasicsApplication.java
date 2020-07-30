package com.cloudfoundrybasics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;


@SpringBootApplication
public class CloudFoundryBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFoundryBasicsApplication.class, args);
	}

}

@RestController
@AllArgsConstructor
class HelloController {

	private UsersRepository usersRepository;

	@GetMapping
	public String hello() throws UnknownHostException {
		return "Hello. My address: " + InetAddress.getLocalHost().toString();
	}

	@GetMapping("users")
	public List<Users> getUsers() {
		return usersRepository.findAll();
	}

	@GetMapping("users/{name}")
	public Users getUserByName(@PathVariable String name) {
		return usersRepository.findByName(name);
	}
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
class Users {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
}

@Repository
interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByName(String name);
}
