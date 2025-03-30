## Exercise

## Section 2.1

### 2.1-4

Consider the problem of adding two n-bit binary integers, stored in two n-element
arrays A and B. The sum of the two integers should be stored in binary form in an (n + 1) element array C. 
State the problem formally and write pseudocode for adding the two integers.

### Formal Statement:

#### Input: 
* Two arrays `A[1..n]` and `B[1..n]`, where each element is either 0 or 1.
  Each array represents an n-bit binary integer, with the least significant bit (LSB) at index n.

#### Output:
* An array `C[1..n+1]`, representing the binary sum of A and B, where:

  * `C[1]` is the most significant bit (carry out)
  * `C[n+1]` is the least significant bit (LSB)


Pseudocode:

```
ADD_BINARY(A, B)
    n = A.length
    let C[1..n+1] be a new array
    carry = 0 
    for k = n + 1 down to 2
        sum = A[k - 1] + B[k - 1] + carry
        C[k] = sum mod 2
        carry = sum div 2
    C[k] = carry
    return C
```

## Section 2.3

### 2.3-2

Rewrite the MERGE procedure so that it does not use sentinels, instead stopping
once either array L or R has had all its elements copied back to A and then copying
the remainder of the other array back into A.

#### The Merge Procedure (without sentinels)
```
MERGE(A, p, q, r)
    n1 = q - p + 1
    n2 = r - q
    let L[1..n1] and R[1..n2] be a new arrays
    
    for i = 1 to n1
        L[i] = A[p + i - 1]
        
    for j = 1 to n2
        R[j] = A[q + j]
    
    i = 1
    j = 1
    k = p
    
    while i <= n1 and j <= n2
       if (L[i] <= R[j])
          A[k] = L[i]
          i = i + 1
       else A[k] = R[j]
          j = j + 1
       k = k + 1
       
    while i <= n1
        A[k] = L[i]
        i = i + 1
        k = k + 1
        
    while j <= n2
        A[k] = R[j]
        j = j + 1
        k = k + 1
             
```

### 2.3-5

### Binary Search

Referring back to the searching problem, observe that if the
sequence **A** is sorted, we can check the midpoint of the sequence against `v` and
eliminate half of the sequence from further consideration. The **binary search** algorithm repeats this procedure, 
halving the size of the remaining portion of the sequence each time. 
Write pseudocode, either iterative or recursive, for binary search. 
Argue that the worst-case running time of binary search is: $$ \theta (\text{log } n) $$

#### Iterative Binary Search

Pseudocode:
```
ITERATIVE_BINARY_SEARCH(A, v)
  left = 0
  right = A.length
  while left <= right
    mid = ⌊left + right / 2⌋
    if v == A[mid]
        return mid
    
    if v > A[mid] 
        left = mid + 1
    else right = mid - 1
    
  return NIL
```

#### Recursive Binary Search

```
RECURSIVE-BINARY-SEARCH(A, v, left, right)
  if left > right
    return NIL
  mid = ⌊(left + right) / 2⌋
  if v == A[mid]
      return mid
    
  if v > A[mid]
    return BINARY_SEARCH(A, v, mid + 1, right)
    else BINARY_SEARCH(A, v, left, mid - 1)
```

#### Recurrence Relation

$$ T(n) = T(n / 2) + \theta(1) $$

### 2.3-7

Describe a O(n lg n)-time algorithm that, given a set S of n integers and another
integer x, determines whether or not there exist two elements in S whose sum is
exactly x.

```
FIND(S, x)
   SORT(S)
   for i = 1 to S.length - 1
      target = x - S[i]
      j = BINARY_SEARCH(S, target, i + 1, S.length)
      if j != NIL
          return True
   return False
```