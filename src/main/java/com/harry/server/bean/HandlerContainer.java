package com.harry.server.bean;


import com.harry.server.http.HttpHandler;

public interface HandlerContainer {
	public HttpHandler getHandler(String httpQuery);
}
