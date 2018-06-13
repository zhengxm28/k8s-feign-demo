package cn.k8s.feign.provider;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.k8s.feign.entity.UserEntity;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping(path = "/users")
public class Application {
	@Value("${server.port}")
	private int port;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public List<UserEntity> getUsers() {
		UserEntity u1 = new UserEntity(1, "zhangshan", 30, "man", port);
		UserEntity u2 = new UserEntity(2, "李四", 28, "feman", port);
		return Arrays.asList(u1, u2);
	}

	@GetMapping(value = "/{id}")
	public UserEntity getUser() {
		return new UserEntity(1, "zhangshan", 20, "man", port);
	}

	@PostMapping
	public UserEntity addUser(@RequestBody UserEntity user) {
		return user;
	}
}
