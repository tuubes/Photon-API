package org.mcphoton.config;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConfigurationSpecification {
	
	protected final Map<String, KeySpecification> map = new ConcurrentHashMap<>();
	
	public ConfigurationSpecification() {}
	
	public ConfigurationSpecification(Configuration model) {
		model.forEach((key, value) -> {
			this.define(key, value);
		});
	}
	
	public Map<String, KeySpecification> asMap() {
		return map;
	}
	
	public boolean isDefined(String key) {
		return map.containsKey(key);
	}
	
	public boolean isValid(String key, Object value) {
		KeySpecification spec = map.get(key);
		return spec != null && spec.validator.apply(value);
	}
	
	public Optional<KeySpecification> getSpecification(String key) {
		return Optional.ofNullable(map.get(key));
	}
	
	public Optional<Object> getDefaultValue(String key) {
		KeySpecification vs = map.get(key);
		return vs == null ? Optional.empty() : Optional.ofNullable(vs.defaultValue);
	}
	
	public Optional<Function<Object, Boolean>> getValidator(String key) {
		KeySpecification vs = map.get(key);
		return vs == null ? Optional.empty() : Optional.of(vs.validator);
	}
	
	public void define(String key, Object defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v != null && defaultValue.getClass().isAssignableFrom(v.getClass())));
	}
	
	public void defineBoolean(String key, boolean defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v instanceof Boolean));
	}
	
	public void defineString(String key, String defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v instanceof String));
	}
	
	public void defineString(String key, String defaultValue, String... possibleValues) {
		map.put(key, new KeySpecification(defaultValue, (v) -> {
			if (!(v instanceof String))
				return false;
			for (String s : possibleValues) {
				if (s.equals(v))
					return true;
			}
			return false;
		}));
	}
	
	public void defineInt(String key, int defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v instanceof Integer));
	}
	
	public void defineInt(String key, int defaultValue, int min, int max) {
		map.put(key, new KeySpecification(defaultValue, (v) -> {
			if (!(v instanceof Integer))
				return false;
			int i = (int) v;
			return min <= i && max >= i;
		}));
	}
	
	public void defineLong(String key, long defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v instanceof Long));
	}
	
	public void defineLong(String key, long defaultValue, long min, long max) {
		map.put(key, new KeySpecification(defaultValue, (v) -> {
			if (!(v instanceof Long))
				return false;
			long l = (long) v;
			return min <= l && max >= l;
		}));
	}
	
	public void defineDouble(String key, double defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v instanceof Double));
	}
	
	public void defineDouble(String key, double defaultValue, double min, double max) {
		map.put(key, new KeySpecification(defaultValue, (v) -> {
			if (!(v instanceof Double))
				return false;
			double d = (double) v;
			return min <= d && max >= d;
		}));
	}
	
	public void defineList(String key, List<?> defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v instanceof List));
	}
	
	public void defineTable(String key, Configuration defaultValue) {
		map.put(key, new KeySpecification(defaultValue, (v) -> v instanceof Configuration));
	}
	
	public void define(String key, KeySpecification spec) {
		map.put(key, spec);
	}
	
	public void define(String key, Object defaultValue, Function<Object, Boolean> validator) {
		map.put(key, new KeySpecification(defaultValue, validator));
	}
	
	public void undefine(String key) {
		map.remove(key);
	}
	
	public class KeySpecification {
		public Object defaultValue;
		public Function<Object, Boolean> validator;
		
		public KeySpecification(Object defaultValue, Function<Object, Boolean> validator) {
			Objects.requireNonNull(validator, "KeySpecification's validator may not be null");
			Objects.requireNonNull(validator, "KeySpecification's defaultValue may not be null");
			this.defaultValue = defaultValue;
			this.validator = validator;
		}
		
	}
	
}
