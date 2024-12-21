package org.cm.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.SystemFile;
import org.cm.service.BookExcelService;
import org.cm.repository.BookRepository;

@Controller("/")
public class HomeController {

	protected final BookRepository bookRepository;
	protected final BookExcelService bookExcelService;

	public HomeController(BookRepository bookRepository,
	                      BookExcelService bookExcelService) {
		this.bookRepository = bookRepository;
		this.bookExcelService = bookExcelService;
	}

	@Get("/excel")
	SystemFile excel() {
		return bookExcelService.excelFileFromBooks(bookRepository.findAll());
	}
}
