package lesson5;

import java.util.List;

public interface History {

    void save(String user, HistoryItem historyItem);
    List<HistoryItem> getAll(String user);
}
