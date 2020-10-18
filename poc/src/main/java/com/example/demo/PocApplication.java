package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.controller.POCFilter;


@SpringBootApplication
public class PocApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<POCFilter> loggingFilter() {
		FilterRegistrationBean<POCFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new POCFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		registrationBean.setAsyncSupported(true);

		return registrationBean;
	}

	/*@Bean
	public FilterRegistrationBean<MyFilter> myfilter() {
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(2);
		registrationBean.setAsyncSupported(true);
		return registrationBean;
	}*/

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
	}

	/*@Bean 
	 public RabbitConnectionFactoryBean rabbitConnectionFactory() {
		 //ConnectionFactory connectionFactory=new CachingConnectionFactory("localhost", 5672);
		 //return connectionFactory;	
		 RabbitConnectionFactoryBean bean=new RabbitConnectionFactoryBean();
		 bean.setUsername("guest");
		 bean.setPassword("guest");
		 bean.setPort(5672);
		 bean.setHost("localhost");
		 return bean;
	 }

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames("remotingQueue");
		container.setMessageListener(listenerAdapter);
		MessageProperties prop=new MessageProperties();
	
		return container;
		
	}

	@Bean
	public MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}

	@Bean
	public RabbitTemplate amqpTemplate(ConnectionFactory factory) {
		RabbitTemplate template = new RabbitTemplate(factory);
		//Below to are for local verification . It is better to have this in respective classes . 
		template.setRoutingKey("remoting.binding");
		template.setExchange("remoting.exchange");
		return template;
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("remoting.exchange", true, false);
	}

	@Bean
	public Queue rabbitQueue() {
		return new Queue("remotingQueue", true);
	}

	@Bean
	public Binding rabbitMQExchangeBinding(DirectExchange directExchange, Queue rabbitQueue) {
		return BindingBuilder.bind(rabbitQueue).to(directExchange).with("remoting.binding");
	}*/
}
