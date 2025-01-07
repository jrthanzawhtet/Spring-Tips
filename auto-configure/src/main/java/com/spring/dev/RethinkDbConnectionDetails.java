package com.spring.dev;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

public interface RethinkDbConnectionDetails extends ConnectionDetails{
	
	String host();
	int port();

}
