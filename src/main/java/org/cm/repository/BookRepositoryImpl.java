package org.cm.repository;

import jakarta.inject.Singleton;
import org.cm.dto.Book;

import java.util.Arrays;
import java.util.List;

@Singleton
public class BookRepositoryImpl implements BookRepository {
	@Override
	public List<Book> findAll() {
		Book buildingMicroservices = new Book("1491950358", "Building Microservices");
		Book releaseIt = new Book("1680502395", "Release It!");
		Book cidelivery = new Book("0321601912", "Continuous Delivery:");
		return Arrays.asList(buildingMicroservices, releaseIt, cidelivery);

	}
}
