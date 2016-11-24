package test.paginator;

import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miztli on 24/11/16.
 */
public class ListFilteredAndPaginatedImplTest {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<String>();

        testList.add("Jaziel");
        testList.add("Jaziel1");
        testList.add("Jaziel12");
        testList.add("Jaziel123");
        testList.add("Jaziel2");
        testList.add("Jaziel21");
        testList.add("Jaziel212");
        testList.add("Jaziel213");
        testList.add("Jaziel2134");
        testList.add("Jaziel21345");

        ListFilteredAndPaginatedImpl paginatorTest = new ListFilteredAndPaginatedImpl(testList);
        paginatorTest.printList();

        final String startsWith = "Jaziel12";
        List<String> filteredList = paginatorTest.filterList(new Predicate() {
            public boolean evaluate(Object o) {
                String name = (String) o;
                return name.startsWith(startsWith);
            }
        });

        printList("Filtered List", filteredList);

        printList("List first elements", paginatorTest.getFirstItems(5));

        printList("List paginated elements", paginatorTest.getPaginatedItems(2,3));

        System.out.println("Total paginating with 3 elements per page: "+paginatorTest.getTotalPagesWithItems(3));


    }

    public static void printList(String listName, List<String> list){
        System.out.println("---------Printing List "+listName+"-----------");
        for (int i = 0; i<list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
    }
}
