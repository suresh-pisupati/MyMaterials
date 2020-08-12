/**
 * setInterval() is slightly different from setTimeout() where setInterval() will executes the 
 * function for each and every specific time that is mentioned. This is like never ending process.
 */
var displayDateFunction = setInterval(() => {
myFunction()}, 1000);

function myFunction() {
	
	var date = new Date();
	console.log(date.toLocaleTimeString());
}

/**
 * In order to stop the execution of setInterval(), java script provides a method called
 * clearInterval() which takes the parameter as the variable or the function for which the 
 * setInterval is set.
 */
function stopFunction() {
	clearInterval(displayDateFunction);
}