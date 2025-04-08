## Problems

### 2.1 Insertion sort on small arrays in merge sort

Although merge sort runs in $\Theta(n \log n)$ worst-case time and insertion sort runs
in $\Theta(n^2)$ worst-case time, the constant factors in insertion sort can make it faster
in practice for small problem sizes on many machines. 
Thus, it makes sense to **coarsen** the leaves of the recursion by using insertion sort within merge sort 
when sub-problems become sufficiently small. Consider a modification to merge sort in
which $n/k$ sub-lists of length $k$ are sorted using insertion sort and then merged
using the standard merging mechanism, where $k$ is a value to be determined.

1. Show that insertion sort can sort the $n / k$ sub-lists, each of length $k$, in $\Theta(nk)$
   worst-case time.    
2. Show how to merge the sublists in $\Theta(n \log (n/k))$ worst-case time.    
3. Given that the modified algorithm runs in $\Theta(nk + n \log (n/k))$ worst-case time,
   what is the largest value of $k$ as a function of $n$ for which the modified algorithm 
   has the same running time as standard merge sort, in terms of $\Theta$-notation?    
4. How should we choose $k$ in practice?  


### Solution:

#### 1. insertion sort on `n / k` sub lists of size `k`

Insertion sort on list of size `k` can take $\Theta(k^2)$ worst time.
So, total time on $n / k$ sub-lists.

$$
\frac{n}{k}\cdot\Theta(k^2) = \Theta(nk)  
$$

#### 2. Merge Sub-list in `𝛩 (n log(n / k))`

Now we have $`n / k`$ sorted sub-lists of size $k$. total number of elements is $n$.
We know merge sort takes $\Theta(n \log m)$ to merge `m` sorted sub-lists with `n` total elements.

so merging takes:

$$ 
\Theta(n \log (n / k)) 
$$

#### 3. Largest value of `k` as a function of `n`:

Our modified algorithm runs in $\Theta (nk + n\log(n / k))$

so now to find out the largest value of `k` 
for which our modified algorithm running time stays the same as our standard merge algorithm 
we compare it with standard merge sort running time in terms of `n`:

$$ \Theta (nk + n\log(n / k)) = \Theta(n \log n) $$

So we solve for `k` and let's remove $\Theta$ for now and treat it algebraically:

$$ nk + n\log(n / k) = n \log n $$

Divide both sides by `n`:

$$
\begin{align*}
k + \log\left(\frac{n}{k}\right) &= \log n \\
k + \log(n) - \log(k) &= \log n \quad (\text{since } \log \tfrac{m}{n} = \log m - \log n) \\
k - \log k = 0 \implies k &= \log k
\end{align*}
$$

So

$$
k = \log k
$$

for $k = \log k$ doesn't have a solution:  
because log k grows much slower than k.

Let's try **approximate asymptotic analysis**  
we try an **asymptotic estimate** — a common trick in algorithm analysis. Let's plug in:

$$ k = \log n $$
And compute the total time:
$$
T(n) = nk + n\log (n / k)
$$
Let's plug $k = \log n$:
$$\begin{align} 
T(n) &= n \cdot \log n + n\log (n / \log n) \\
     &= n \cdot \log n + n(\log n - \log \log n)\\
     &= n \cdot  \log n + n \log n - n \log \log n\\
     &= 2n \cdot \log n - n \log \log n\\
     &\approx \Theta (n \log n)
\end{align}
$$

hence, the largest value of $k$ for which the running time stays in $\Theta(n \log n)$ is:

$$ k = \Theta (\log n)$$

#### 4. How should we choose $k$ in practice?

In real-world implementations (e.g., Timsort, used in Python and Java), 
constants and memory hierarchy effects (CPU cache, branch prediction, etc.) 
make a big difference.

- Insertion sort is very fast on tiny arrays because of low overhead and good cache behavior.
- So in practice A small constant value of `k` (e.g., 16, 32, 64) is 
  usually chosen after some benchmarking which is known as **empirical tuning**.
- You don’t need to go as high as $\log n$ in practice — even 32 may outperform merge sort on small arrays.

**Answer:** Choose `k` experimentally based on your machine, dataset, and compiler. 
Often `k = 16` or `k = 32` is a good starting point.

