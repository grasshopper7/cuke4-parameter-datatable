package stepdef;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import dataobject.FullName;
import dataobject.Lecture;
import dataobject.LectureLite;
import dataobject.Lectures;
import dataobject.Money;
import dataobject.ProfLevels;
import dataobject.Professor;
import dataobject.ProfessorNoArg;
import dataobject.User;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableCellTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;
import io.cucumber.datatable.TableRowTransformer;
import io.cucumber.datatable.TableTransformer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

public class Configurer implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {

		JacksonTableTransformer jacksonTableTransformer = new JacksonTableTransformer();
		registry.setDefaultParameterTransformer(jacksonTableTransformer);
		registry.setDefaultDataTableEntryTransformer(jacksonTableTransformer);
		registry.setDefaultDataTableCellTransformer(jacksonTableTransformer);

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

		registry.defineParameterType(new ParameterType<>("currency", "(.) main currency ([\\d]+) fractional currency ([\\d]+)",
				Money.class, (String[] args) -> new Money(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]))));

		registry.defineDataTableType(new DataTableType(Professor.class, new TableCellTransformer<Professor>() {
			@Override
			public Professor transform(String cell) throws Throwable {
				return new Professor(cell);
			}
		}));

		registry.defineDataTableType(new DataTableType(ProfLevels.class, new TableCellTransformer<ProfLevels>() {
			@Override
			public ProfLevels transform(String cell) throws Throwable {
				return ProfLevels.valueOf(cell.toUpperCase());
			}
		}));

		registry.defineDataTableType(new DataTableType(LectureLite.class, new TableRowTransformer<LectureLite>() {
			@Override
			public LectureLite transform(List<String> row) throws Throwable {
				return LectureLite.createLectureLite(row);
			}
		}));

		registry.defineDataTableType(new DataTableType(Lectures.class, new TableTransformer<Lectures>() {
			@Override
			public Lectures transform(DataTable table) throws Throwable {
				List<Lecture> lects = table.asMaps().stream().map(m -> Lecture.createLecture(m))
						.collect(Collectors.toList());
				return new Lectures(lects);
			}
		}));

	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	private static final class JacksonTableTransformer
			implements ParameterByTypeTransformer, TableEntryByTypeTransformer, TableCellByTypeTransformer {

		private final ObjectMapper objectMapper = new ObjectMapper();

		@Override
		public Object transform(String s, Type type) {
			return objectMapper.convertValue(s, objectMapper.constructType(type));
		}

		@Override
		public <T> T transform(Map<String, String> entry, Class<T> type, TableCellByTypeTransformer cellTransformer) {
			return objectMapper.convertValue(entry, type);
		}

		@Override
		public <T> T transform(String value, Class<T> cellType) {
			return objectMapper.convertValue(value, cellType);
		}
	}
}
