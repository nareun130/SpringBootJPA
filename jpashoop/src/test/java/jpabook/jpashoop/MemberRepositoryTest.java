package jpabook.jpashoop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    //? 에러가 왜 날까??? -> transaction이 일어나지 않아서 -> @Transactional필요!~!
    //! EntityManager를 통한 모든 data변경은 항상 transaction안에서 이뤄져야 한다!
    @Test
    @Transactional//~> @Test안에서 @Transactional은 데이터를 롤백 시킨다!
    @Rollback(false)
    public void testMember() throws Exception { 
        // given
        Member member = new Member();
        member.setUsername("memberA");
        // when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);
        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        // hashcode와 equals 구현 하지 않아 == 비교 됨.
        System.out.println("findMember == member: " + (findMember == member));
        Assertions.assertThat(findMember).isEqualTo(member);// !true -> 같은 트랜잭션(영속성 컨텍스트)안에서 id 동일 -> 같은 엔티티

    }
}
