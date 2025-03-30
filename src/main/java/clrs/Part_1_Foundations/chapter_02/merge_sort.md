## Merge Sort

Pseudocode:

#### The Merge Sort Procedure
```
MERGE_SORT(A, p, r)
    if p < r
        q = ⌊(p + r) / 2⌋  // floor of mid
        MERGE_SORT(A, p, q)
        MERGE_SORT(A, q + 1, r)
        MERGE(A, p, q, r)
```


#### The Merge Procedure
```
MERGE(A, p, q, r)
    n1 = q - p + 1
    n2 = r - q
    let L[1..n1 + 1] and R[1..n2 + 1] be a new arrays
    
    for i = 1 to n1
        L[i] = A[p + i - 1]
        
    for j = 1 to n2
        R[j] = A[q + j]
        
    L[n1 + 1] = ∞
    R[n2 + 1] = ∞
    
    i = 1
    j = 1
    
    for k = p to r
        if L[i] <= R[j]
            A[k] = L[i]
            i = i + 1
        else A[k] = R[j]
            j = j + 1
             
```
