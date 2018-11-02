package handson.example.springshopsearch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import handson.example.springshopsearch.service.HomeService;

@Controller
@RequestMapping("/")//操作する対象のページ
public class HomeController {

    @GetMapping("about")
    public String getAbout() {
        return "about";
    }
    @Autowired
    HomeService homeService;

    @GetMapping
    public String index(
            Model model,
            @RequestParam(name = "keyword", required = false) Optional<String> keyword,
            @RequestParam(name = "pulldown", required = false) Optional<String> pulldown) {
        return homeService.index(model, keyword, pulldown);
    }
}
