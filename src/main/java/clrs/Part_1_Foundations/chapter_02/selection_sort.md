## Selection Sort

Pseudocode:

```
SELECTION_SORT(A)
    For j = 1 to A.length - 1
        small = j
        for i = j + 1 to A.length
            if A[i] < A[small]
                small = i
        exchange A[j] with A[small] 
```
