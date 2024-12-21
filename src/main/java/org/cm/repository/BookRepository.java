package org.cm.repository;

import org.cm.dto.Book;

import java.util.List;

public interface BookRepository {

	List<Book> findAll();
}
