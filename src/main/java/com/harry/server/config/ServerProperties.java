package com.harry.server.config;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.harry.server.SimpleServerApp;
import com.harry.server.util.IOUtil;

@SuppressWarnings("serial")
public class ServerProperties extends Properties {

	public synchronized void load() throws IOException {
		
		InputStream inStream = SimpleServerApp.class.getClassLoader().getResourceAsStream("server.properties");
		BufferedInputStream buffInStream = new BufferedInputStream(inStream);
		load(buffInStream);
		
		IOUtil.close(inStream);
		IOUtil.close(buffInStream);
	}

}
