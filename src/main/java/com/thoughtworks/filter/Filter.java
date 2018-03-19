package com.thoughtworks.filter;

interface Filter<T,E> {
    boolean isMatched(T object, E... criteria);
}