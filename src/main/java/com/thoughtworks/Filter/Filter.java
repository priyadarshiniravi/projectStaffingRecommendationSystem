package com.thoughtworks.Filter;

interface Filter<T,E> {
    boolean isMatched(T object, E text);
}