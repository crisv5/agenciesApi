package app;

import java.util.List;

public class Paging {

    private int limit;
    private int offset;
    private int total;

    public Paging() {
    }

    public Paging(int limit, int offset, int total) {
        this.limit = limit;
        this.offset = offset;
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
