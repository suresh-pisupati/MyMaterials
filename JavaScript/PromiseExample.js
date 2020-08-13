/**
 * Promises are used to make asynchronous calls.
 * 
 * A Promise has 4 different states
 * 
 * 1. fulfilled    represents the state of completion of the request
 * 2. rejected   represents the state of rejecting the request
 * 3. pending	represents the state of neither rejected nor completed
 * 4. settled		request has fulfilled or rejected
 * 
 * Promise constructor takes only one function as argument, a callback function
 * CallBack function takes two arguments. <i>resolve</i> and <i>reject</i>
 * Performs the necessary action inside this callback function and everything goes well, resolve will be invoked
 * If any exception occurs during the process, reject will be invoked.
 */
var promise = new Promise(function(resolve, reject) {
	const x = "suresh";
	const y = "suresh1";
	if (x === y) {
		resolve('They both are ssame...');
	} else {
		throw new Error( 'Exception while handling the request.' );
	}
});

/**
 * Promise can be consumed by two functions namely, .then and .catch
 * .then() will be invoked when the function is resolved or rejected.
 * .then() will takes two functions as arguments.
 * First function is  invoked when the request is completed and returned with result.
 * Second function is invoked when the request resulted in error.
 */
promise.then(function(message) {
	console.log(message);
}, function(error) {
	console.log(error);
});

/**
 * There is a better way to handle the errors and exceptions while processing the 
 * promise request using .catch() which takes one function as argument
 * 
 */
promise.then(function(message) {
	console.log(message);
}).catch( function(error) {
	console.log(error);
});
