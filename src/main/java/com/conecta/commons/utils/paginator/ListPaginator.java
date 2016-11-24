package com.conecta.commons.utils.paginator;

import java.util.List;

/**
 * Interface utility that helps in the pagination of <tt>List<E></tt>
 *
 *
 * @param <E> the type of elements in this list
 *
 * @author  Miztli Melgoza
 * @see List
 */
public interface ListPaginator<E> {
    List<E> getFirstItems(int quantity);
    List<E> getPaginatedItems(int page, int elementsPerPage);
    int getTotalPagesWithItems(int itemsPerPage);

}
