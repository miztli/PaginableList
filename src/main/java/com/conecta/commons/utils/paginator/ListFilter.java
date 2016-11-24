package com.conecta.commons.utils.paginator;

import org.apache.commons.collections4.Predicate;
import java.util.List;


/**
 * Interface utility that helps filtering <tt>List<E></tt>
 *
 *
 * @param <E> the type of elements in this list
 *
 * @author  Miztli Melgoza
 * @see List
 */
public interface ListFilter<E> {
    List<E> filterList(Predicate predicate);

}
