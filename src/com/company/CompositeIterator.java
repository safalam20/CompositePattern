package com.company;

import java.util.Iterator;
import java.util.Stack;
/*
It’s got the job of iterating
over the MenuItems in the component, and of making sure all the child
Menus (and child child Menus, and so on) are included.
 */

public class CompositeIterator implements Iterator<MenuComponent> {
    Stack stack=new Stack<>();

    //The iterator of the top level
    //composite we’re going to iterate over
    //is passed in. We throw that in a
    //stack data structure.

    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }
    //To see if there is a next element,
    //we check to see if the stack is
    //empty; if so, there isn’t.
    //Otherwise, we get the iterator
    //off the top of the stack and see
    //if it has a next element. If it
    //doesn’t we pop it off the stack
    //and call hasNext() recursively.

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = (Iterator) stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }

    }
    //Okay, when the client wants
    //to get the next element we
    //first make sure there is one
    //by calling hasNext()...

    //If there is a next element, we
    //get the current iterator off the
    //stack and get its next element.

    //If that element is a menu, we have
    //another composite that needs to
    //be included in the iteration, so we
    //throw it on the stack. In either
    //case, we return the component
    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            return component;
        } else {
            return null;
        }

    }
}
