# Notes

### 1.1  Algorithms

*  An algorithm is any well-defined computational procedure 
   that takes some value, or set of values, as input and 
   produces some value, or set of values, as output
*  An algorithm is said to be correct if, for every input instance, 
   it halts with the correct output.
*  An incorrect algorithm might not halt at all on some input instances, 
   or it might halt with an incorrect answer.
*  incorrect algorithms can sometimes be useful, 
   if we can control their error rate.

### 1.2  Algorithms as a technology

Suppose computers were infinitely fast and computer memory was free. Would
you have any reason to study algorithms? The answer is yes, if for no other reason
than that you would still like to demonstrate that your solution method terminates
and does so with the correct answer.

#### Efficiency

Different algorithms devised to solve the same problem 
often differ dramatically in their efficiency.

For example:  
**insertion sort** takes roughly _c<sub>1</sub> n<sup>2</sup>_ time. where 
**merge sort** takes roughly _c<sub>2</sub> n log n_ time
> Note:  c<sub>1</sub> < c<sub>2</sub>

Although c<sub>1</sub> < c<sub>2</sub>. merge sort will beat the insertion sort 
once the input become large enough. for smaller inputs 
insertion sort will definitely beat merge sort.

