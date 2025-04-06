## Problems

### 2.1 Insertion sort on small arrays in merge sort

Although merge sort runs in $\Theta(n \log n)$ worst-case time and insertion sort runs
in $\Theta(n^2)$ worst-case time, the constant factors in insertion sort can make it faster
in practice for small problem sizes on many machines. 
Thus, it makes sense to **coarsen** the leaves of the recursion by using insertion sort within merge sort 
when sub-problems become sufficiently small. Consider a modification to merge sort in
which $n/k$ sub-lists of length $k$ are sorted using insertion sort and then merged
using the standard merging mechanism, where $k$ is a value to be determined.

a. Show that insertion sort can sort the $n / k$ sub-lists, each of length $k$, in $\Theta(nk)$
   worst-case time.    
b. Show how to merge the sublists in $\Theta(n \log (n/k))$ worst-case time.    
c. Given that the modified algorithm runs in $\Theta(nk + n \log (n/k))$ worst-case time,
   what is the largest value of $k$ as a function of $n$ for which the modified algorithm 
   has the same running time as standard merge sort, in terms of $\Theta$-notation?    
d. How should we choose $k$ in practice?  



