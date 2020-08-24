
package mz.co.scntech.messenger.database;

import java.util.HashMap;
import java.util.Map;

import mz.co.scntech.messenger.model.Message;
import mz.co.scntech.messenger.model.Profile;

/**
 *
 * @author Sidónio Goenha on Aug 20, 2020
 *
 */
public class DatabaseClass {
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}
