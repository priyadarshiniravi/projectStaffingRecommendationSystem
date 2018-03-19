package com.thoughtworks.filter;

import java.util.List;
import java.util.stream.Collectors;

public class FilterList<E> {
    public <T> List filterList(List<T> originalList, Filter filter, E... criteria) {
        List<T> filterList = originalList.stream().filter(object -> filter.isMatched(object, criteria)).collect(Collectors.toList());
        return filterList;
    }
}
