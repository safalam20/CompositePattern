package com.company;

import java.util.Iterator;
//MenuItem returns NullIterator when Menu returns CompositeIterator.
//MenuItem has nothing to iterate over. We have to options.
//We can return null or return NullIterator.
//We don't have calculate here anything. We already know it doesn't have next..
public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public MenuComponent next() {
        return null;
    }
}

