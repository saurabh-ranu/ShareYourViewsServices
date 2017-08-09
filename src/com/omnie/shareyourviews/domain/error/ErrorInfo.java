/**
 * @author Saurabh Srivastava
 *
 */
package com.omnie.shareyourviews.domain.error;

import static ch.lambdaj.Lambda.extract;
import static ch.lambdaj.Lambda.on;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ErrorInfo {

	private List<Error> errors = new LinkedList<Error>();
	
	public ErrorInfo(String msg){
		errors.add(new Error(msg));
	}
	
	public ErrorInfo(String code, String msg){
		errors.add(new Error(code, msg));
	}
	
	public List<String> getAllErrors(){
		return extract(errors, on(Error.class).getErrorMessage());
	}
	
	public String displayErrors(){
		return StringUtils.join(getAllErrors().toArray());
	}
	
	public void addError(String msg){
		addError(null, msg);
	}
	
	public void addError(String code, String msg){
		errors.add(new Error(code, msg));
	}
	
	public List<Error> getAll(){
		return errors;
	}
	
	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	protected class Error {
		
		private String errorCode;
		private String errorMessage;
		
		public Error(String errorMessage){
			this.errorMessage = errorMessage;
		}
		
		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public Error(String errorCode, String errorMessage){
			this(errorMessage);
			this.errorCode = errorCode;
		}
		
	}
}
