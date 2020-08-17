/**
 * This is the example for the IIFE ( immediately invoked function expression )
 * and also the hoisting concept in JS.
 * 
 * This is also an anonymous function which doesn't have name and which will be
 * invoked immediately.
 * 
 * The variable declaration can be interpreted as var a = b; b = 10;
 * 
 * Since there is a write operation on the 'b', java script compiler creates a
 * variable b globally and hence the value will be printed as 10 in this case.
 */
(function() {
	var a = b = 10;
})();
console.log(b);
// Output: 10

/**
 * In this case even though the salary is defined at the top before IIFE, it is
 * a read operation hence undefined will be printed and then assigned value will
 * be printed.
 */
var salary = "10000Rs";
(function() {
	console.log(salary);
	var salary = "20000Rs";
	console.log(salary);
})();
// Output:
// undefined
// 20000Rs
