package com.harry.server.http;

public class RunnableHandler implements Runnable, HttpHandler {

	@Override
	public void run() {
		handle();
	}

	
}
