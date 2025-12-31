package jp.co.sss.blog.admin;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.blog.bean.ArticleBean;
import jp.co.sss.blog.entity.Article;
import jp.co.sss.blog.form.ArticleForm;
import jp.co.sss.blog.repository.ArticleRepository;

@Controller
public class AdminNewArticleController {
	@Autowired
	ArticleRepository articleRepo;

	
	@RequestMapping("/admin/new")
	public String newArticle() {
		return"admin/new-article";
	}
	
	@RequestMapping("/admin/new/complete")
	public String newArticleComplete(ArticleForm form,Model model) {
		Article article = new Article();
		BeanUtils.copyProperties(form, article, "id");
		article.setInsertDate(new Date());
		article = articleRepo.save(article);
		ArticleBean articleBean = new ArticleBean();
		BeanUtils.copyProperties(article, articleBean);
		model.addAttribute("article",articleBean);
		return "redirect:/admin";
	}
	

}
