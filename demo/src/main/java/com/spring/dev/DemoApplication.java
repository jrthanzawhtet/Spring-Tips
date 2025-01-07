package com.spring.dev;

import java.sql.Connection;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rethinkdb.RethinkDB;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*
	 * @Bean ApplicationRunner rethinkDbClient(RethinkDB rethinkDB,Connection
	 * connection) { return arg -> { var db = "test"; var table = "tv-shows";
	 * 
	 * try { rethinkDB.dbDrop(db).run(connection); } catch (Exception e) { // TODO:
	 * handle exception } } }
	 */
}
