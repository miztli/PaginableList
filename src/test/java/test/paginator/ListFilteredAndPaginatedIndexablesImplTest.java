package test.paginator;

import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miztli on 24/11/16.
 */
public class ListFilteredAndPaginatedIndexablesImplTest {
    public static void printList(String listName, List<Item> list){
        System.out.println("---------Printing List "+listName+"-----------");
        for (int i = 0; i<list.size(); i++) {
            System.out.println("originalIndex: " + list.get(i).getInternalIndex() + " name: "+list.get(i).getName() + " token: " + list.get(i).getToken() + " isChecked: " + list.get(i).isChecked());
        }
    }
    public static void main(String[] args) {
        List<Item> testList = new ArrayList<Item>();

        Item i1 = new Item("Jaziel", "AE345678");
        Item i2 = new Item("Jaziel", "AE3456789");
        Item i3 = new Item("Jaziel", "AE34567891");
        Item i4 = new Item("Jaziel", "AE345678912");
        Item i5 = new Item("Jaziel", "AE345679");
        Item i6 = new Item("Jaziel", "AE3456791");
        Item i7 = new Item("Jaziel", "AE34567912");
        Item i8 = new Item("Jaziel", "AE345679123");
        Item i9 = new Item("Jaziel", "AE3456744");
        Item i10 = new Item("Jaziel", "AE34567445");

        testList.add(i1);
        testList.add(i2);
        testList.add(i3);
        testList.add(i4);
        testList.add(i5);
        testList.add(i6);
        testList.add(i7);
        testList.add(i8);
        testList.add(i9);
        testList.add(i10);

        ListFilteredAndPaginatedIndexablesImpl indexablePaginator = new ListFilteredAndPaginatedIndexablesImpl(testList);

        indexablePaginator.printList();

        final String startsWith = "AE345679";
        List<Item> filteredList = indexablePaginator.filterList(new Predicate() {
            public boolean evaluate(Object o) {
                Item item = (Item) o;
                return item.getToken().startsWith(startsWith);
            }
        });

        printList("filteredList", filteredList);

        System.out.println("Setting original index 4,5 to true");
        indexablePaginator.setIndexableChecked(4);
        indexablePaginator.setIndexableChecked(5);

        printList("filteredList", filteredList);

        System.out.println("Setting original index 5 to false");
        indexablePaginator.setIndexableUnchecked(4);

        printList("filteredList", filteredList);

        printList("initial list", indexablePaginator.getList());
//        System.out.println("Setting original index 19 to false (Throws exception)");
//        indexablePaginator.setIndexableChecked(19);
    }
}
