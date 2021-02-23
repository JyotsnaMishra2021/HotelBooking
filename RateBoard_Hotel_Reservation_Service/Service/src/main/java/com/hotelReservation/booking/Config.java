package com.hotelReservation.booking;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@Configuration
public class Config extends AsyncConfigurerSupport{

	@Autowired
	ExceptionHandler exceptionHandler;
	
	@Override
	public Executor getAsyncExecutor() {
		// TODO Auto-generated method stub
		return super.getAsyncExecutor();
	}
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return exceptionHandler;
	}
}
