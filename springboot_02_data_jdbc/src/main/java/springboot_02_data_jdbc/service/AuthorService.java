package springboot_02_data_jdbc.service;

import springboot_02_data_jdbc.model.Author;

import java.util.List;

public interface AuthorService {
    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthors();
}
