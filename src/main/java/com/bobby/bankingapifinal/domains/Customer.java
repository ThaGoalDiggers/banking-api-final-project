package com.bobby.bankingapifinal.domains;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;


//Class Completed
@Entity
public class Customer {

    @Id
   @GeneratedValue
   @Column(name="CUSTOMER_ID")
    private Long id;

   @Column(name="FIRST_NAME")
    @NotEmpty
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotEmpty
    private String lastName;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Set<Address> address;

    public Customer(){}

    public Customer( String firstName, String lastName, Set<Address> address) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
