package handson.example.springshopsearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import handson.example.springshopsearch.model.item.Item;
import handson.example.springshopsearch.model.item.ItemRepository;

@Service
@RequestMapping("/items")
public class ItemService {
	@Autowired
    ItemRepository itemRepository;

	//@GetMapping
	public String listItem(Model model) {
	        List<Item> list = itemRepository.findAll();
	        model.addAttribute("items", list);
	        return "list_item";
	}

	//@GetMapping("add")
    public String getForm() {
        return "item_form";
    }

    //@PostMapping("/add")
    public String registerItem(Item item) {
        itemRepository.save(item);
        return "redirect:/items";
    }

    //@PostMapping("{id:[0-9]+}")
    public String update(Item item) {
    	itemRepository.save(item);
    	return "redirect:/items";
    }

   // @GetMapping("{id:[0-9]+}")//下の@path以下にIDが入ってくる-> ... / item / {id}
    public String getDetail(Model model,Long id) {
        model.addAttribute("item", itemRepository.getOne(id));
        return "detail";
    }

}
