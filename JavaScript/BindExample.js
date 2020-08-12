/**
 * This example demonstrates the 'bind' functionality in java script.
 * 'bind' is like a immutable object in java where the time of execution of the function happens
 * immediately but the time of binding of 'this' object is in future. Meaning to say until
 * variable or the function is called, after binding, 'this' object will be referring to the old value only
 */
var firstUser = {
		firstName : "Suresh",
		lastName : "Kumar",
		getFullName : function() {
			return this.firstName + " " + this.lastName;
		}
};

var secondUser = {
		firstName : "Pisupati",
		lastName : "Swathi",
		getFullName : firstUser.getFullName
};

function userName(value) {
	console.log( "this    "  +this);
	console.log( "Full name     "  +this.getFullName() + "  value === "   +value );
}

let logUser = userName.bind(firstUser, 'cool'); 
logUser('cool'); 