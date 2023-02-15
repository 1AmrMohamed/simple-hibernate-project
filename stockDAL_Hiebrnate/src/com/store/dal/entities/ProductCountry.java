package com.store.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_COUNTRY",
         schema = "STOCK"
)
public class ProductCountry implements java.io.Serializable {

    private int seqId;
    private Product product;
    private String countryName;
    private Integer productModel;
    private Integer productCountryQty;

    public ProductCountry() {
    }

    public ProductCountry(int seqId) {
        this.seqId = seqId;
    }

    public ProductCountry(int seqId, Product product, String countryName, Integer productModel, Integer productCountryQty) {
        this.seqId = seqId;
        this.product = product;
        this.countryName = countryName;
        this.productModel = productModel;
        this.productCountryQty = productCountryQty;
    }

    @Id

    @Column(name = "SEQ_ID", unique = true, nullable = false, precision = 5, scale = 0)
    public int getSeqId() {
        return this.seqId;
    }

    public void setSeqId(int seqId) {
        this.seqId = seqId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID_FK")
    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Column(name = "COUNTRY_NAME", length = 40)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "PRODUCT_MODEL", precision = 5, scale = 0)
    public Integer getProductModel() {
        return this.productModel;
    }

    public void setProductModel(Integer productModel) {
        this.productModel = productModel;
    }

    @Column(name = "PRODUCT_COUNTRY_QTY", precision = 5, scale = 0)
    public Integer getProductCountryQty() {
        return this.productCountryQty;
    }

    public void setProductCountryQty(Integer productCountryQty) {
        this.productCountryQty = productCountryQty;
    }

}
