package com.harry.server.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
	
	public static void close(InputStream in) {
		try {
			if(in != null) {
				in.close();
				in = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void close(OutputStream out) {
		try {
			if(out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
