/**
 * @author Karthik.Rajamani
 *
 */
package com.omnie.shareyourviews.framework.handlers.exception;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.omnie.shareyourviews.framework.exception.ServiceException;

public class RESTWSTRExceptionHandler implements ResponseErrorHandler {

	private static final Logger logger = LoggerFactory.getLogger(RESTWSTRExceptionHandler.class);
	
	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		logger.error("REST WS Response Error : errorCode {{}}, errorMessage {{}}", response.getStatusCode(), response.getStatusText());
		throw new ServiceException(response.getStatusText());
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		HttpStatus.Series statusCodes = response.getStatusCode().series();
		return HttpStatus.Series.CLIENT_ERROR.equals(statusCodes) || HttpStatus.Series.SERVER_ERROR.equals(statusCodes);
	}

}
