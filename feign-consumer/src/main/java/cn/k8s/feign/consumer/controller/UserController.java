package cn.k8s.feign.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.k8s.feign.consumer.client.UserClient;
import cn.k8s.feign.entity.UserEntity;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	UserClient userClient;

	@GetMapping
	List<UserEntity> getUsers() {
		return userClient.getUsers();
	}

	@GetMapping(path = "/{id}")
	UserEntity getUser(@PathVariable("id") Integer id) {
		return userClient.getUser(id);
	}

	@PostMapping
	public UserEntity addUser(@RequestBody UserEntity user) {
		return userClient.addUser(user);
	}
}
