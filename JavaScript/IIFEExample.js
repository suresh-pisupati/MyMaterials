/**
 * This is the example for the IIFE ( immediately invoked function expression )
 * and also the hoisting concept in JS.
 * 
 * This is also an anonymous function which doesn't have name and which will be 
 * invoked immediately.
 * 
 * The variable declaration can be interpreted as 
 * var a = b;
 * b = 10;
 * 
 * Since there is a write operation on the 'b', java script compiler creates a variable b
 * globally and hence the value will be printed as 10 in this case.
 */
(function() {
	var a = b = 10;
})();
console.log(b);