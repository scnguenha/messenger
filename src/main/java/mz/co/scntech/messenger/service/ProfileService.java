
package mz.co.scntech.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mz.co.scntech.messenger.database.DatabaseClass;
import mz.co.scntech.messenger.model.Profile;

/**
 *
 * @author Sidónio Goenha on Aug 21, 2020
 *
 */
public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("sidy", new Profile(1, "sidynguenha", "Sidy", "Nguenha"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}

		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String name) {
		return profiles.remove(name);
	}
}
