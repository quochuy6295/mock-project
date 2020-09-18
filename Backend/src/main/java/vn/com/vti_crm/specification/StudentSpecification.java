package vn.com.vti_crm.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

//@SuppressWarnings("serial")
public class StudentSpecification<T> implements Specification<T> {

	private static final long serialVersionUID = 1L;
	private SearchCriteria criteria;

	public StudentSpecification(SearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		if (criteria.getOperator().equalsIgnoreCase("~")) {
			return criteriaBuilder.like(root.get(criteria.getKey()), criteria.getValue().toString());
		}
		if (criteria.getOperator().equalsIgnoreCase(":")) {
			return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue().toString());
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private Path parseAttribute(String nameField, Root<T> root) {

		// nameField = department.id
		String[] fields = nameField.split("\\.");

		Path path = root.get(fields[0]);

		for (int i = 1; i < fields.length; i++) {
			path = path.get(fields[i]);
		}

		return path;
	}

}
