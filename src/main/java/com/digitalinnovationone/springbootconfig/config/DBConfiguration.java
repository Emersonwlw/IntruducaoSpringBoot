package com.digitalinnovationone.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

    private String driveClassName;
    private String url;
    private String username;
    private String password;

    public String getDriveClassName() {
        return driveClassName;
    }

    public void setDriveClassName(String driveClassName) {
        this.driveClassName = driveClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Profile("dev")
    @Bean
    public String testeDatabaseConnection(){
        System.out.println("DB connection for DEV - H2");
        System.out.println(driveClassName);
        System.out.println(url);
        return "DB connection to H2_TEST - Test instance";
    }

    @Profile("prod")
    @Bean
    public String productionDatabaseConnection(){
        System.out.println("DB connection for Production - MYSQL");
        System.out.println(driveClassName);
        System.out.println(url);
        return "DB connection to MYSQL_TEST - Production instance";
    }

}
