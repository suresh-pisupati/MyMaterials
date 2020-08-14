package builderpattern;

public class MainBuilderPattern {

	public static void main(String[] args) {

		Technology team1 = new Technology.TechnologyBuilder("Java Developer", "Python Developer")
				.angularJSBuilder("Angular JS Developer").buildTechnology();
		System.out.println(team1.toString());

		Technology team2 = new Technology.TechnologyBuilder("Java Developer", "Python Developer")
				.reactJSBuilder("React JS Developer").buildTechnology();
		System.out.println(team2.toString());
	}

}
