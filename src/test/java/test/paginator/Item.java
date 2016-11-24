package test.paginator;

import com.conecta.commons.utils.paginator.Indexable;

/**
 * Created by miztli on 24/11/16.
 */
public class Item extends Indexable{

    private String name;
    private String token;
    private boolean checked;

    public Item(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
