package com.hotelReservation.booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Arrays;
import java.util.Formatter;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

@Component
public class ExceptionHandler implements AsyncUncaughtExceptionHandler{

	@Override
	public void handleUncaughtException(Throwable ex, Method method, Object... args) {
		
		try {
			String fileName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+".txt";
		File file = new File(fileName);
		boolean result;  
		result = file.createNewFile();  //creates a new file  
		if(result)      // test if successfully created a new file  
		{  
		System.out.println("file created "+file.getCanonicalPath()); //returns the path string 
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Arrays.toString(args));
        bw.close();
		}  
		else  
		{  
		System.out.println("File already exist at location: "+file.getCanonicalPath());  
		} 
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("method name ::"+method.getName()+" ....."+ Arrays.toString(args)+".....error message ::"+ex.getMessage());
	}

}
