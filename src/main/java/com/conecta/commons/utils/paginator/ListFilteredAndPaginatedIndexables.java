package com.conecta.commons.utils.paginator;

import org.apache.commons.collections4.Predicate;

import java.util.List;

/**
 * This class provide the implementation to paginate a source list keeping
 * the original index inside the <tt>Indexable</tt> element
 *
 * @param <E> Type of elements in the list which must extend the <tt>Indexable</tt> abstract class
 *
 * @author  Miztli Melgoza
 */
public abstract class ListFilteredAndPaginatedIndexables<E extends Indexable> extends ListFilteredAndPaginated<E> {

    private List<E> indexableList;

    public ListFilteredAndPaginatedIndexables(List<E> list) {
        super(list);
        this.indexableList = list;
        setOriginalIndex();
    }

    @Override
    public void printList() {
        System.out.println("Printing indexed list:");
        for (E item: indexableList) {
            System.out.println("Item original index: "+item.getInternalIndex());
        }
    }

    /**
     * Method that iterates elements in List<E> and sets their internal index (original index)
     */
    private void setOriginalIndex(){
        for (int i = 0; i < indexableList.size(); i++) {
            indexableList.get(i).setInternalIndex(i);
        }
    }

    /**
     *
     * @param index Internal index (original index)
     * @return E element according to its internal index (original index)
     */
    public E getIndexable(int index){
        for (E element: indexableList) {
            if(element.getInternalIndex() == index){
              return element;
            }
        }

        return null;
    }

}
