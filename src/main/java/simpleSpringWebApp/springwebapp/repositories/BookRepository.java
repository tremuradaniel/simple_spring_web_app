package simpleSpringWebApp.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;
import simpleSpringWebApp.springwebapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}