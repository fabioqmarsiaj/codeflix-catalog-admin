package com.fabioqmarsiaj.admin.catalog.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void testnewCategory(){
        Assertions.assertNotNull(new Category());
    }
}
