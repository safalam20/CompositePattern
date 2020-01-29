package com.company;

//She is the main client of this code.
//Waitress needs the menu information...

import java.util.Iterator;

public class Waitress {
    MenuComponent allMenus;
    /*
    Now we just hand her the top level menu
    component, the one that contains all the
    other menus. We’ve called that allMenus.
     */
    public Waitress(MenuComponent allMenus){
        this.allMenus=allMenus;
    }

    /*
    All she has to do to print the entire menu
    hierarchy - all the menus, and all the menu
    items - is call print() on the top level menu.
     */

    public void printMenu(){
        allMenus.print();
    }
    //After we implemented external iterator, our waitress can iterate over the menus.
    public void printVeganItems(MenuComponent allMenus){
        Iterator<MenuComponent> iterator=allMenus.createIterator();
        while (iterator.hasNext()){
            MenuComponent menuComponent=iterator.next();
            if (menuComponent instanceof MenuItem && menuComponent.isVegetarian()){
                menuComponent.print();
            }
        }
    }

}

