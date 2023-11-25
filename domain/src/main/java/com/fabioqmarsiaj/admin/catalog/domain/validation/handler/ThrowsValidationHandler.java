package com.fabioqmarsiaj.admin.catalog.domain.validation.handler;

import com.fabioqmarsiaj.admin.catalog.domain.exceptions.DomainException;
import com.fabioqmarsiaj.admin.catalog.domain.validation.Error;
import com.fabioqmarsiaj.admin.catalog.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
	@Override
	public ValidationHandler append(final Error anError) {
		throw DomainException.with(List.of(anError));
	}

	@Override
	public ValidationHandler append(final ValidationHandler aHandler) {
		throw DomainException.with(aHandler.getErrors());
	}

	@Override
	public ValidationHandler validate(Validation aValidation) {
		try {
			aValidation.validate();
		} catch (final Exception ex) {
			throw DomainException.with(List.of(new Error(ex.getMessage())));
		}
		return this;
	}

	@Override
	public List<Error> getErrors() {
		return null;
	}
}
