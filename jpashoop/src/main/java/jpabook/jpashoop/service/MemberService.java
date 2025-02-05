package jpabook.jpashoop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jpabook.jpashoop.domain.Member;
import jpabook.jpashoop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@Service
//* JPA안의 모든 데이터 변경 로직은 트랜잭션 안에서 실행 되어야 한다.
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    
    // 회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);// 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    //! 실무에서는 멀티 스레드 고려 해서 Member테이블의 name을 unique 제약조건을 걸어줄 필요!
    private void validateDuplicateMember(Member member) {
        // Exception
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
