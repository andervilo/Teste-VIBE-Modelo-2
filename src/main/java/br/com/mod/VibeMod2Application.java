package br.com.mod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
public class VibeMod2Application {

	public static void main(String[] args) {
		SpringApplication.run(VibeMod2Application.class, args);
	}

}

