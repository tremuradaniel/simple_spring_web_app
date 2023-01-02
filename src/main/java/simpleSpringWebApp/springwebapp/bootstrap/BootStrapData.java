package simpleSpringWebApp.springwebapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import simpleSpringWebApp.springwebapp.domain.Author;
import simpleSpringWebApp.springwebapp.domain.Book;
import simpleSpringWebApp.springwebapp.domain.Publisher;
import simpleSpringWebApp.springwebapp.repositories.AuthorRepository;
import simpleSpringWebApp.springwebapp.repositories.BookRepository;
import simpleSpringWebApp.springwebapp.repositories.PublisherRepository;

@Component // tells the Spring Framework to go ahead and detect this as a Spring managed component.
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        Publisher p = new Publisher();
        p.setAddress("Lincon St.");
        p.setCity("Amazonia");
        p.setName("Main");
        p.setZip("543");
        p.setState("OfBliss");

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(p);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