###### Hybrid Merge-Insertion Sort
Pseudocode:
- `A` is the Array
- `p` is the starting index.
- `r` is the ending index.
- `k` is the cutoff size: if the sub-array size is `≤ k`, we use insertion sort.
```
HYBRID_MERGE_SORT(A, p, r, k)
  if r - p + 1 ≤ k
      INSERTION_SORT(A, p, r)
  else
      q = ⌊(p + r)/2⌋
      HYBRID_MERGE_SORT(A, p, q, k)
      HYBRID_MERGE_SORT(A, q + 1, r, k)
      MERGE(A, p, q, r)
```

### 2.2 Correctness of bubble sort

Pseudocode:
```
BUBBLE_SORT(A)
1   for j = 1 to A.length - 1
2      for i = A.length downto j + 1
3         if A[i] < A[i - 1]
4            exchange A[i] with A[i - 1]
```

1. Let A' denote the output of BUBBLE_SORT(A). To prove that BUBBLE_SORT is
correct, we need to prove that it terminates and that

    $$ A'[1] \le A'[2] \le \cdots \le A'[n],  \quad\quad\quad(2.3) $$
    
    where $n = A.length$. In order to show that BUBBLE_SORT actually sorts, what else do we need to prove?  
    The next two parts will prove inequality (2.3).

2. State precisely a loop invariant for the **for** loop in lines 2–4, and prove that this
loop invariant holds. Your proof should use the structure of the loop invariant
proof presented in this chapter.
3. Using the termination condition of the loop invariant proved in part (2), state
a loop invariant for the **for** loop in lines 1–4 that will allow you to prove in-
equality (2.3). Your proof should use the structure of the loop invariant proof
presented in this chapter.
4. What is the worst-case running time of bubblesort? How does it compare to the
running time of insertion sort?

### Solution:

#### 1. What else we need to prove?

The output is a permutation of the input 
(no elements are lost or duplicated — i.e., the same elements, just reordered).
So the missing piece is to prove that `A'` is a permutation of the original array `A`.

#### 2. Loop Invariant for inner loop
let `n` is `A.length`
>   At the start of each iteration of the inner `for` loop (indexed by `i`), 
>   the sub-array `A[i..n]` is a permutation of the original elements in that range,
>   and the smallest element in `A[i..n]` is at position `A[i]`.

#### 💡Intuition:

Each Pass "Bubble up" smallest element to the left part of the array.

###### Proof of loop Invariant:

**Initialization:**
Prior to the iteration `i = A.length` (`i = n`), 
the sub-array `A[n..n]` contains only one element, 
which is trivially the smallest in that sub-array and a permutation of itself.

**Maintenance**
After the comparison and possibly swap, i becomes i - 1. Loop invariant still holds:
the sub-array `A[i..n]` contains the smallest element in `A[i..n]` at `A[i]`, and is a permutation of the original elements in that range.

**Termination**
After the loop terminates, `i = j`. The smallest element in `A[j..n]` is now at `A[i]` or `A[j]` and 
the elements in A[j..n] or A[i..n] are a permutation of the original elements in that range.


#### 3. Loop Invariant for outer loop

let `n` is `A.length`

>  At the start of each iteration of the outer `for` loop (indexed by j), 
>  the sub-array A[1..j-1] contains the smallest `j-1` sorted elements of A[1..n], 
>  and the sub-array A[j..n] contains the remaining unsorted elements of A[1..n].


**Initialization:**
Prior to the iteration when `j = 1`, the sub-array is `A[1..0]`, which is an empty array,
and also trivially sorted and sub-array A[1..n] is unsorted.

**Maintenance**
After the completion of inner for loop. smallest element moved to `j` and `j` then increased to `j+1` making our loop invariant holds again
which includes smallest sorted elements at `A[1..j-1]` and unsorted elements at `A[j+1..n]`

**Termination**
After the loop terminates, `j = n+1`. smallest elements is present at  A[i..j-1]

#### 4. Worst-case running time

for worse-case when elements are in revered-order. bubble sort takes 
$ O (n^2) $ time. If we compare this to insertion sort. insertion sort also takes $ O (n^2) $.

however, for best-case when elements are sorted.
Insertion sort takes $ O (n) $ time and bubble sort still takes $ O (n^2) $ time unless we optimize it.  

