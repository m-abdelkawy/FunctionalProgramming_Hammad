package session2pipelineconcept;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MainApp {
	private static List<Double> myData = new ArrayList<Double>(Arrays.asList(7d, 4d, 5d, 6d, 3d, 8d, 10d));

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Imperative
		/*
		 * System.out.println("Imperative way of doing things"); for (double x : myData)
		 * { System.out.println(String.format("%.0f", subtractTen(square(addOne(x)))));
		 * }
		 */

		// declarative
		System.out.println("Declarative way of doing things");
		myData.stream().map(MainApp::addOne).map(MainApp::square).filter(v -> v < 70)
				.sorted(Comparator.comparingDouble(v -> v))
				.limit(2)
				.map(MainApp::subtractTen).collect(Collectors.toList())
				.forEach(v -> {
					System.out.println(String.format("%.0f", v));
				});

	}

	static double subtractTen(double x) {
		return x - 10;
	}

	static double square(double x) {
		return Math.pow(x, 2);
	}

	static double addOne(double x) {
		return x + 1;
	}
}
