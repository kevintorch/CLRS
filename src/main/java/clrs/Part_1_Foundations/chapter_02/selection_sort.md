## Selection Sort

Pseudocode:

```
SELECTION_SORT(A)
    For j from 1 to A.length - 1
        small = j
        for i = j + 1 to A.length
            if A[i] < A[small]
                small = i
        swap(A, j, small) 
```
