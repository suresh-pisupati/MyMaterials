/**
 * This is the example for making the java script call as synchronous call.
 * Since java script calls are asynchronous calls, and setTimeout will be for a
 * delay of second, if we do not use this approach, the last value will be
 * printed 10 times.
 */
var i;
for (i = 1; i <= 10; i++) {
	myFunction(i);
}

function myFunction(i) {
	var currentValue = i;
	setTimeout(function() {
		console.log(currentValue);
	}, 1000);
};

// Example with IIFE
var i;
for (i = 0; i < 3; i++) {
	(function() {
		var current = i;
		setTimeout(function() {
			console.log(current);
		}, 1000);
	})();
}