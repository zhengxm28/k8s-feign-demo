package cn.k8s.feign.consumer.client.fallback;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.k8s.feign.consumer.client.UserClient;
import cn.k8s.feign.consumer.client.exception.RemoteServiceException;
import cn.k8s.feign.entity.UserEntity;
import feign.hystrix.FallbackFactory;

@Component
public class FeignFallbackFactory implements FallbackFactory<UserClient> {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeignFallbackFactory.class);

	@Override
	public UserClient create(Throwable cause) {
		FeignFallbackFactory.LOGGER.info("fallback; reason was: {}", cause.getMessage());
		return new UserClient() {
			@Override
			public List<UserEntity> getUsers() {
				throw new RemoteServiceException(cause);
			}

			@Override
			public UserEntity getUser(Integer id) {
				throw new RemoteServiceException(cause);
			}

			@Override
			public UserEntity addUser(UserEntity user) {
				throw new RemoteServiceException(cause);
			}
		};
	}

}
