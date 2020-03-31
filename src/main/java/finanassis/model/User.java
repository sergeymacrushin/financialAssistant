package finanassis.model;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table (name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fname")
    private String fname;
/*
    @OneToMany
    private Set<Cost> cost;
/*
    @OneToMany
    private Set<Revenue> revenue;
*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
/*
    public Set<Cost> getCost() {
        return cost;
    }

    public void setCost(Set<Cost> cost) {
        this.cost = cost;
    }

   /* public Set<Revenue> getRevenue() {
        return revenue;
    }

    public void setRevenue(Set<Revenue> revenue) {
       this.revenue = revenue;
    }*/

    @Override
   public String toString()
    {
        return new StringBuilder().append(id).append(' ').append(fname).toString();
    }
}
