package com.conecta.commons.utils.paginator;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.List;

/**
 * Abstract class that provides the implementation for <tt>ListPaginator<E></tt> and <tt>ListFilter<E></tt>
 *
 *
 * @param <E> the type of elements in this list
 *
 * @author  Miztli Melgoza
 * @see List
 */
public abstract class ListFilteredAndPaginated<E> implements ListPaginator<E>, ListFilter<E> {
    private List<E> list;

    private ListFilteredAndPaginated(){}

    /**
     *
     * @param list Receives a List<E> that will be used as a data store to feed all the methods of the class
     */
    public ListFilteredAndPaginated(List<E> list) {
        this.list = list;
    }

    /**
     *
     * @param predicate Filters the initial list provided in the constructor of the class with the given Predicate
     * @return The filtered List<E>
     */
    public List<E> filterList(Predicate predicate) {
        return (List<E>) CollectionUtils.select( list, predicate );
    }

    /**
     *
     * @param quantity Determines the desired number of elements to get from the list provided in the constructor
     * @return A sublist of elements E from the index 0 to quantity
     */
    public List<E> getFirstItems(int quantity) {
        if(list.size()>=quantity){
            return list.subList(0, quantity);
        }else{
            throw new IllegalArgumentException("Parameter quantity must be lower or equal to the size of the list");
        }
    }

    /**
     *
     * @param page Indicates the desired page
     * @param elementsPerPage Number of elements to fill each page
     * @return A sublist of elementsPerPage elements in the page page
     */
    public List<E> getPaginatedItems(int page, int elementsPerPage) {
        if(list.size() > elementsPerPage * page){
            return list.subList((page-1)*elementsPerPage, elementsPerPage * page);
        }else if(list.size() >= (page-1)*elementsPerPage && list.size() <= elementsPerPage * page){
            return list.subList((page-1)*elementsPerPage, list.size());
        }else{
            throw new IndexOutOfBoundsException("La lista no contiene elementos en la página: "+page);
        }
    }

    /**
     *
     * @param itemsPerPage Number of elements to fill each page
     * @return The total of pages generated with itemsPerPage
     */
    public int getTotalPagesWithItems(int itemsPerPage) {
        if(list.size() < itemsPerPage){
            return 1;
        }else{
            double result = (double) list.size() / itemsPerPage;
            Double pages = Math.ceil(result);
            return pages.intValue();
        }
    }

    /**
     * Method used to print the current List<E>
     */
    public abstract void printList();

    public List<E> getList() {
        return list;
    }
}
