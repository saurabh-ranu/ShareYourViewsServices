/**
 * @author Karthik.Rajamani
 *
 */

package com.omnie.shareyourviews.framework.handlers.exception;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.omnie.shareyourviews.domain.error.ErrorInfo;
import com.omnie.shareyourviews.framework.exception.ServiceException;



@ControllerAdvice
public class ExceptionHandler {

	// Spring Message Source
	public static MessageSource messageSource;
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	@Autowired
	public void setMessageSource(MessageSource _messageSource) {
		messageSource = _messageSource;
	}
	
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
	public Object handleException(HttpServletRequest request, ServiceException srvEx){
		 //To handle custom exceptions annotated with @ResponseStatus - re-throw for the framework handle it
		if (AnnotationUtils.findAnnotation(srvEx.getClass(), ResponseStatus.class) != null){
            throw srvEx;
		}
		
		return processServiceException(request, srvEx);
	}
	
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED, reason="Session Expired")
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler(HttpSessionRequiredException.class)
	public Object handleException(HttpServletRequest request, HttpSessionRequiredException srEx){
		
		return processException(request, srEx.getMessage());
	}
	
	
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal System Error Occured")
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
	public Object handleMissingResource(HttpServletRequest request, NoHandlerFoundException nhfEx) {
	    
	    return processException(request, "Internal System Error Occured");
	}
	
	@ResponseStatus(code=HttpStatus.UNAUTHORIZED, reason="Access Denied")
	@ResponseBody
	@org.springframework.web.bind.annotation.ExceptionHandler(AccessDeniedException.class)
	public Object handleMissingResource(HttpServletRequest request, AccessDeniedException adfEx) {
	    
	    return processException(request, "Access Denied");
	}
	
	public static String getMessage(String messageKey) throws IllegalArgumentException{
		try{
			return messageSource.getMessage(messageKey, new Object [] {}, LocaleContextHolder.getLocale());
		}catch(NoSuchMessageException e){
			//throw new IllegalArgumentException(e);
			logger.warn("Could not translate exception message, No message translation found !");//Handle gracefully when key not found
		}
		return messageKey;//Return the message key by default
	}
	
	public static Object processServiceException(HttpServletRequest request, ServiceException ex){
		
		Exception _ex = (Exception)ex.getCause();
		String exMsg = null;
		if(_ex instanceof InvocationTargetException){
			exMsg = _ex.getCause().getMessage();
		}else{
			exMsg = ex.getMessage();
		}
		
		return processException(request, exMsg);
	}

	public static Object processException(HttpServletRequest request, String exMsg){
		
		ErrorInfo errorInfo = new ErrorInfo(getMessage(exMsg));
		return errorInfo;

	}
}
