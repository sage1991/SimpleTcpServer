package com.harry.server.thread;


public class Worker extends Thread {
	
	
	private Task task = null;
	private WorkerPool<Worker> workerPool = null;
	
	
	public Worker(WorkerPool<Worker> workerPool) {
		this.workerPool = workerPool;
	}
	
	
	public void setTask(Task task) {
		this.task = task;
	}

	
	
	@Override
	public void run() {
		if(this.task != null) {
			this.task.execute();
		}
		releaseResource();
	}
	
	
	public void releaseResource() {
		this.task = null;
		this.workerPool.add(this);
	}
	
}
