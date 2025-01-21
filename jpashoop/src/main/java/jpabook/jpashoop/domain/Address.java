package jpabook.jpashoop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable//* 값타입
@Getter
public class Address {
    private String city;
    private String street;
    private String address;
}
