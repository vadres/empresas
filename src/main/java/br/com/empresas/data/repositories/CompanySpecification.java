package br.com.empresas.data.repositories;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.empresas.data.entities.model.Company;

public class CompanySpecification implements Specification<Company> {
	private static final long serialVersionUID = 1L;
	private final Company criteria;

    public CompanySpecification(Company criteria) {
        this.criteria = criteria;
    }
    
	@Override
	public Predicate toPredicate(Root<Company> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		var predicates = new ArrayList<Predicate>();
		
		if (criteria.getName() != null) {
			predicates.add(criteriaBuilder.like(root.get("name"), "%" + criteria.getName() + "%"));
		}
		
		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

}
