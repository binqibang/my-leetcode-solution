package weekly;

public class DataStream {
    private int value;
    private int k;
    private int count;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        count = num == value ? count + 1 : 0;
        return count >= k;
    }
}
