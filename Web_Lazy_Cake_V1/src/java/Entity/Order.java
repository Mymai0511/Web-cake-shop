/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private int id;
    private int customerId;
    private Date orderDate;
    private double shippingFee;
    private double orderTotal;
    private String city;
    private String district;
    private String commune;
    private String detail;
    private String longitude;
    private String latitude;
    private int orderStatus;
    private int paymentMethod;
    private int shippingMethod;
    private Date createdAt;
    private Date modifiedAt;
    private Date deliveryAt;

    // Constructors, getters, and setters
    public Order() {
    }

    public Order(int customerId, Date orderDate, double shippingFee, double orderTotal,
            String city, String district, String commune, String detail,
            String longitude, String latitude, int orderStatus, int paymentMethod,
            int shippingMethod, Date createdAt, Date modifiedAt, Date deliveryAt) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippingFee = shippingFee;
        this.orderTotal = orderTotal;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.detail = detail;
        this.longitude = longitude;
        this.latitude = latitude;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deliveryAt = deliveryAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(int shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Date getDeliveryAt() {
        return deliveryAt;
    }

    public void setDeliveryAt(Date deliveryAt) {
        this.deliveryAt = deliveryAt;
    }

    @Override
    public String toString() {
        return "Order{"
                + "id=" + id
                + ", customerId=" + customerId
                + ", orderDate=" + orderDate
                + ", shippingFee=" + shippingFee
                + ", orderTotal=" + orderTotal
                + ", city='" + city + '\''
                + ", district='" + district + '\''
                + ", commune='" + commune + '\''
                + ", detail='" + detail + '\''
                + ", longitude='" + longitude + '\''
                + ", latitude='" + latitude + '\''
                + ", orderStatus=" + orderStatus
                + ", paymentMethod=" + paymentMethod
                + ", shippingMethod=" + shippingMethod
                + ", createdAt=" + createdAt
                + ", modifiedAt=" + modifiedAt
                + ", deliveryAt=" + deliveryAt
                + '}';
    }

}
