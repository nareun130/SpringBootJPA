package jpabook.jpashoop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable//* 값타입 -> 어딘가 내장 될 수 있다.
@Getter
public class Address {
    private String city;
    private String street;
    private String address;

    protected Address(){
        
    }
    public Address(String city, String street, String address) {    
        this.city = city;
        this.street = street;
        this.address = address;
    }
}
