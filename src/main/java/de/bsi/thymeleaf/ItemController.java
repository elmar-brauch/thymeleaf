package de.bsi.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {
	
	private static final String MODEL_KEY_ITEMS = "items";
	private static final String VIEW_NAME_LIST = "item-list";
	private static final String VIEW_NAME_CREATE = "item-create";
	
	@GetMapping(path = {"/", "/item"})
	public ModelAndView showItems(ModelAndView mav) {
		mav.setViewName(VIEW_NAME_LIST);
		mav.addObject(MODEL_KEY_ITEMS, readItemsFromSession());
		return mav;
	}
	
	@GetMapping("/item-create")
	public String showCreateItem() {
		return VIEW_NAME_CREATE;
	}
	
	@PostMapping("/item") 
	public String createNewItem(Model model,
			@RequestParam String itemname, @RequestParam String itemid) {
		createItemInSession(itemname, itemid);
		model.addAttribute(MODEL_KEY_ITEMS, readItemsFromSession());
		return VIEW_NAME_LIST;
	}

	@Autowired private HttpSession session;
	
	private List readItemsFromSession() {
		if (session.getAttribute(MODEL_KEY_ITEMS) instanceof List items)
			return items;
		return List.of();
	}
	
	private void createItemInSession(String name, String id) {
		var items = new ArrayList<Item>();
		var obj = session.getAttribute(MODEL_KEY_ITEMS);
		if (obj instanceof ArrayList) 
			items = (ArrayList<Item>) obj;
		var item = new Item();
		item.setId(id);
		item.setName(name);
		items.add(item);
		session.setAttribute(MODEL_KEY_ITEMS, items);
	}
}