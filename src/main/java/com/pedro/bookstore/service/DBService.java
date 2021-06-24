package com.pedro.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.bookstore.domain.Categoria;
import com.pedro.bookstore.domain.Livro;
import com.pedro.bookstore.repositories.CategoriaRepository;
import com.pedro.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository catRepository;

	@Autowired
	private LivroRepository liRepository;
	
	public void instaciaBaseDados() {
		
		Categoria cat1 = new Categoria(null, "informatica", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Terra Média", "Medieval");
		Categoria cat3 = new Categoria(null, "Demon Slayer", "Mangá");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia Eletrica", "Luis V. Gerstner", "Lore, ipsum", cat1);
		Livro l3 = new Livro(null, "Harry Potter", "J. K. Rowling", "Lore, ipsum", cat2);
		Livro l4 = new Livro(null, "The War of the Works", "H.G. Wells", "Lore, ipsum", cat2);
		Livro l5 = new Livro(null, "Guerra dos Tronos", "G.G Martins", "Lore, ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.catRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.liRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
