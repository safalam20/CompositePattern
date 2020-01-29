package com.company;

public class CompositeTest {
    public static void main(String[] args) {
        //Let's first create all menu objects.
        MenuComponent pancakeHouseMenu =
                new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu =
                new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu =
                new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu =
                new Menu("DESSERT MENU", "Dessert of course!");

        //We need a top level menu that stores all the menus.
        MenuComponent allMenus=new Menu("All Menus","Stores Everything");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        //Now we need to add all
        //the menu items
        pancakeHouseMenu.add(new MenuItem(
                "Kaffee",
                "Kaffee with Rich Cream",
                true,
                2.4));
        pancakeHouseMenu.add(new MenuItem(
                "Egg Sandwich",
                "Sandwich with Egg and Cheese",
                false,
                4.6));

        dinerMenu.add(new MenuItem(
                "Pasta",
                "Spaghetti with Marinara Sauce, and a slice of sourdough bread",
                true,
                3.89));
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla icecream",
                true,
                1.59));

        Waitress waitress=new Waitress(allMenus);
        waitress.printMenu();

        //We are making use of iterator. But it's an internal iterator.
        //It means that waitress can not iterate in Menu Components herself.

        waitress.printVeganItems(allMenus);
    }
}
