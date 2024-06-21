package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
	
	@PersistenceContext
	private final EntityManager em;
	
	public void save(Member member) {
        em.persist(member);
    }
	
	public Member find(String id) {
		return em.find(Member.class, id);
	}
	
	
	public List<Member> findById(String id) {
        return em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id)
                .getResultList();
    }

	
	public void deleteById(String id) {
		Member member = this.find(id);
		if(member != null) {
			em.remove(member);
		}
	}
}
