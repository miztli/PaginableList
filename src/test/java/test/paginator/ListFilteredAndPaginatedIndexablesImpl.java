package test.paginator;

import com.conecta.commons.utils.paginator.Indexable;
import com.conecta.commons.utils.paginator.ListFilteredAndPaginatedIndexables;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by miztli on 24/11/16.
 */
public class ListFilteredAndPaginatedIndexablesImpl extends ListFilteredAndPaginatedIndexables<Item> {

    public ListFilteredAndPaginatedIndexablesImpl(List<Item> list) {
        super(list);
    }

    public void setIndexableChecked(int originalIndex){
        Item item = getIndexable(originalIndex);
        if(item != null){
            item.setChecked(true);
        }else{
            throw new NoSuchElementException("There is no element with original index = "+originalIndex);
        }
    }public void setIndexableUnchecked(int originalIndex){
        Item item = getIndexable(originalIndex);
        if(item != null){
            item.setChecked(false);
        }else{
            throw new NoSuchElementException("There is no element with original index = "+originalIndex);
        }
    }


}
