package zhy2002.springexamples.domain;

import java.math.BigDecimal;

/**
 * An example domain class for testing.
 */
public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String unitType;

    public Product(){
    }

    public Product(String name){
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
