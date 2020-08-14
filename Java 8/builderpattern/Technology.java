package builderpattern;

public class Technology {

	private final String java;
	private final String devops;
	private final String reactJS;
	private final String angularJS;
	private final String python;

	/**
	 * The constructor which takes static inner class object as parameter and
	 * assigns the values from the builder class to the variables declared in this
	 * class
	 * 
	 * @param technologyBuilder
	 */
	public Technology(TechnologyBuilder technologyBuilder) {

		this.java = technologyBuilder.java;
		this.devops = technologyBuilder.devops;
		this.reactJS = technologyBuilder.reactJS;
		this.angularJS = technologyBuilder.angularJS;
		this.python = technologyBuilder.python;
	}

	public String getJava() {
		return java;
	}

	public String getDevops() {
		return devops;
	}

	public String getReactJS() {
		return reactJS;
	}

	public String getAngularJS() {
		return angularJS;
	}

	public String getPython() {
		return python;
	}

	@Override
	public String toString() {
		return "Techology [java=" + java + ", devops=" + devops + ", reactJS=" + reactJS + ", angularJS=" + angularJS
				+ ", python=" + python + "]";
	}

	/**
	 * This static class is responsible for building the required objects and
	 * passing to the parent class (Technology).
	 * 
	 * @author pksuresh
	 *
	 */
	static class TechnologyBuilder {

		private final String java;
		private String devops;
		private String reactJS;
		private String angularJS;
		private final String python;

		/**
		 * In this example java and python are considered as mandatory classes, hence
		 * the constructor with two parameters is created.
		 * 
		 * @param java
		 * @param python
		 */
		public TechnologyBuilder(String java, String python) {

			this.java = java;
			this.python = python;
		}

		public TechnologyBuilder devopsBuilder(String devops) {

			this.devops = devops;
			return this;
		}

		public TechnologyBuilder reactJSBuilder(String reactJS) {

			this.reactJS = reactJS;
			return this;
		}

		public TechnologyBuilder angularJSBuilder(String angularJS) {

			this.angularJS = angularJS;
			return this;
		}

		/**
		 * This method returns the Technology object by passing the static builder class
		 * object to the parent's class constructor
		 * 
		 * @return Technology class object
		 */
		public Technology buildTechnology() {

			Technology technology = new Technology(this);
			return technology;
		}
	}

}
