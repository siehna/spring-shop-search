package handson.example.springshopsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import handson.example.springshopsearch.model.item.Item;
import handson.example.springshopsearch.service.ItemService;
@Controller
@RequestMapping("/items")
public class ItemController {

	@Autowired
    ItemService itemService;
	@GetMapping
    public String listItem(Model model) {
        return itemService.listItem(model);
    }

	@GetMapping("add")
    public String getForm() {
        return itemService.getForm();
    }

    @PostMapping("/add")
    public String registerItem(Item item) {
        return itemService.registerItem(item);
    }

    @PostMapping("{id:[0-9]+}")
    public String update(Item item) {
    	return itemService.update(item);
    }

    @GetMapping("{id:[0-9]+}")//下の@path以下にIDが入ってくる-> ... / item / {id}
    public String getDetail(Model model, @PathVariable("id") Long id) {
        return itemService.getDetail(model, id);
    }

}
