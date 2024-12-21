package org.cm.controller;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import org.cm.transformer.StringTransformer;

@Controller("/transformer")
public class StringTransformerController {

	private final StringTransformer transformer;

	public StringTransformerController(StringTransformer transformer) {
		this.transformer = transformer;
	}

	@Produces(MediaType.TEXT_PLAIN)
	@Get("/capitalize{?q}")
	String capitalize(@Nullable @QueryValue String q) {
		String className = "org.cm.transformer.StringCapitalizer";
		String methodName = "capitalize";
		return transformer.transform(q, className, methodName);
	}

	@Produces(MediaType.TEXT_PLAIN)
	@Get("/reverse{?q}")
	String reverse(@Nullable @QueryValue String q) {
		String className = "org.cm.transformer.StringReverser";
		String methodName = "reverse";
		return transformer.transform(q, className, methodName);
	}
}
