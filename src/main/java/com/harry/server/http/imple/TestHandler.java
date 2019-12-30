package com.harry.server.http.imple;

import com.harry.server.http.HttpHandler;

public class TestHandler implements Runnable, HttpHandler {

	private int acceptMethod = 0;
	
	
	
	@Override
	public void handle() {
		
		
	}
	

	@Override
	public void run() {
		handle();
	}
	
}
