var test = function() {
	var firstName = "suresh";
	
	var fullName = {
		"getName" : function() {
			return firstName;
		}
	};
	return fullName;
}

let testFn = test();
console.log(testFn.getName());