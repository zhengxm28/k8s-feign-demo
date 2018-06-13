package cn.k8s.feign.consumer.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.k8s.feign.consumer.client.fallback.FeignFallbackFactory;
import cn.k8s.feign.entity.UserEntity;

@FeignClient(name = "user-service", path = "/users", fallbackFactory = FeignFallbackFactory.class)
public interface UserClient {
	@GetMapping
	List<UserEntity> getUsers();

	@GetMapping(path = "/{id}")
	UserEntity getUser(@PathVariable("id") Integer id);

	@PostMapping
	public UserEntity addUser(@RequestBody UserEntity user);
}
