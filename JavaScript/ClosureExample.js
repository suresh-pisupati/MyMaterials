/**
 * This example demonstrates the closure property of java script.
 * 
 * Closure is the property by which java script remembers the scope chain of variables declared in it
 * even though the file is no longer running.
 * 
 * For each and every execution of the function, in java script, a new set of variables are created and
 * assigned with the values declared for them.
 * 
 * In this example, since a is global variable, for each execution, the last value will be maintained
 * and incremented each time.
 */
var a = 10;
function outer() {
	var b = 20;
	var c;
	var inner = function() {
		++a;
		++b;
		console.log( "a =   "+a  );
		console.log(  "b =   "+ b );
		c = a + b;
		console.log( "c =  " +c );
	};
	return inner;
}

var outerFn = outer();
outerFn(); // Prints a = 11 b = 21 c = 32
console.log( "==============================\n" );
outerFn(); // Prints a = 12 b = 22 c = 34
