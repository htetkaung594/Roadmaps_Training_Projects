package jp.co.sss.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.blog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

	List<Article> findAllByOrderByIdAsc();

	Article findByIdAndDeleteFlag(Integer id, int deleteFlag);
}
