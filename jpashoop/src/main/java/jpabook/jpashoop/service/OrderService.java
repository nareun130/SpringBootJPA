package jpabook.jpashoop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashoop.domain.Delivery;
import jpabook.jpashoop.domain.Member;
import jpabook.jpashoop.domain.Order;
import jpabook.jpashoop.domain.OrderItem;
import jpabook.jpashoop.domain.item.Item;
import jpabook.jpashoop.repository.ItemRepository;
import jpabook.jpashoop.repository.MemberRepository;
import jpabook.jpashoop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        //엔티티 조회
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송 정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        // //! 안 좋은 방식! 
        // OrderItem orderItem1 = new OrderItem();
        // orderItem1.setCount(3); 

        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);

        return order.getId();
    }
    /**
     * 주문 취소
    */
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        //! JPA의 강점 : Dirty Checking을 통해 DB 업데이트를 일으킴!!
        order.cancel();
    }

    /**
     * 검색
     */
    // public List<Order> findOrders(OrderSearch orderSearch) {   
    //     return orderRepository.findAll(orderSearch)
    // }

}
