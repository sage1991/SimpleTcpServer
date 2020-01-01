package com.harry.server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SimpleTcpServer {
	
	private ServerSocket serverSocket = null;
	private ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	
	public void listen(int port) {
		
		try {
			
			serverSocket = new ServerSocket(port);
			
			System.out.println("server on");
			
			while(true) {
				
				System.out.println("ready connection");
				
				Socket socket = serverSocket.accept();
				
				Thread thread = new Thread(() -> {
					
					try {
						socket.setKeepAlive(true);
						
						
						System.out.println("accept connection");
						
						BufferedInputStream buffIn = new BufferedInputStream(socket.getInputStream());
						
						BufferedOutputStream outStream = new BufferedOutputStream(socket.getOutputStream());
						
						int count = -1;
						StringBuilder stringBuilder = new StringBuilder();
						while(true) {
							byte[] data = new byte[512];
							count = buffIn.read(data);
							if(count > 0) {
								stringBuilder.append(new String(data).trim());
							}
							if(data.length > count) {
								break;
							}
						}
						
						System.out.println("=====================================");
						System.out.println(stringBuilder.toString());
						System.out.println("=====================================");
						
						System.out.println("ready to response");
						
						String body = "<!DOCTYPE html/>\r\n<h3>hello world!</h3>\r\n\r\n";
						
						StringBuilder sb = new StringBuilder();
						sb.append("HTTP/1.1 200 OK\r\n");
						sb.append("Date : " + new Date().toString() + "\r\n");
						sb.append("Server : harry's SimpleTcpServer\r\n");
						sb.append("Content-type : text/html;charset=utf-8\r\n");
						sb.append("Access-Control-Allow-Origin : *\r\n");
						sb.append("Access-Control-Allow-Methods: GET,POST,PUT,DELETE\r\n");
						sb.append("Content-length : " +  body.getBytes().length + "\r\n\r\n");
						outStream.write(sb.toString().getBytes());
						outStream.write(body.getBytes(), 0, body.length());
						outStream.flush();
						
						System.out.println("response successfuly sended");
						buffIn.close();
						outStream.close();
						System.out.println("close connection");
						
					} catch (SocketException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
				executor.execute(thread);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
