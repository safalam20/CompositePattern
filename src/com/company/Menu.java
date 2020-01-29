package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent {
    //We need one iterator per menu.
    Iterator<MenuComponent> iterator=null;

    //Menu can have any number of children of type MenuComponent, we’ll use an
    //internal ArrayList to hold these
    ArrayList<MenuComponent> menuComponents=new ArrayList<>();

    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    /*
    Here’s how you add MenuItems or other Menus to a Menu. Because
    both MenuItems and Menus are MenuComponents, we just need one
    method to do both.
     */
    public void add(MenuComponent menuComponent){
        menuComponents.add(menuComponent);
    }

    public MenuComponent getChild(int i){
        return menuComponents.get(i);
    }
    /*
    Here are the getter methods for getting the name and
    description.
    Notice, we aren’t overriding getPrice() or isVegetarian()
    because those methods don’t make sense for a Menu
    (although you could argue that isVegetarian() might make
    sense). If someone tries to call those methods on a Menu,
    they’ll get an UnsupportedOperationException.
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
    //To print the Menu, we print the
    //Menu’s name and description.
    //But there is a problem.
    //this method should not only print itself, but it should also print its components.
    //Remember. We are in Menu class. Menu class can be Diner Menu. There is for example Soup as MenuItem
    //and Dessert Menu as Menu in Diner Menu. They are all stored in arrayList. We should iterate in arrayList and print them.
    //It's possible because both Menu and MenuItems implement print() method.

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        //Until now it's printed menus name and description.
        //Now we should print what's in the array.
        Iterator<MenuComponent> iterator=menuComponents.iterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent=iterator.next();
            menuComponent.print();
        }
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        if (iterator==null){
            iterator=new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }
}
