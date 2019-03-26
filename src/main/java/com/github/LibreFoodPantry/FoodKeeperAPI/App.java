package com.github.LibreFoodPantry.FoodKeeperAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws Exception {
    	Database.storeFoodKeeperData();
    	
    	SpringApplication.run(App.class, args);
    }
}
