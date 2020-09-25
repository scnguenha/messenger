
package mz.co.scntech.messenger.dao;
/**
 *
 * @author Sidónio Goenha on Sep 24, 2020
 *
 */

import mz.co.scntech.messenger.model.Message;
import mz.co.scntech.messenger.persistence.Data;

public class MessageDAO extends Data {

	public static Message delete(long id) {

		return delete(findById(Message.class, id));
	}

}
