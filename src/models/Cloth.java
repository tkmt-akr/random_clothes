package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "getAllClothes",
        query = "SELECT m FROM Cloth AS m ORDER BY m.id DESC"
    ),
    @NamedQuery(
            name = "getClothesCount",
            query = "SELECT COUNT(m) FROM Cloth AS m"
    )
})
@Table(name = "clothes")
public class Cloth {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", length = 255, nullable = true)
    private String title;

    @Column(name = "hat", length = 255, nullable = false)
    private String hat;

    @Column(name = "tops", length = 255, nullable = false)
    private String tops;

    @Column(name = "outerWear", length = 255, nullable = false)
    private String outerWear;

    @Column(name = "pants", length = 255, nullable = false)
    private String pants;

    @Column(name = "socks", length = 255, nullable = false)
    private String socks;

    @Column(name = "shoes", length = 255, nullable = false)
    private String shoes;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }

    public String getTops() {
        return tops;
    }

    public void setTops(String tops) {
        this.tops = tops;
    }

    public String getOuterWear() {
        return outerWear;
    }

    public void setOuterWear(String outerWear) {
        this.outerWear = outerWear;
    }

    public String getPants() {
        return pants;
    }

    public void setPants(String pants) {
        this.pants = pants;
    }


    public String getSocks() {
        return socks;
    }

    public void setSocks(String socks) {
        this.socks = socks;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}