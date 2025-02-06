package jpabook.jpashoop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jpabook.jpashoop.domain.Address;
import jpabook.jpashoop.domain.Member;
import jpabook.jpashoop.domain.Order;
import jpabook.jpashoop.domain.OrderStatus;
import jpabook.jpashoop.domain.item.Book;
import jpabook.jpashoop.domain.item.Item;
import jpabook.jpashoop.repository.OrderRepository;

@SpringBootTest
@Transactional
// * 좋은 테스트는 Dependency없이 단위 테스트만 하는 것!!
public class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {
        // given
        Member member = new Member();
        member.setName("회원1");
        member.setAddress(new Address("서울", "종로", "123-123"));
        em.persist(member);

        Book book = new Book();
        book.setName("도시 JPA");
        book.setPrice(10000);
        book.setStockQuantity(10);
        // when
        int orderCount = 2;
        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);
        // then
        Order getOrder = orderRepository.findOne(orderId);

        // assertEquals(OrderStatus.ORDER, getOrder.getStatus());
    }

    @Test
    public void 주문취소() throws Exception {
        // given

        // when

        // then
    }

    @Test
    public void 상품주문_재고수량초과() throws Exception {
        // given

        // when

        // then
    }
}
