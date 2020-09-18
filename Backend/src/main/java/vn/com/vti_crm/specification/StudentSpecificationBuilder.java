package vn.com.vti_crm.specification;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import vn.com.vti_crm.util.Config;

public class StudentSpecificationBuilder<T> {

	private List<SearchCriteria> searchCriterias;

	public StudentSpecificationBuilder(String search) throws ParseException {
		searchCriterias = new ArrayList<>();
		parseRegex(search);
	}

	private StudentSpecificationBuilder<T> with(String key, String operator, Object value, boolean isOrPredicate) {
		searchCriterias.add(new SearchCriteria(key, operator, value, isOrPredicate));
		return this;
	}

	@SuppressWarnings("unused")
	private StudentSpecificationBuilder<T> with(SearchCriteria searchcriteria) {
		searchCriterias.add(searchcriteria);
		return this;
	}

	private void parseRegex(String search) throws ParseException {

		if (StringUtils.isEmpty(search)) {
			return;
		}

		Pattern pattern = Pattern.compile(Config.REGEX_SEARCH);
		Matcher matcher = pattern.matcher(search);

		while (matcher.find()) {
			with(matcher.group(1), matcher.group(2), matcher.group(4), false);
		}
//			String key = matcher.group(1);
//			String operator = matcher.group(2);
//			String value = matcher.group(4);
//
//			// Like prefix
//
//			String prefixWildcard = matcher.group(3);
//			if (StringUtils.isEmpty(prefixWildcard) && operator.equals("~")) {
//				value = "%" + value;
//			}
//
//			String endfixWildcard = matcher.group(5);
//			if (StringUtils.isEmpty(endfixWildcard) && operator.equals("~")) {
//				value = value + "%";
//			} else {
//				with(key, operator, value, false);
//			}
//		}
	}

	public Specification<T> build() {

		if (searchCriterias.size() == 0) {
			return null;
		}

		Specification<T> specification = new StudentSpecification<T>(searchCriterias.get(0));

		for (int i = 1; i < searchCriterias.size(); i++) {

			specification = searchCriterias.get(i).isOrPredicate()
					? Specification.where(specification).or(new StudentSpecification<T>(searchCriterias.get(i)))
					: Specification.where(specification).and(new StudentSpecification<T>(searchCriterias.get(i)));
		}

		return specification;
	}
}
