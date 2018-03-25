package vast.selfmanagementweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("vast.selfmanagementweb.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class SelfManagementWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfManagementWebApplication.class, args);
	}
}
