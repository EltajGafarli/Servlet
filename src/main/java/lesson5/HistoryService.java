package lesson5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryService implements History{
    private final Map<String, List<HistoryItem>> map = new HashMap<>();

    @Override
    public void save(String user, HistoryItem historyItem) {
        List<HistoryItem> items = map.getOrDefault(user, new ArrayList<>());
        items.add(historyItem);

        if(items.size() == 1) map.put(user, items);


    }

    @Override
    public List<HistoryItem> getAll(String user) {

        List<HistoryItem> historyItems = map.getOrDefault(user, new ArrayList<>());

        return historyItems;
    }
}
