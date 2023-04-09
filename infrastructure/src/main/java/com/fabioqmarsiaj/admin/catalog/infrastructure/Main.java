package com.fabioqmarsiaj.admin.catalog.infrastructure;

import com.fabioqmarsiaj.admin.catalog.application.UseCase;

public class Main {

    public static void main(String[] args) {
        System.out.println(new UseCase().execute());
    }
}
