package app;

public enum Order {

    ADDRESS("address"),
    AGENCY_CODE("agency_code"),
    DISTANCE("distance");

    private String orderType;

    Order(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderBy() {
        return orderType;
    }

    public void setOrderBy(String orderType) {
        this.orderType = orderType;
    }
}
