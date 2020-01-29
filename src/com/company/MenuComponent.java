package com.company;

import java.util.Iterator;

/*
The Component defines an interface for all objects in
the composition: both the composite and the leaf nodes.
 */
//We have Menu and MenuItem objects in this project.
//MenuComponent defines default methods for each classes (Menu, MenuItem)
public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    public String getName() {
        throw new UnsupportedOperationException();
    }
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    public void print() {
        throw new UnsupportedOperationException();
    }
    public abstract Iterator<MenuComponent> createIterator();
}
