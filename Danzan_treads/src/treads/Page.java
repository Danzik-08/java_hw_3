package treads;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Page {
    private Map<String, Integer> lists;
    public synchronized void Click(String lists) {this.lists.put(lists, this.lists.get(lists)+1);}
    public Page(Map<String, Integer> info) {
        this.lists = info;
    }

    public List<String> getLists() {
        List<String> Listl = new ArrayList<>(this.lists.size());
        Listl.addAll(this.lists.keySet());
        return Listl;
    }

    public void ListUrls(){
        int sum = 0;
        for (String key : this.lists.keySet()){
            sum += this.lists.get(key);
        }
        System.out.println(sum);
        System.out.println(this.lists);
    }
}

