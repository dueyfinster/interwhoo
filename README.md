[![Build status](https://ci.appveyor.com/api/projects/status/ael2iylv4arw5hwt?svg=true)](https://ci.appveyor.com/project/dueyfinster/designpatterns)
[![Build Status](https://travis-ci.org/dueyfinster/interwhoo.svg?branch=master)](https://travis-ci.org/dueyfinster/interwhoo)

# Intercom Assessment

## The Exercise
1.    What's your proudest achievement? It can be a personal project or something you've worked on professionally. Just a short paragraph is fine, but I'd love to know why you're proud of it, what impact it had (If any) and any insights you took from it.
2.   Write a function that will flatten an array of arbitrarily nested arrays of integers into a flat array of integers. e.g. [[1,2,[3]],4] → [1,2,3,4]. If the language you're using has a function to flatten arrays, you should pretend it doesn't exist.
3.    We have some customer records in a text file (customers.json) -- one customer per line, JSON-encoded. We want to invite any customer within 100km of our Dublin office for some food and drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).

	* You can use the first formula from [this Wikipedia article](https://en.wikipedia.org/wiki/Great-circle_distance) to calculate distance. Don't forget, you'll need to convert degrees to radians.
	* The GPS coordinates for our Dublin office are 53.3381985, -6.2592576.
	* You can find the Customer list [here](https://gist.github.com/brianw/19896c50afa89ad4dec3).

⭑ Please don’t forget, your code should be production ready, clean and tested!

