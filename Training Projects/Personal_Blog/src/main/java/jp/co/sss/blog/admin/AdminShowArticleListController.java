package jp.co.sss.blog.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.blog.entity.Article;
import jp.co.sss.blog.repository.ArticleRepository;

@Controller
public class AdminShowArticleListController {
	@Autowired
	ArticleRepository articleRepo;
	
	@RequestMapping(path="/admin")
	public String showArticlList(Model model) {
		List<Article> articles = articleRepo.findAllByOrderByIdAsc();
		model.addAttribute("articles", articles);
		return "admin/index";
	}

}
