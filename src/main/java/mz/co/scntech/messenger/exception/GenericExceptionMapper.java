
package mz.co.scntech.messenger.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import mz.co.scntech.messenger.model.ErrorMessage;

/**
 *
 * @author Sidónio Goenha on Aug 24, 2020
 *
 */
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 500, "http://javabrains.koushik.org");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
					   .entity(errorMessage)
					   .build();
	}

	
}
