package com.store.dal.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;

@Entity
@Table(name = "PRODUCT", schema = "STOCK" )
public class Product implements java.io.Serializable {

    private BigDecimal productId;
    private String productName;
    private BigDecimal productPrice;
    private BigDecimal productQty;
    private Set<ProductCountry> productCountries = new HashSet<ProductCountry>(0);

    public Product() {
    }

    public Product(BigDecimal productId) {
        this.productId = productId;
    }

    public Product(BigDecimal productId, String productName, BigDecimal productPrice, BigDecimal productQty, Set<ProductCountry> productCountries) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
        this.productCountries = productCountries;
    }

    @Id
    @Column(name = "PRODUCT_ID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getProductId() {
        return this.productId;
    }

    public void setProductId(BigDecimal productId) {
        this.productId = productId;
    }

    @Column(name = "PRODUCT_NAME", length = 200)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "PRODUCT_PRICE", precision = 22, scale = 0)
    public BigDecimal getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Column(name = "PRODUCT_QTY", precision = 22, scale = 0)
    public BigDecimal getProductQty() {
        return this.productQty;
    }

    public void setProductQty(BigDecimal productQty) {
        this.productQty = productQty;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    // @LazyCollection(LazyCollectionOption.FALSE)
    public Set<ProductCountry> getProductCountries() {
        return this.productCountries;
    }

    public void setProductCountries(Set<ProductCountry> productCountries) {
        this.productCountries = productCountries;
    }

}
