package org.mcphoton.config;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/**
 * @author TheElectronWill
 */
public class ConfigSpecification {

	protected final Map<String, ValueSpecification> map = new HashMap<>();

	public ConfigSpecification() {}

	/**
	 * Defines a specification for the given path. The validator associated with the path will check if
	 * the actual value is of the same type as, or a subtype of, defaultValue's type.
	 *
	 * @param path         the path.
	 * @param defaultValue the default value.
	 */
	public void defineValue(String path, Object defaultValue) {
		defineValue(path, defaultValue, (v) -> defaultValue.getClass().isAssignableFrom(v.getClass()));
	}

	/**
	 * Defines a specification for the given path, with the given default value and validator.
	 *
	 * @param path         the path.
	 * @param defaultValue the default value.
	 * @param validator    the validator that whill check if the actual path's value is correct.
	 */
	public void defineValue(String path, Object defaultValue, Predicate<Object> validator) {
		ValueSpecification spec = new ValueSpecification(defaultValue, validator);
		map.put(path, spec);
	}

	/**
	 * Defines a specification for the given path, with an acceptable class The validator associated with
	 * the path will check if the actual value is of the same type as, or a subtype of,
	 * {@code acceptableClass}.
	 *
	 * @param path            the path.
	 * @param defaultValue    the default value.
	 * @param acceptableClass the class that will be accepted by the validator.
	 * @param <T>             the type of the default value.
	 */
	public <T> void defineValue(String path, T defaultValue, Class<? super T> acceptableClass) {
		defineValue(path, defaultValue, (v) -> acceptableClass.isAssignableFrom(v.getClass()));
	}

	/**
	 * Defines a specification for the given path, with an array of acceptable values. The validator
	 * associated with the path will check if the actual value is contained into the {@code acceptableValues}.
	 *
	 * @param path             the path.
	 * @param defaultValue     the default value.
	 * @param acceptableValues all the acceptable values. Must contains the default value.
	 */
	public void defineString(String path, String defaultValue, String... acceptableValues) {
		defineString(path, defaultValue, Arrays.asList(acceptableValues));
	}

	/**
	 * Defines a specification for the given path, with an array of acceptable values. The validator
	 * associated with the path will check if the actual value is a String and is contained into the {@code
	 * acceptableValues}.
	 *
	 * @param path             the path.
	 * @param defaultValue     the default value.
	 * @param acceptableValues all the acceptable values. Must contains the default value.
	 */
	public void defineString(String path, String defaultValue, Collection<String> acceptableValues) {
		defineValue(path, defaultValue, acceptableValues::contains);
	}

	/**
	 * Defines a specification for the given path, with a regular expression. The validator associated
	 * with the path will check if the actual value is a String and matches the {@code regexToMatch}.
	 *
	 * @param path         the path.
	 * @param defaultValue the default value.
	 * @param regexToMatch the regular expression that the actual value has to match to be valid.
	 */
	public void defineString(String path, String defaultValue, String regexToMatch) {
		defineValue(path, defaultValue, (v) -> (v instanceof String) && ((String)v).matches(regexToMatch));
	}

	/**
	 * Defines a specification for the given path, with a minimum and a maximum.
	 *
	 * @param path         the path.
	 * @param defaultValue the default value.
	 * @param min          the smallest acceptable value.
	 * @param max          the biggest acceptable value.
	 */
	public void defineInt(String path, int defaultValue, int min, int max) {
		defineValue(path, defaultValue, (v) -> (v instanceof Integer) && ((int)v) >= min && ((int)v) <= max);
	}

	/**
	 * Defines a specification for the given path, with a minimum and a maximum.
	 *
	 * @param path         the path.
	 * @param defaultValue the default value.
	 * @param min          the smallest acceptable value.
	 * @param max          the biggest acceptable value.
	 */
	public void defineLong(String path, long defaultValue, long min, long max) {
		defineValue(path, defaultValue, (v) -> (v instanceof Long) && ((long)v) >= min && ((long)v) <= max);
	}

	/**
	 * Defines a specification for the given path, with a minimum and a maximum.
	 *
	 * @param path         the path.
	 * @param defaultValue the default value.
	 * @param min          the smallest acceptable value.
	 * @param max          the biggest acceptable value.
	 */
	public void defineFloat(String path, float defaultValue, float min, float max) {
		defineValue(path, defaultValue, (v) -> (v instanceof Float) && ((float)v) >= min && ((float)v) <= max);
	}

