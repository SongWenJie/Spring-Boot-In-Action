package springboot_02_data_mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import springboot_02_data_mybatis.model.Author;


/**
 * 方案二 通过配置文件的方式
 */
@Mapper
public interface AuthorMapper2 {

    Author findAuthor(Long id);
}
