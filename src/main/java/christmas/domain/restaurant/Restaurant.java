package christmas.domain.restaurant;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private final Map<String, MenuItem> menuMap;

    public Restaurant() {
        this.menuMap = new HashMap<>();
        initializeMenu();
    }

    public boolean HaveRestaurantMenu(String menu){
       return menuMap.containsKey(menu);
    }

    public int getPriceOfMenu(String menu){
        return menuMap.get(menu).getPrice();
    }

    public MenuType getMenuTypeOfMenu(String menu){
        return menuMap.get(menu).getType();
    }

    private void initializeMenu(){
        for (MenuItem menuItem : MenuItem.values()) {
            menuMap.put(menuItem.getName(), menuItem);
        }
    }
}
