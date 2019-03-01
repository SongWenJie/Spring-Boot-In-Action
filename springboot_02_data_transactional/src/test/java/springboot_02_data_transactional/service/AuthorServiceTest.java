package springboot_02_data_transactional.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springboot_02_data_transactional.model.Author;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void add1() throws Exception{
        Author author = new Author("noTransactional","noTransactional");
        authorService.add1(author);
    }

    @Test
    public void add2() {
        Author author = new Author("noRollbackFor","noRollbackFor");
        authorService.add2(author);
    }

    @Test
    public void add3() {
        Author author = new Author("rollbackFor","rollbackFor");
        authorService.add3(author);
    }

    @Test
    public void add4() {
        Author author = new Author("rollbackForAllException","rollbackForAllException");
        authorService.add4(author);
    }
}