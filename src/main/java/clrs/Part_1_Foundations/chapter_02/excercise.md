## Excercise

### 2.1.4

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
    for k from n + 1 down to 2
        sum = A[k - 1] + B[k - 1] + carry
        C[k] = sum mod 2
        carry = sum div 2
    C[k] = carry
    return C
```