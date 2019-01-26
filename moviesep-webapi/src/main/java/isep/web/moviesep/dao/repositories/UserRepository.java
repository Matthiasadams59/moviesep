package isep.web.moviesep.dao.repositories;

import org.springframework.data.repository.CrudRepository;


import isep.web.moviesep.jpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>
{
	User findByUsername(String username);
}
