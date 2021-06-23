package com.pedro.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.bookstore.domain.Categoria;
import com.pedro.bookstore.domain.Livro;
import com.pedro.bookstore.repositories.CategoriaRepository;
import com.pedro.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepository;

	@Autowired
	private LivroRepository liRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"informatica", "Livros de TI");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));

		this.catRepository.saveAll(Arrays.asList(cat1));
		this.liRepository.saveAll(Arrays.asList(l1));

	}
}
