package jp.co.sss.blog.client;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.sss.blog.bean.ArticleBean;
import jp.co.sss.blog.entity.Article;
import jp.co.sss.blog.repository.ArticleRepository;

@Controller

public class ClientShowListController {
	@Autowired
	ArticleRepository articleRepo;
	
	@RequestMapping(path="/home")
	public String showArticlList(Model model) {
		List<Article> articles = articleRepo.findAllByOrderByIdAsc();
		model.addAttribute("articles", articles);
		return "client/index";
	}
	
	@RequestMapping("/article")
	public String articleDetail(@RequestParam Integer id, Model model) {
		
		Article articel = articleRepo.findByIdAndDeleteFlag(id,0);
		if(articel == null) {
			return "redirect:/home";
		}
		
		ArticleBean articleBean = new ArticleBean();
		BeanUtils.copyProperties(articel, articleBean);
		model.addAttribute("articles",articleBean);
		return"client/article-detail";
	}
}
