package jpabook.jpashoop;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    // * Spring Boot가 설정값을 읽어서 EntityManager를 자동으로 생성해줌.
    @PersistenceContext
    private EntityManager em;

    // ! 저장을 하고 나면 웬만하면 리턴값을 만들지 않는다. -> 대신 Id가 있으면 조회가 가능!!
    // SideEffect가 일어날 수 있어서
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
