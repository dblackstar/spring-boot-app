package com.workshop.rbs;

import com.workshop.rbs.dao.ProductRepository;
import com.workshop.rbs.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class RbsApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;


	public static void main(String[] args) {

		SpringApplication.run(RbsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null, "Mac book pro", 300_000, 52));
		productRepository.save(new Product(null, "Samsung galaxy note 5", 120_000, 100));
		productRepository.save(new Product(null, "Microphone mic32", 10_000, 3));
		productRepository.save(new Product(null, "Microphone S300", 11_000, 4));
		productRepository.save(new Product(null, "Microphone a32", 4_000, 3));
		productRepository.save(new Product(null, "Microphone A2", 1_000, 3));

		Page<Product> products = productRepository.findByNameContains("book", PageRequest.of(0, 2));
		System.out.println(products.getSize());
		System.out.println(products.getTotalElements());
		System.out.println(products.getTotalPages());

		products.getContent().forEach(p->{
			System.out.println(p.toString());
		});


		System.out.println("************* CUSTOME QUERY **************");
		Page<Product>  products1 = productRepository.findThis("%phone%", 4_000, PageRequest.of(0, 10));
		System.out.println(products1.getSize());
		System.out.println(products1.getTotalElements());
		System.out.println(products1.getTotalPages());

		products1.getContent().forEach(p->{
			System.out.println(p.toString());
		});
	}
}
