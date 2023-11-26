package com.fabioqmarsiaj.admin.catalog.domain.category;

import com.fabioqmarsiaj.admin.catalog.domain.exceptions.DomainException;
import com.fabioqmarsiaj.admin.catalog.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

	@Test
	public void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
		final var expectedName = "Filmes";
		final var expectedDescription = "A categoria mais assistida";
		final var expectedIsActive = true;

		final var actualCategory =
				Category.newCategory(expectedName, expectedDescription, expectedIsActive);

		Assertions.assertNotNull(actualCategory);
		Assertions.assertNotNull(actualCategory.getId());
		Assertions.assertEquals(expectedName, actualCategory.getName());
		Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
		Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
		Assertions.assertNotNull(actualCategory.getCreatedAt());
		Assertions.assertNotNull(actualCategory.getUpdatedAt());
		Assertions.assertNull(actualCategory.getDeletedAt());
	}

	@Test
	public void givenAnInvalidNullName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
		final String expectedName = null;
		final var expectedErrorMessage = "'name' should not be null";
		final var expectedErrorCount = 1;
		final var expectedDescription = "A categoria mais assistida";
		final var expectedIsActive = true;

		final var actualCategory =
				Category.newCategory(expectedName, expectedDescription, expectedIsActive);

		final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

		Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
		Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
	}

	@Test
	public void givenAnInvalidEmptyName_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
		final String expectedName = "   ";
		final var expectedErrorMessage = "'name' should not be empty";
		final var expectedErrorCount = 1;
		final var expectedDescription = "A categoria mais assistida";
		final var expectedIsActive = true;

		final var actualCategory =
				Category.newCategory(expectedName, expectedDescription, expectedIsActive);

		final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

		Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
		Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
	}

	@Test
	public void givenAnInvalidNameLengthLessThan3Name_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
		final String expectedName = "Fi ";
		final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
		final var expectedErrorCount = 1;
		final var expectedDescription = "A categoria mais assistida";
		final var expectedIsActive = true;

		final var actualCategory =
				Category.newCategory(expectedName, expectedDescription, expectedIsActive);

		final var actualException =
				Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

		Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
		Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
	}

	@Test
	public void givenAnInvalidNameLengthMoreThan255_whenCallNewCategoryAndValidate_thenShouldReceiveError() {
		final String expectedName = """
					No entanto, não podemos esquecer que o julgamento imparcial das eventualidades promove a alavancagem dos níveis de motivação departamental. 
					O incentivo ao avanço tecnológico, assim como a crescente influência da mídia prepara-nos para enfrentar situações atípicas decorrentes das novas proposições. 
					Não obstante, o desenvolvimento contínuo de distintas formas de atuação ainda não demonstrou convincentemente que vai participar na mudança das condições financeiras
					e administrativas exigidas. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que a expansão dos mercados mundiais causa impacto indireto 
					na reavaliação das direções preferenciais no sentido do progresso.
				""";
		final var expectedErrorMessage = "'name' must be between 3 and 255 characters";
		final var expectedErrorCount = 1;
		final var expectedDescription = "A categoria mais assistida";
		final var expectedIsActive = true;

		final var actualCategory =
				Category.newCategory(expectedName, expectedDescription, expectedIsActive);

		final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate(new ThrowsValidationHandler()));

		Assertions.assertEquals(expectedErrorMessage, actualException.getErrors().get(0).message());
		Assertions.assertEquals(expectedErrorCount, actualException.getErrors().size());
	}

	@Test
	public void givenAValidEmptyDescription_whenCallNewCategoryAndValidate_thenShouldNotReceiveError() {
		final var expectedName = "Filmes";
		final var expectedDescription = "A categoria mais assistida";
		final var expectedIsActive = true;

		final var actualCategory =
				Category.newCategory(expectedName, expectedDescription, expectedIsActive);

		Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));
		Assertions.assertNotNull(actualCategory);
		Assertions.assertNotNull(actualCategory.getId());
		Assertions.assertEquals(expectedName, actualCategory.getName());
		Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
		Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
		Assertions.assertNotNull(actualCategory.getCreatedAt());
		Assertions.assertNotNull(actualCategory.getUpdatedAt());
		Assertions.assertNull(actualCategory.getDeletedAt());
	}

	@Test
	public void givenAValidFalseIsActive_whenCallNewCategoryAndValidate_thenShouldNotReceiveError() {
		final var expectedName = "Filmes";
		final var expectedDescription = "A categoria mais assistida";
		final var expectedIsActive = false;

		final var actualCategory =
				Category.newCategory(expectedName, expectedDescription, expectedIsActive);

		Assertions.assertDoesNotThrow(() -> actualCategory.validate(new ThrowsValidationHandler()));

		Assertions.assertNotNull(actualCategory);
		Assertions.assertNotNull(actualCategory.getId());
		Assertions.assertEquals(expectedName, actualCategory.getName());
		Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
		Assertions.assertEquals(expectedIsActive, actualCategory.isActive());
		Assertions.assertNotNull(actualCategory.getCreatedAt());
		Assertions.assertNotNull(actualCategory.getUpdatedAt());
		Assertions.assertNotNull(actualCategory.getDeletedAt());
	}
}
