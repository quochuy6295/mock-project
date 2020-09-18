package vn.com.vti_crm.util;

public class Config {

	private static final String REGEX_GROUP_KEY = "(\\w+.*\\w+)";

	private static final String REGEX_GROUP_OPERATOR = "(>=|<=|:|!=|>|<|~)";

	private static final String REGEX_ALPHANUMBERICAL_VALUE = "(\\w+.*\\w+)";

	private static final String REGEX_GROUP_WILDCARD = "(\\*?)";

	public static final String REGEX_SEARCH = REGEX_GROUP_KEY + REGEX_GROUP_OPERATOR + REGEX_GROUP_WILDCARD
			+ REGEX_ALPHANUMBERICAL_VALUE + REGEX_GROUP_WILDCARD;

}
