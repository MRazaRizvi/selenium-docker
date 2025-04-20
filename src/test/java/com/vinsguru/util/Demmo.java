package com.vinsguru.util;

import com.github.dockerjava.api.model.Network;

public class Demmo {

    public static void main(String[] args) {

        System.setProperty("browser", "firefox");

        config.initialize();

        System.out.println(
                config.get("selenium.grid.hubHost")
        );
    }
}
