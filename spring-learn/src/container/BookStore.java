package container;

import java.util.List;

public class BookStore {
    private List<BookInfo> store;

    public void setStore(List<BookInfo> store) {
        this.store = store;
    }

    public String show() {
        String msg = "";
        for(BookInfo o : store){
            msg += o.show() + "\n";
        }
        return msg;
    }
}
