package lesson5;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


public class HistoryItem {
    public final int x;
    public final int y;
    public final int z;

    public final LocalDateTime ldt;

    public HistoryItem(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ldt = LocalDateTime.now();
    }


    @Override
    public String toString(){
        return this.ldt.toString()
                + " " + this.x + " + " + this.y + " = " + this.z;
    }
}
