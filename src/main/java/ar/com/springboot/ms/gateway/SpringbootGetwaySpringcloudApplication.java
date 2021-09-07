package ar.com.springboot.ms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient // Para que sea Cliente de Eureka y pueda registrarse en el server
@SpringBootApplication
public class SpringbootGetwaySpringcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGetwaySpringcloudApplication.class, args);
	}

}
