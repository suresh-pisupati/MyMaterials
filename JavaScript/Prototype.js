/**
 * This is the example for demonstrating the inheritance concept using prototypes.
 *  When a function is executed in java script, there will be two objects which will be
 *  created in the background.
 *  1. the function itself and
 *  2. a prototype object for this function.
 *  
 *  We can use this prototype object for modifying the behavior of the function.
 *  
 *  There are 2 ways to access the prototype objects.
 *  1. If we want to access through the function object itself, we need to use prototype
 *      Ex: Employee.prototype
 *  2. If we want to access through the reference object, we need to access using
 *      __proto__ ( called as dunder proto )
 *      Ex: empDepart.__proto__
 *   
 *   The above two ways results the same and we can verify using equality check
 */
function Employee(name) {
	this.name = name;
}
Employee.prototype.getEmployeeName = function () {
	return this.name;
}

/*
 * This function doesn't have name of the employee set.
 * 
 * @param name
 * @param department
 * @returns
 */
function Department(name, department) {
	this.name = name;
	this.department = department;
}
Department.prototype.getDepartmentName = function () {
	return this.department;
}

var empDepart = new Department( "Suresh", "Engineering" );
//Setting the departments prototype object to employees object to access properties in
// the employee object/function
empDepart.__proto__.__proto__ = Employee.prototype;
console.log( empDepart.getEmployeeName()  +"  Department   " +empDepart.getDepartmentName());
