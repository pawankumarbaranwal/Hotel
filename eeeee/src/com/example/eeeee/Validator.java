package com.example.eeeee;

public class Validator {

	public Boolean isInvalidUserId(String userId) {
		if (userId.length()<5) {
			return true;
		}
		return false;
	}
	public Boolean isInvalidUserName(String userName) {
		if (userName.length()<5) {
			return true;
		}
		return false;
	}
	public Boolean isInvalidUserAge(Integer age) {
		if ((age<15)||(age==null)||(age>=120)) {
			return true;
		}
		return false;
	}
	public Boolean isInvalidUserPassword(String password) {
		if (password.length()<5) {
			return true;
		}
		return false;
	}

}
