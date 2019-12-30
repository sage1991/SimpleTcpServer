package com.harry.server;

import java.io.IOException;

import com.harry.server.config.ServerProperties;

public class SimpleServerApp {
	
	public static ServerProperties serverProperties = null;
	
	public static void main(String[] args) {
		
		initConfig();
		
		
		
	}
	
	
	private static void initConfig() {
		
		serverProperties = new ServerProperties();
		
		try {
			serverProperties.load();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	
}
