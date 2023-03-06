package vn.edu.hcmuaf.fit.ecommerceclothingbackend.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private double price;
    private Date date;
    private String url;

    public Product( String productName, double price, Date date, String url) {

        this.productName = productName;
        this.price = price;
        this.date = date;
        this.url = url;
    }

    public Product(){

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName=" + productName +
                ", price=" + price +
                ", date=" + date.toString() +
                ", url='" + url + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
