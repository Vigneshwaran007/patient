package com.ideas2it.patient_service.entity;

import java.util.UUID;

/**
 * UserEntity which represent result for the User data.
 * 
 * @author Vigneshwaran N
 */
public class UserEntity {
	String roleName;
	String userName;
	UUID roleId;

	public String getRoleName() {
		return roleName;
	}

	public String getUserName() {
		return userName;
	}

	public UUID getRoleId() {
		return roleId;
	}

	public UserEntity() {

	}

	private UserEntity(UserEntityBuilder builder) {
		this.roleId = builder.roleId;
		this.roleName = builder.roleName;
		this.userName = builder.userName;
	}

	public static class UserEntityBuilder {
		String roleName;
		String userName;
		UUID roleId;

		public UserEntityBuilder roleName(String roleName) {
			this.roleName = roleName;
			return this;
		}

		public UserEntityBuilder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public UserEntityBuilder roleId(UUID roleId) {
			this.roleId = roleId;
			return this;
		}

		public UserEntity build() {
			UserEntity entity = new UserEntity(this);
			return entity;
		}
	}
}
