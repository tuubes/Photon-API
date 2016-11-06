package org.mcphoton.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author TheElectronWill
 */
public class ConfigSpecification {

	protected final Map<String, ValueSpecification> map = new HashMap<>();

	public ConfigSpecification() {}

	public static final class ValueSpecification {

		private final Object defaultValue;
		private final Function<Object, Boolean> validator;

		public ValueSpecification(Object defaultValue, Function<Object, Boolean> validator) {
			Objects.requireNonNull(validator, "ValueSpecification's validator must not be null.");
			Objects.requireNonNull(validator, "ValueSpecification's defaultValue must not be null.");
			this.defaultValue = defaultValue;
			this.validator = validator;
		}

		public Object getDefaultValue() {
			return defaultValue;
		}

		public Function<Object, Boolean> getValidator() {
			return validator;
		}
	}
}
