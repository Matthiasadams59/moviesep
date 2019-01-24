package isep.web.moviesep.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isep.web.moviesep.dao.repositories.ActorRepository;
import isep.web.moviesep.jpa.entities.Actor;
import isep.web.moviesep.model.ActorWO;

@Service("actorService")
@Transactional
public class ActorServiceImpl implements ActorService {
	@Autowired
	private ActorRepository actorRepository;

	private static final Log log = LogFactory.getLog(ActorServiceImpl.class);

	@Override
	public List<ActorWO> findAllActors() {
		List<ActorWO> actors = new LinkedList<ActorWO>();

		for (Actor actor : actorRepository.findAll()) {
			actors.add(new ActorWO(actor));
			log.debug("Adding " + actor);
		}

		return actors;
	}

	@Override
	public ActorWO findById(int id) {
		log.debug(String.format("Looking for user by Id %s", id));
		Actor actor = actorRepository.findById(id).get();

		if (actor != null) {
			return new ActorWO(actor);
		}
		return null;
	}

	@Override
	public void saveActor(ActorWO actorWO) {
		Actor actor = new Actor();
		actor.setLastName(actorWO.getLastName());
		actor.setFirstName(actorWO.getFirstName());
		actor.setGender(actorWO.getGender());
		actor.setFilms(actorWO.getFilms());
		actorRepository.save(actor);
	}

	@Override
	public void updateActor(ActorWO actorWO) {
		Actor actor2update = actorRepository.findById(actorWO.getActorId()).get();
		actor2update.setLastName(actorWO.getLastName());
		actor2update.setFirstName(actorWO.getFirstName());
		actor2update.setGender(actorWO.getGender());
		actor2update.setFilms(actorWO.getFilms());
		actorRepository.save(actor2update);
	}

	@Override
	public void deleteActorById(int id) {
		actorRepository.deleteById(id);
	}

}
