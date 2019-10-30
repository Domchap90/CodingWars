package com.problems.CodeWarsSolutions;

import java.util.Arrays;
import java.util.List;

public class BusStop {

	public int getPeopleOnBus(List<int[]> list) {
		int sum = 0;
		for (int[] array : list) {
			for (int i = 0; i < 2; i++) {
				if (i == 1) {
					sum -= array[i];
				} else {
					sum += array[i];
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		List<int[]> busStopList = Arrays.asList(new int[] { 10, 0 }, new int[] { 6, 2 }, new int[] { 8, 5 });
		System.out.println(new BusStop().getPeopleOnBus(busStopList));

		// List<Array> busList = new ArrayList<Array>(
		// Arrays.asList({{10,0},{6,2},{8,5}}));//arrays take two numbers first denotes
		// people getting on the bus, second people getting off

	}

}
