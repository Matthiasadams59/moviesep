package isep.web.moviesep.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import isep.web.moviesep.model.UserWO;
import isep.web.moviesep.service.UserService;

@RestController
public class UserRestController
{

	@Autowired
	UserService							userService;

	private static final Log	log	= LogFactory.getLog(UserRestController.class);

	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<UserWO>> listAllUsers()
	{
		List<UserWO> users = userService.findAllUsers();
		if (users.isEmpty())
		{
			return new ResponseEntity<List<UserWO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserWO>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<UserWO> login(@RequestBody UserWO userWO)
	{
		log.error(String.format("Searching User %s ", userWO.getUsername()));
		List<UserWO> users = userService.findAllUsers();
		for (UserWO user : users) {
			if (user.getUsername().equals(userWO.getUsername()) && user.getPassword().equals(userWO.getPassword())) {
				System.out.println("User found!");
				return new ResponseEntity<UserWO>(user, HttpStatus.OK);
			}
		}
		return new ResponseEntity<UserWO>(HttpStatus.UNAUTHORIZED);
		
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserWO> getUser(@PathVariable("id") int id)
	{
		System.out.println("Fetching User with id " + id);
		UserWO staffWO = userService.findById(id);
		if (staffWO == null)
		{
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<UserWO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserWO>(staffWO, HttpStatus.OK);
	}

	// -------------------Create a User----------------------------------

	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody UserWO userWO, UriComponentsBuilder ucBuilder)
	{
		System.out.println("Creating User " + userWO.getUsername());

		userService.saveUser(userWO);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(userWO.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/userUpdate/", method = RequestMethod.POST)
	public ResponseEntity<UserWO> updateUser(@RequestBody UserWO userWO, UriComponentsBuilder ucBuilder)
	{
		log.error(String.format("Updating User %s ", userWO.getUserId()));
		UserWO currentUser = userService.findById(userWO.getUserId());

		if (currentUser == null)
		{
			System.out.println("User with id " + userWO.getUserId() + " not found");
			return new ResponseEntity<UserWO>(HttpStatus.NOT_FOUND);
		}

		currentUser.setPassword(userWO.getPassword());
		currentUser.setUsername(userWO.getUsername());
		currentUser.setFilms(userWO.getFilms());

		userService.updateUser(currentUser);

		return new ResponseEntity<UserWO>(currentUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/userDelete/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserWO> deleteUser(@PathVariable("id") int id)
	{

		System.out.println("Fetching & Deleting User with id " + id);

		UserWO staffWO = userService.findById(id);
		if (staffWO == null)
		{
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<UserWO>(HttpStatus.NOT_FOUND);
		}

		userService.deleteUserById(id);
		return new ResponseEntity<UserWO>(HttpStatus.NO_CONTENT);
	}
}
