package com.jachin.springbootsday03elastic.repository;

import com.jachin.springbootsday03elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

//类似与springdata jpa 泛型中参数1为实体bean类，参数二为主键类型
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    //ElasticsearchRepository已经包含很多方法，但也支持自定义方法
    /*
    *     自定义方法不需要实现，只需要根据springdata elasticsearch文档中
    *       关于自定义方法的命名规则来编写方法名及参数（
    *           如什么样的方法名对应什么样的查询语句在其内部已经实现）
     * */
    public List<Book> findByBookNameLike(String bookName);

}
