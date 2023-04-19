package com.example.SpringKafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class SpringKafkaApplication {

	public static void main(String[] args) throws Exception, TimeoutException {
		try{
			SpringApplication.run(SpringKafkaApplication.class, args);
		}catch (Exception exception){
			System.out.println(exception.getMessage());
		}
	}
}
