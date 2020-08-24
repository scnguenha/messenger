
package mz.co.scntech.messenger.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import mz.co.scntech.messenger.model.ErrorMessage;

/**
 *
 * @author Sidónio Goenha on Aug 24, 2020
 *
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException e) {
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 404, "http://javabrains.koushik.org");
		return Response.status(Status.NOT_FOUND)
					   .entity(errorMessage)
					   .build();
	}

}
