package fintech.data.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class RepositoryConfigurer {
    @Bean
    public Connection repositoryConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5437/fintech","admin","fintech2024");

    }
}
