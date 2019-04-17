package app;

public enum OrderEnum {

    ADDRESS("address"),
    AGENCY_CODE("agency_code"),
    DISTANCE("distance");

    private String orderType;

    OrderEnum(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderBy() {
        return orderType;
    }

    public void setOrderBy(String orderType) {
        this.orderType = orderType;
    }
}
