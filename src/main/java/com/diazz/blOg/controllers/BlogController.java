package main.java.com.diazz.blOg.controllers;

import com.diazz.blOg.models.Post;
import com.diazz.blOg.repo.PostRepository;
import com.diazz.blOg.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private PostRepository postRepository;
    private impl impl;

    public BlogController(com.diazz.blOg.service.impl impl) {
        this.impl = impl;
    }

    @GetMapping
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }
}