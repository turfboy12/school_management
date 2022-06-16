/*
 * Address Entity
 * Author: Muembo Ilunga Michel (218303335)
 * Date: 15 June 2022
 */
package za.ac.cput.schoolmanagement.domain;

import com.sun.istack.NotNull;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @NotNull
    @Id
    private String unitNumber;

    @NotNull
    private String complexName, streetNumber, streetName;

    private int postCode;

    @Embedded
    @NotNull
    private City city;

    protected Address(){}

    public Address(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postCode = builder.postCode;
    }


    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostCode() {
        return postCode;
    }

    public City getCity() {
        return city;
    }


    public static class Builder{

        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private int postCode;


        public Address.Builder setUnitNumber(String unitNumber){
            this.unitNumber = unitNumber;
            return this;
        }

        public Address.Builder setComplexName(String complexName){
            this.complexName = complexName;
            return this;
        }

        public Address.Builder setStreetNumber(String streetNumber){
            this.streetNumber = streetNumber;
            return this;
        }

        public Address.Builder setStreetName(String streetName){
            this.streetName = streetName;
            return this;
        }

        public Address.Builder setPostCode(int postCode){
            this.postCode = postCode;
            return this;
        }


        public Builder copy(Address address) {
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postCode = address.postCode;

            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }


    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postCode=" + postCode +
                ", city=" + city +
                '}';
    }
}
