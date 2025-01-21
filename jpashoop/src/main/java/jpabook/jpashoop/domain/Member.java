package jpabook.jpashoop.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter //* Setter는 정말 필요한 경우에만 따로 생성하도록!!
public class Member {
    
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //* order테이블의 member필드에 의해 매핑됨.
    private List<Order> orders = new ArrayList<>();


}
