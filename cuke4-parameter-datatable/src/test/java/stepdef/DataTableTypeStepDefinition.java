package stepdef;

import java.util.List;
import java.util.Map;

import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import dataobject.Lecture;
import dataobject.LectureId;
import dataobject.LectureLite;
import dataobject.LecturePrimitive;
import dataobject.LecturePrimitiveEnum;
import dataobject.LectureSimple;
import dataobject.Lectures;
import dataobject.ProfLevels;
import dataobject.Professor;;

public class DataTableTypeStepDefinition {

	@Given("the list string lecture details are")
	public void theListStringLectureDetailsAre(List<List<String>> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}

	@Given("the list primitive lecture details are")
	public void thePrimitiveLectureDetailsAre(List<LecturePrimitive> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}

	@Given("the list primitive enum lecture details are")
	public void thePrimitiveEnumLectureDetailsAre(List<LecturePrimitiveEnum> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}
	
	@Given("the list simple lecture object details are")
	public void theSimpleLectureObjectDetailsAre(List<LectureSimple> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}

	@Given("the list lecture details are")
	public void theLectureDetailsAre(List<Lecture> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}

	@Given("^switch the list lecture details are$")
	public void switchTheLectureDetailsAre(@Transpose List<Lecture> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}
	
	@Given("the list no header lecture details are")
	public void theListNoHeaderLectureDetailsAre(List<LectureLite> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}
	
	@Given("the map primitive key value")
	public void theMapPrimitiveKeyValue(Map<String,String> profs) {
		System.out.println("");
		System.out.println(profs);
	}

	@Given("the map object key value")
	public void theMapObjectKeyValue(Map<Professor,ProfLevels> profs) {
		System.out.println("");
		System.out.println(profs);
	}
	
	@Given("the map primitive key lecture details are")
	public void theMapPrimitiveKey(Map<String,Lecture> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}

	@Given("the map lecture details are")
	public void theMapLectureDetailsAre(Map<LectureId, Lecture> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}

	@Given("switch the map lecture details are")
	public void switchTheMapLectureDetailsAre(@Transpose Map<LectureId, Lecture> lectures) {
		System.out.println("");
		System.out.println(lectures);
	}

	@Given("all lectures details")
	public void allLecturesDetails(Lectures lectures) {
		System.out.println("");
		System.out.println(lectures);
	}
}
