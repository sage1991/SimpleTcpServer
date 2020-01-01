package com.harry.server.thread;

import java.util.LinkedList;

@SuppressWarnings("serial")
public class WorkerPool<T> extends LinkedList<T> {

	@Override
	public boolean add(T e) {
		synchronized(e) {
			return super.add(e);
		}
	}
	
}
