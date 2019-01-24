package isep.web.moviesep.service;

import java.sql.Timestamp;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.moviesep.dao.repositories.UserRepository;
import isep.web.moviesep.jpa.entities.User;
import isep.web.moviesep.model.UserWO;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);

	@Override
	public List<UserWO> findAllUsers() {
		List<UserWO> users = new LinkedList<UserWO>();

		for (User user : userRepository.findAll()) {
			users.add(new UserWO(user));
			log.debug("Adding " + user);
		}

		return users;
	}

	@Override
	public UserWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		User user = userRepository.findById(id).get();

		if (user != null) {
			return new UserWO(user);
		}
		return null;
	}

	@Override
	public void saveUser(UserWO userWO) {
		User user = new User();
		user.setFirstName(userWO.getFirstName());
		user.setLastName(userWO.getLastName());
		user.setMail(userWO.getMail());
		user.setPassword(userWO.getPassword());
		user.setUsername(userWO.getUsername());
		user.setFilms(userWO.getFilms());
		userRepository.save(user);
	}

	@Override
	public void updateUser(UserWO userWO) {
		User user2update = userRepository.findById(userWO.getUserId()).get();
		user2update.setFirstName(userWO.getFirstName());
		user2update.setLastName(userWO.getLastName());
		user2update.setMail(userWO.getMail());
		user2update.setPassword(userWO.getPassword());
		user2update.setUsername(userWO.getUsername());
		user2update.setFilms(userWO.getFilms());
		userRepository.save(user2update);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

}
