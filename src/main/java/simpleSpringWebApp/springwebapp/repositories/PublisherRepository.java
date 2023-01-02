package simpleSpringWebApp.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import simpleSpringWebApp.springwebapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
