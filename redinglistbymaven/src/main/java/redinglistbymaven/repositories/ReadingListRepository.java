package redinglistbymaven.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import redinglistbymaven.model.Book;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {

    List<Book> findByReader(String reader);
}
