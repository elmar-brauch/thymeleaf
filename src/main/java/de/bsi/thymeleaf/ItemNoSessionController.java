package de.bsi.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * This Controller is just a demo for a Controller without Session handling.
 * To show the difference to a Controller with Session handling.
 */
//@Controller
public class ItemNoSessionController {
	
	private static final String MODEL_KEY_ITEMS = "items";
	private static final String VIEW_NAME_LIST = "item-list";
	private static final String VIEW_NAME_CREATE = "item-create";
	
	private List<Item> items = new ArrayList<>();
	
	@GetMapping(path = {"/", "/item"})
	public ModelAndView showItems(ModelAndView mav) {
		mav.setViewName(VIEW_NAME_LIST);
		mav.addObject(MODEL_KEY_ITEMS, items);
		return mav;
	}
	
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