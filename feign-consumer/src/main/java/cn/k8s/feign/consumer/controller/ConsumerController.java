package cn.k8s.feign.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.k8s.feign.consumer.client.UserClient;
import cn.k8s.feign.entity.UserEntity;

@RestController
public class ConsumerController {
	@Autowired
	private LoadBalancerClient loadBalancer;
	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	UserClient userClient;

	/**
	 * 从所有服务中选择一个服务
	 */
	@GetMapping("/discover")
	public Object discover() {
		return loadBalancer.choose("user-service").getUri().toString();
	}

	/**
	 * 获取所有服务
	 */
	@GetMapping("/services")
	public Object services() {
		return discoveryClient.getInstances("user-service");
	}

	@GetMapping("/users")
	List<UserEntity> getUsers() {
		return userClient.getUsers();
	}

	@GetMapping(path = "/users/{id}")
	UserEntity getUser(@PathVariable("id") Integer id) {
		return userClient.getUser(id);
	}

	@PostMapping("/users")
	public UserEntity addUser(@RequestBody UserEntity user) {
		return userClient.addUser(user);
	}
}
