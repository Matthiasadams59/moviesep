package isep.web.moviesep.service;

import java.util.List;

import isep.web.moviesep.model.UserWO;

public interface UserService
{
	UserWO findById(int id);

	void saveUser(UserWO userWO);

	void updateUser(UserWO userWO);

	void deleteUserById(int id);

	List<UserWO> findAllUsers();

}