	/**
	 * Defines a specification for the given path, with a minimum and a maximum.
	 *
	 * @param path         the path.
	 * @param defaultValue the default value.
	 * @param min          the smallest acceptable value.
	 * @param max          the biggest acceptable value.
	 */
	public void defineDouble(String path, double defaultValue, double min, double max) {
		defineValue(path, defaultValue, (v) -> (v instanceof Double) && ((double)v) >= min && ((double)v) <= max);
	}

	/**
	 * Defines a specification for the given path, with a {@code Predicate} that checks every value of the
	 * list.
	 *
	 * @param path               the path.
	 * @param defaultValue       the default value.
	 * @param listValueValidator the validator that checks if every value of the list is correct. It
	 *                           returns {@code true} if the value is correct, {@code false} if it isn't.
	 * @param <T>                the type of the list.
	 */
	public <T> void defineList(String path, List<T> defaultValue, Predicate<? super T> listValueValidator) {
		defineValue(path, defaultValue, (v) -> {
			if (v instanceof List) {
				List<T> list = (List)v;
				for (T element : list) {
					if (!listValueValidator.test(element))
						return false;
				}
				return true;
			}
			return false;
		});
	}

	/**
	 * Deletes the specification of the given path, if any. If the path has no specification, this method
	 * does nothing.
	 *
	 * @param path the path.
	 */
	public void undefine(String path) {
		map.remove(path);
	}

	/**
	 * Checks if a specification has been defined for the given path.
	 *
	 * @param path the path to check.
	 * @return {@code true} if a specification has been defined for this path, else {@code false}.
	 */
	public boolean isDefined(String path) {
		return map.containsKey(path);
	}

	/**
	 * Checks if the given value is acceptable for the given path.
	 *
	 * @param path  the path.
	 * @param value the value to check.
	 * @return {@code true} if it is acceptable, {@code false} if it isn't.
	 */
	public boolean check(String path, Object value) {
		ValueSpecification spec = map.get(path);
		if (spec == null) {
			return false;
		} else {
			return spec.validator.test(value);
		}
	}

	/**
	 * Checks if the given config complies with this specification.
	 *
	 * @param config the config to check.
	 * @return {@code true} if the config is correct, {@code false} if it isn't.
	 */
	public boolean check(Config config) {
		//TODO
	}

	/**
	 * Checks if the given config complies with this specification. Calls the {@code rejectedValueConsumer}
	 * for each config value that does not complies with this specification.
	 *
	 * @param config                the config to check.
	 * @param rejectedValueConsumer the consumer to use for each incorrect config value.
	 * @return {@code true} if the config is correct, {@code false} if it isn't.
	 */
	public boolean check(Config config, BiConsumer<String, Object> rejectedValueConsumer) {
		//TODO
	}

	/**
	 * Corrects the given config so that it complies with this specification. Any value that is specified
	 * but does not exist in the config is added to it. Any value that is not specified but does exist
	 * in the config is removed from it. Any value that is specified, that exists in the config,
	 * but that is incorrect (that doesn't complies to its specification) is replaced by the default value
	 * defined in this specification.
	 *
	 * @param config the config to correct.
	 * @return the number of corrected values.
	 */
	public int correct(Config config) {
		return correct(config, (p, iv, cv) -> {});
	}

	/**
	 * Corrects the given config so that it complies with this spefication. Call the {@code
	 * correctedValueAction} for each config value that is corrected, added or removed.
	 *
	 * @param config               the config to correct.
	 * @param correctedValueAction the action to do for each corrected config value.
	 * @return the number of corrected values.
	 */
	public int correct(Config config, CorrectionReaction correctedValueAction) {
		//TODO
	}

	@FunctionalInterface
	public interface CorrectionReaction {
		/**
		 * Reacts to the correction of a config value.
		 *
		 * @param path           the path of the value.
		 * @param incorrectValue the old, incorrect value. May be null if the value didn't exist before the
		 *                       correction.
		 * @param correctedValue the new, corrected value. May be null if the value has been removed by the
		 *                       correction.
		 */
		void onCorrect(String path, Object incorrectValue, Object correctedValue);
	}

	/**
	 * Defines a specification for a particular value.
	 */
	private static class ValueSpecification {

		private final Object defaultValue;
		private final Predicate<Object> validator;

		ValueSpecification(Object defaultValue, Predicate<Object> validator) {
			Objects.requireNonNull(validator, "The validator must not be null.");
			this.defaultValue = defaultValue;
			this.validator = validator;
		}
	}
}
