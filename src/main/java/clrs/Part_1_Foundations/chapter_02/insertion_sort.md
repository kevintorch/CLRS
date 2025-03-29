## Insertion Sort

Pseudocode:

### For non-decreasing (Ascending) order

```
INSERTION_SORT(A)
    For j from 2 to A.length
        key = A[j]
        i = j - 1
        while i > 0 and A[i] > key
            A[i + 1] = A[i]
            i = i - 1
        A[i + 1] = key 
```

### For non-increasing (Descending) order

Just change the equality condition from `>` to `<=`

```
INSERTION_SORT(A)
    For j from 2 to A.length
        key = A[j]
        i = j - 1
        while i > 0 and A[i] <= key
            A[i + 1] = A[i]
            i = i - 1
        A[i + 1] = key 
```

### Little Tweaked Version

if we want to use `i` instead of `i + 1` at the end.  
from `A[i + 1] = key` to `A[i] = key`.
we are going to have to change `i` to `i - 1` everywhere,
except for decrement operation.

```
INSERTION_SORT(A)
    For j from 2 to A.length
        key = A[j]
        i = j
        while i > 1 and A[i - 1] > key
            A[i] = A[i - 1]
            i = i - 1
        A[i] = key 
```
