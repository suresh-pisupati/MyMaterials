import java.util.HashSet;
import java.util.Set;

/**
 * The significance of this class is to demonstrate the importance of equals()
 * and hashCode() methods of Object class by using HashSet class implementation.
 * <br>
 * {@code hashCode()} value of an object is used to locate the right bucket.
 * <br>
 * {@code equals(Object)} value is used to search right element from the bucket.
 * 
 * @author pksuresh
 *
 */
public class ImportanceOfHashCodeAndEqualsMethods {

	/**
	 * If we <b>do not</b> override hashCode and equals(Object), it will return
	 * violation of general contract for Object.hashCode(). <br>
	 * <li>Whenever hashCode is invoked on the same object nay number of times
	 * during the execution of program, it should return same integer.</li>
	 * <li>If two objects are equal according to equals(Object) then calling the
	 * hashCode on these objects should return the same value.</li>
	 * <li>It is <b>not required</b> if two objects are not equal according to
	 * equals(Object) then their hashCode must be different.</li>
	 * 
	 * Since we are not overriding hashCode and equals(Object) we will be
	 * getting two objects in the Set.
	 */
	public void withOutOverridingHashCodeAndEquals() {

		Set<Department> obj = new HashSet<>();
		Department department1 = new Department(1, "suresh");
		Department department2 = new Department(1, "suresh");

		obj.add(department1);
		obj.add(department2);

		// Size of the Set is 2
		System.out.println(obj.size());
	}

	/**
	 * Since we are overriding only equals(Object), calling add(department1)
	 * will add in some bucket location and calling add(department2) will add in
	 * some other bucket location. Because we are not overriding hashCode, we
	 * cannot find the correct bucket to get the correct value.
	 * 
	 * Hence this method will return size as 2.
	 */
	public void withOverridingOnlyEquals() {

		Set<Library> obj = new HashSet<>();
		Library library1 = new Library(1, "suresh");
		Library library2 = new Library(1, "suresh");

		obj.add(library1);
		obj.add(library2);

		// Size of the Set is 2
		System.out.println(obj.size());
	}

	/**
	 * Since we are not overriding equals(Object), calling add(college1) will
	 * generate a new hashcode and add(college2) will generate another hashcode.
	 * Adding the same key ideally should override the existing value but since
	 * we are not overriding equals(Object), it will not get the correct value
	 * and hence it will not override.
	 * 
	 * Hence this method will return size as 2
	 */
	public void withOverridingOnlyHashCode() {

		Set<College> obj = new HashSet<>();
		College college1 = new College(1, "suresh");
		College college2 = new College(1, "suresh");

		obj.add(college1);
		obj.add(college2);

		// Size of the Set is 2
		System.out.println(obj.size());
	}

	public void withOverridingEqualsAndHashCode() {

		Set<Company> obj = new HashSet<>();
		Company college1 = new Company(1, "suresh");
		Company college2 = new Company(1, "suresh");

		obj.add(college1);
		obj.add(college2);

		// Size of the Set is 1
		System.out.println(obj.size());
	}

	public static void main(String[] args) {

		ImportanceOfHashCodeAndEqualsMethods obj = new ImportanceOfHashCodeAndEqualsMethods();
		obj.withOutOverridingHashCodeAndEquals();
		obj.withOverridingOnlyEquals();
		obj.withOverridingOnlyHashCode();
		obj.withOverridingEqualsAndHashCode();
	}
}

class Department {

	private int departmentId;
	private String departmentName;

	public Department(int departmentId, String departmentName) {

		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
}

class Library {

	private int bookId;
	private String bookName;

	public Library(int bookId, String bookName) {

		this.bookId = bookId;
		this.bookName = bookName;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Library library = (Library) obj;
		return this.bookId == library.bookId && this.bookName.equals(library.bookName);
	}
}

class College {

	private int collegeCode;
	private String collegeName;

	public College(int collegeCode, String collegeName) {

		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
	}

	@Override
	public int hashCode() {

		return collegeCode;
	}
}

class Company {

	private int companyId;
	private String companyName;

	private transient int hashCode;

	public Company(int companyId, String companyName) {

		this.companyId = companyId;
		this.companyName = companyName;
		hashCode = Integer.MIN_VALUE;
	}

	@Override
	public int hashCode() {

		if (Integer.MIN_VALUE == hashCode) {
			if (null == this.companyName) {
				return super.hashCode();
			}
			String hashString = this.getClass().getName() + ":" + this.companyName.hashCode();
			this.hashCode = hashString.hashCode();
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Company company = (Company) obj;
		return company.companyId == this.companyId && company.companyName.equals(this.companyName);
	}
}
