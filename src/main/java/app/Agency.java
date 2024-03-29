package app;

public class Agency implements Comparable<Agency>{

    private String agency_code;
    private String correspondent_id;
    private String description;
    private String disabled;
    private String distance;
    private String  id;
    private String payment_method_id;
    private String phone;
    private String site_id;
    private String terminal;
    private Address address;
    private OrderEnum orderEnum;

    public Agency() {
    }

    public Agency(String agency_code, String correspondent_id, String description, String disabled, String distance,
                  String id, String payment_method_id, String phone, String site_id, String terminal, Address address) {
        this.agency_code = agency_code;
        this.correspondent_id = correspondent_id;
        this.description = description;
        this.disabled = disabled;
        this.distance = distance;
        this.id = id;
        this.payment_method_id = payment_method_id;
        this.phone = phone;
        this.site_id = site_id;
        this.terminal = terminal;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAgency_code() {
        return agency_code;
    }

    public void setAgency_code(String agency_code) {
        this.agency_code = agency_code;
    }

    public String getCorrespondent_id() {
        return correspondent_id;
    }

    public void setCorrespondent_id(String correspondent_id) {
        this.correspondent_id = correspondent_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public OrderEnum getOrderEnum() {
        return orderEnum;
    }

    public void setOrderEnum(OrderEnum orderEnum) {
        this.orderEnum = orderEnum;
    }

    @Override
    public int compareTo(Agency o) {

        System.out.println();
        switch (this.orderEnum){
            case ADDRESS:
                return address.getAddress_line().compareTo(o.getAddress().getAddress_line());

            case AGENCY_CODE:
                return new Float(getAgency_code()).compareTo(new Float(o.getAgency_code()));

            default:
                return new Float(getDistance()).compareTo(new Float(o.getDistance()));

        }


    }
}
