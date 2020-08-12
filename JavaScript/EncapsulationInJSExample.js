/**
 *  This example demonstrates the encapsulation concept in java script.
 *  
 */
function employee() {

	var firstName = "suresh";
	var lastName = "kumar";

	var fullName = {
		"getFirstName" : function() {
			return firstName;
		},

		"getLastName" : function() {
			return lastName;
		},
	};
	return fullName;
}

var emp = employee();
console.log("First Name: " + emp.getFirstName()); // Prints First Name: suresh
console.log("Last Name:   " + emp.getLastName()); // Prints Last Name:   kumar
console.log("First Name using emp obj:   " + emp.firstName); // First Name using emp obj :   undefined