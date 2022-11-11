package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.bean.Books;

@Aspect
@Component
public class BookServiceAOP {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Before(value = "execution(* com.example.service.BookService.addBook(..)) and args (book)")
	public void beforeAdviceAddingBookCheckParam(JoinPoint joinPoint, Books book) 
	{
		LOGGER.info("Before method: " + joinPoint.getSignature());
		LOGGER.info("Adding book with title: {}", book.getTitle());
	}
	
	//naming methods/pointcut differs slightly btw @Before or @After and @Around
	
	@Around(value = "execution(* com.example.service.BookService.*(..))")
	public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable
	//has to be ProceedingJoinPoint for @Around and have to account for Throwable exceptions
	//also in order to have access to JoinPoint.proceed() method to continue through execution
	{
		LOGGER.info("AROUND LOGGING - METHOD: {} ABOUT TO EXECUTE", joinPoint.getSignature());
		
		Object value = null;
		value = joinPoint.proceed();
		
		//for around you have to create an object in order to retrieve information ie parameters/results/etc
		//if you leave it as a void method and don't code for it to "finish" then will pause execution of program
		//as it hangs around waiting for @Around AOP method to finish
		
		return value; //now program can continue executing
	}

}
