package vn.com.vti_crm.specification;

public class SearchCriteria {
	private String key;

	private String operator;

	private Object value;

	private boolean isOrPredicate;

	public SearchCriteria(String key, String operator, Object value) {
		this.key = key;
		this.operator = operator;
		this.value = value;
	}

	public SearchCriteria(String key, String operator, Object value, boolean isOrPredicate) {
		this.key = key;
		this.operator = operator;
		this.value = value;
		this.isOrPredicate = isOrPredicate;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public SearchCriteria() {
	}

	public boolean isOrPredicate() {
		return isOrPredicate;
	}

	public void setOrPredicate(boolean isOrPredicate) {
		this.isOrPredicate = isOrPredicate;
	}

}
