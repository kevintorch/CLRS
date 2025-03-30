## Notes

### Different kinds of approaches in designing algorithms


#### Incremental Approach:

having sorted the subarray `A[1..j - 1]`,
we inserted the single element `A[j]` into its proper place, 
yielding the sorted subarray `A[1..j]`.


#### Divide and Conquer Approach:

Break the problem into several sub-problems that are similar to the original prob-
lem but smaller in size, solve the sub-problems recursively, and then combine these
solutions to create a solution to the original problem.

##### The Reccurence equation for divide and conquer is as follow:

$$ T(n)=\begin{cases}
        \theta(1) &   \text {if } n \leq c,
        \\ aT(n/b) + D(n) + C(n) &    \text {otherwise.}
        \end{cases}$$ 

in case of merge sort `a` and `b` is 2.

and since divide operation takes constant time 
as we are calculating mid by `(left + right) / 2` 
and Combine step takes `𝛩(n)` time . so relation becomes

$$ T(n)=\begin{cases}
    \theta(1) &   \text {if } n = 1,
    \\ 2T(n/2) + \theta(n) &    \text {if }n > 1
    \end{cases}$$ 

