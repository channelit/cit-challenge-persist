package biz.cit.challenge.persist;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
	SYSTEM_OWNER("System Owner"), SYSTEM_ADMIN("System Admin"), SUPERVISOR_AGENT("Supervisory Special Agent"),
	SPECIAL_AGENT("Special Agent");

	private String displayName;

	UserRole(String displayName) {
		this.displayName = displayName;
	}

	@JsonValue
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
