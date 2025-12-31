package jp.co.sss.blog.admin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.sss.blog.bean.ArticleBean;
import jp.co.sss.blog.entity.Article;
import jp.co.sss.blog.form.ArticleForm;
import jp.co.sss.blog.repository.ArticleRepository;

@Controller
public class AdminUpdateArticleController {
	@Autowired
	ArticleRepository articleRepo;
	
	@RequestMapping("/admin/update")
	public String updateArticle(@RequestParam(required=false) Integer id, Model model) {
		if(id == null) {
			return "redirect:/admin";
		}
		Article article = articleRepo.getReferenceById(id);
		ArticleBean articleBean = new ArticleBean();
		BeanUtils.copyProperties(article, articleBean);
		model.addAttribute("article",articleBean);
		return "admin/update-article";
	}
	
	@RequestMapping("/admin/update/complete")
	public String updateComplete(@RequestParam Integer id,@ModelAttribute ArticleForm form, Model model) {
		Article article = articleRepo.getReferenceById(id);
		BeanUtils.copyProperties(form, article, "id");
		article = articleRepo.save(article);
		ArticleBean articleBean = new ArticleBean();
		BeanUtils.copyProperties(article, articleBean);
		model.addAttribute("article",articleBean);
		return "redirect:/admin";
	}
	
	@RequestMapping("/admin/delete")
	public String deleteComplete(@RequestParam Integer id) {
		articleRepo.deleteById(id);
		return "redirect:/admin";
	}

}
