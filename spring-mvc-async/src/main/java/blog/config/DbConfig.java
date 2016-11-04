package blog.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.leosilvadev.groovypgasync.PgDb;

@Configuration
public class DbConfig {
	
	@Bean
	public PgDb pgDb() {
		Map<String, Object> config = new HashMap<>();
		config.put("hostname", "localhost");
		config.put("port", 5432);
		config.put("database", "jvm-spring-mvc-async");
		config.put("username", "dev");
		config.put("password", "dev");
		config.put("poolSize", 20);
		return new PgDb(config);
	}

}
