package com.example.demo;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Table(name = "traders")
@EntityListeners(AuditingEntityListener.class)
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "tax_rate", nullable = false)
    private float taxRate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }
}
