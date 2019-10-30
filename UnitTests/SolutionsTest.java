package com.problems.CodeWarsSolutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("When running CodeWars ")
class SolutionsTest {
	List<int[]> bsList;
	BusStop busStop;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void init() throws Exception {
		busStop = new BusStop();
		int[] a = new int[2];
		int[] b = new int[2];
		int[] c = new int[2];
		bsList = Arrays.asList(a, b, c);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("The method for the number of people left on bus.")
	class GetPeopleOnBusTest {
		@Test
		@DisplayName("Tests for zero people getting on and off")
		void Zeros() {
			for (int i = 0; i < bsList.size(); i++) {
				bsList.set(i, new int[] { 0, 0 });
			} // Initialise list of 2 element arrays to zeros.
			assertEquals(0, busStop.getPeopleOnBus(bsList), "Should return 0 people.");
		}

		@Test
		@DisplayName("Tests for a positive number of people left on the bus")
		void GreaterThanZero() {
			bsList.set(0, new int[] { 10, 0 });
			bsList.set(1, new int[] { 5, 2 });
			bsList.set(2, new int[] { 0, 8 });
			assertEquals(5, busStop.getPeopleOnBus(bsList), "Should return 5 people.");
		}

	}
}
