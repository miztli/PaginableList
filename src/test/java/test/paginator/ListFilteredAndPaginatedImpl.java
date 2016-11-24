package test.paginator;

import com.conecta.commons.utils.paginator.ListFilteredAndPaginated;
import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miztli on 22/11/16.
 */
public class ListFilteredAndPaginatedImpl extends ListFilteredAndPaginated<String>{


    /**
     * @param list Receives a List<E> that will be used as a data store to feed all the methods of the class
     */
    public ListFilteredAndPaginatedImpl(List<String> list) {
        super(list);
    }

    public void printList() {
        System.out.println("Printing base list: ");
        for (int i = 0; i<getList().size(); i++) {
            System.out.println(i + " : " + getList().get(i));
        }
    }




}
