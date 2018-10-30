package handson.example.springshopsearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import handson.example.springshopsearch.model.item.Item;
import handson.example.springshopsearch.model.item.ItemRepository;

@Controller
@RequestMapping("/")//操作する対象のページ
public class HomeController {

    @GetMapping("about")
    public String getAbout() {
        return "about";
    }
    @Autowired
    ItemRepository itemRepository;

    @GetMapping
    public String index(
            Model model,
            @RequestParam(name = "keyword", required = false) Optional<String> keyword,
            @RequestParam(name = "pulldown", required = false) Optional<String> pulldown) {
        List<Item> list= itemRepository.findAll();//
        	if(keyword.isPresent()&&pulldown.isPresent()) {
        		if(pulldown.get().equals("product")) {
        			list = itemRepository.findByNameContainsOrderByIdAsc(keyword.get());//trueならこちらが、指定の物を抽出
        		}else if(pulldown.get().equals("explane")) {
        			list = itemRepository.findByDescriptionContainsOrderByIdAsc(keyword.get());
        		}else if(pulldown.get().equals("both")) {
        			list = itemRepository.findByNameOrDescriptionContainsOrderByIdAsc(keyword.get(),keyword.get());
        		}
        	}else list= itemRepository.findAll();//falseならこちらがリストに入る、全て表示
        model.addAttribute("items", list);
        return "index";
    }
}
