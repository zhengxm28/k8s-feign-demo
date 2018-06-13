package cn.k8s.feign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class UserEntity {
	private int id;
	private String name;
	private int age;
	private String sex;
	private int port;
}
