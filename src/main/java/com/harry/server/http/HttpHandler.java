package com.harry.server.http;

public interface HttpHandler {
	
	default void handle() {};
	default void get() {};
	default void post() {};
	default void delete() {};
	default void put() {};
	
	default boolean isAllowed(int accept, int httpMethod) {
		return (accept & httpMethod) == httpMethod;
	}
	
}
