package blog.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import blog.handlers.ObservableReturnValueHandler;

@Configuration
public class WebConfig {

	@Autowired
	private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	
	@PostConstruct
	void init() {
		List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(requestMappingHandlerAdapter.getReturnValueHandlers());
		handlers.add(0, observableReturnValueHandler());
		requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
	}
	
	@Bean
	public HandlerMethodReturnValueHandler observableReturnValueHandler() {
		return new ObservableReturnValueHandler();
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}