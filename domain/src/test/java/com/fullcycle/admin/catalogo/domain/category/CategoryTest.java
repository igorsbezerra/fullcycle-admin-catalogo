package com.fullcycle.admin.catalogo.domain.category;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void givenAValidParams_whenCallNewCategory_thenInstantiateACategory() {
        final var expectedName = "Filmes";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedActive);

        Assertions.assertNotNull(actualCategory);
        Assertions.assertNotNull(actualCategory.getId());
        Assertions.assertEquals(expectedName, actualCategory.getName());
        Assertions.assertEquals(expectedDescription, actualCategory.getDescription());
        Assertions.assertEquals(expectedActive, actualCategory.isActive());
        Assertions.assertNotNull(actualCategory.getCreatedAt());
        Assertions.assertNotNull(actualCategory.getUpdatedAt());
        Assertions.assertNull(actualCategory.getDeletedAt());
    }

    @Test
    void givenAnInvalidNullName_whenCallNewCategoryAnValidate_thenShouldReceivedError() {
        final String expectedName = null;
        final var expectedErrorCount = 1;
        final var expectedErrorMessage = "'name' should not be null";
        final var expectedDescription = "A categoria mais assistida";
        final var expectedActive = true;

        final var actualCategory =
                Category.newCategory(expectedName, expectedDescription, expectedActive);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> actualCategory.validate());
        Assertions.assertEquals(expectedErrorCount , actualException.getErrors().size());
        Assertions.assertEquals(expectedErrorMessage , actualException.getErrors().get(0).getMessage());
    }
}
