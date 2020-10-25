package de.bsi.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {

	private List<Item> items = new ArrayList<>();
	
	private static final String MODEL_KEY_ITEMS = "items";
	private static final String VIEW_NAME_LIST = "item-list";
	private static final String VIEW_NAME_CREATE = "item-create";
	
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
		item.setName(itemname);
		item.setId(itemid);
		items.add(item);
		model.addAttribute(MODEL_KEY_ITEMS, items);
		return VIEW_NAME_LIST;
	}
}