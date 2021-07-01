package com.postgresql.connect_postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class ConnectPostgresqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConnectPostgresqlApplication.class, args);
    }

}
