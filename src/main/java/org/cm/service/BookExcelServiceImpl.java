package org.cm.service;

import builders.dsl.spreadsheet.builder.poi.PoiSpreadsheetBuilder;
import io.micronaut.http.server.types.files.SystemFile;
import jakarta.inject.Singleton;
import org.cm.dto.Book;
import org.cm.config.BookExcelStylesheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Singleton
public class BookExcelServiceImpl implements BookExcelService {

	private static final Logger LOG = LoggerFactory.getLogger(BookExcelServiceImpl.class);

	@Override
	public SystemFile excelFileFromBooks(List<Book> bookList) {
		try {
			File file = File.createTempFile(HEADER_EXCEL_FILE_PREFIX, HEADER_EXCEL_FILE_SUFIX);
			PoiSpreadsheetBuilder.create(file).build(w -> {
				w.apply(BookExcelStylesheet.class);
				w.sheet(SHEET_NAME, s -> {
					s.row(r -> Stream.of(HEADER_ISBN, HEADER_NAME)
							.forEach(header -> r.cell(cd -> {
										cd.value(header);
										cd.style(BookExcelStylesheet.STYLE_HEADER);
									})
							));
					bookList.stream()
							.forEach(book -> s.row(r -> {
								r.cell(book.getIsbn());
								r.cell(book.getName());
							}));
				});
			});
			return new SystemFile(file).attach("Book" + LocalDateTime.now() + HEADER_EXCEL_FILE_SUFIX);
		} catch (IOException e) {
			if (LOG.isErrorEnabled()) {
				LOG.error("File not found exception raised when generating excel file");
			}
		}
		return null;
	}
}
