package de.bsi.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//TODO Define as Controller Bean
public class ItemController {
	
	private static final String MODEL_KEY_ITEMS = "items";
	private static final String VIEW_NAME_LIST = "item-list_0";
	private static final String VIEW_NAME_CREATE = "item-create";
	
	private List<Item> items = new ArrayList<>();
	
	// TODO GET for / and /item show item-list_0
	
	// TODO Use ModelAndView
	
	
	
	
	
	
	
	@GetMapping("/item-create")
	public String showCreateItem() {
		return VIEW_NAME_CREATE;
	}
	
	@PostMapping("/item") 
	public String createNewItem(Model model,
			@RequestParam String itemname, @RequestParam String itemid) {
		var item = new Item();
		item.setId(itemid);
		item.setName(itemname);
		items.add(item);
		model.addAttribute(MODEL_KEY_ITEMS, items);
		return VIEW_NAME_LIST;
	}
}