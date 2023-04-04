package com.example.Ejercicios_10_11_12;

import com.example.Ejercicios_10_11_12.entities.Laptop;
import com.example.Ejercicios_10_11_12.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicios101112Application {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(Ejercicios101112Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Hp", "Notebook", "10jvJN4km", "500gb");
		Laptop laptop2 = new Laptop(null, "Hp", "Notebook", "10jvJN4km", "1TB");

		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);
	}

}
