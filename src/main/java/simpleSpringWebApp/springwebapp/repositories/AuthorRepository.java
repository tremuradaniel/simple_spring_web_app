package simpleSpringWebApp.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import simpleSpringWebApp.springwebapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}