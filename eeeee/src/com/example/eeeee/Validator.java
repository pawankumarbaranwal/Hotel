package com.example.eeeee;

public class Validator {

	public Boolean isInvalidFoodType(String foodType) {
		if (foodType.length()<5) {
			return true;
		}
		return false;
	}
	public Boolean isInvalidFoodPrice(Integer foodPrice) {
		if ((foodPrice<40)||(foodPrice>=1000)) {
			return true;
		}
		return false;
	}
	public Boolean isInvalidFoodName(String foodName) {
		if (foodName.length()<5) {
			return true;
		}
		return false;
	}
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
