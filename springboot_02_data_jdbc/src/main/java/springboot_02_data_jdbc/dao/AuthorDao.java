package springboot_02_data_jdbc.dao;

import springboot_02_data_jdbc.model.Author;

import java.util.List;

public interface AuthorDao {
    int add(Author author);

    int update(Author author);

    int delete(Long id);

    Author findAuthor(Long id);

    List<Author> findAuthors();
}
