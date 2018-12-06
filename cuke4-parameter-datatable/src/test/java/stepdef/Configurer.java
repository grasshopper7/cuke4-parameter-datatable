package stepdef;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import dataobject.FullName;
import dataobject.Money;
import dataobject.ProfessorNoArg;
import dataobject.User;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

public class Configurer implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {

		registry.defineParameterType(
				new ParameterType<>("names", ".*?", List.class, (String s) -> Arrays.asList(s.split(","))));

		registry.defineParameterType(new ParameterType<>("users", ".*?", List.class,
				(String s) -> Arrays.asList(s.split(",")).stream().map(User::new).collect(Collectors.toList())));

		registry.defineParameterType(new ParameterType<>("date_iso_local_date_time", // 2011-12-03T10:15:30
				"\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}", LocalDateTime.class,
				(String s) -> LocalDateTime.parse(s)));

		registry.defineParameterType(
				new ParameterType<>("fullname", ".*?", FullName.class, FullName::parseNameDetails));

		registry.defineParameterType(new ParameterType<>("amount", ".*?", Money.class, Money::parseMoneyDetails));

		registry.defineParameterType(
				new ParameterType<>("professor", ".*?", ProfessorNoArg.class, ProfessorNoArg::parseProfessor));

		JacksonTableTransformer jacksonTableTransformer = new JacksonTableTransformer();
		registry.setDefaultParameterTransformer(jacksonTableTransformer);
	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	private static final class JacksonTableTransformer implements ParameterByTypeTransformer {

		private final ObjectMapper objectMapper = new ObjectMapper();

		@Override
		public Object transform(String s, Type type) {
			return objectMapper.convertValue(s, objectMapper.constructType(type));
		}
	}
}
