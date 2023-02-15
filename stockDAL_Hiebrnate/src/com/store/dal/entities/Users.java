package com.store.dal.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS",
         schema = "STOCK"
)
public class Users implements java.io.Serializable {

    private BigDecimal usrId;
    private String usrFullName;
    private String email;
    private String usrName;
    private String usrPassword;

    public Users() {
    }

    public Users(BigDecimal usrId) {
        this.usrId = usrId;
    }

    public Users(BigDecimal usrId, String usrFullName, String email, String usrName, String usrPassword) {
        this.usrId = usrId;
        this.usrFullName = usrFullName;
        this.email = email;
        this.usrName = usrName;
        this.usrPassword = usrPassword;
    }

    @Id

    @Column(name = "USR_ID", unique = true, nullable = false, precision = 22, scale = 0)
    public BigDecimal getUsrId() {
        return this.usrId;
    }

    public void setUsrId(BigDecimal usrId) {
        this.usrId = usrId;
    }

    @Column(name = "USR_FULL_NAME", length = 200)
    public String getUsrFullName() {
        return this.usrFullName;
    }

    public void setUsrFullName(String usrFullName) {
        this.usrFullName = usrFullName;
    }

    @Column(name = "EMAIL", length = 200)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "USR_NAME", length = 200)
    public String getUsrName() {
        return this.usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    @Column(name = "USR_PASSWORD", length = 200)
    public String getUsrPassword() {
        return this.usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

}
