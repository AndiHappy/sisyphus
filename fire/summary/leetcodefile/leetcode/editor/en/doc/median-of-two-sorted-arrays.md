[TOC]

## Solution

---
#### Approach 1: Recursive Approach

To solve this problem, we need to understand "What is the use of median". In statistics, the median is used for:

>Dividing a set into two equal length subsets, that one subset is always greater than the other.

If we understand the use of median for dividing, we are very close to the answer.

First let's cut ![\text{A} ](./p__text{A}_.png)  into two parts at a random position *i*:

```
          left_A             |        right_A
    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
```

Since ![\text{A} ](./p__text{A}_.png)  has *m* elements, so there are *m+1* kinds of cutting (![i=0\simm ](./p__i_=_0_sim_m_.png) ).

And we know:

>![\text{len}(\text{left\_A})=i,\text{len}(\text{right\_A})=m-i ](./p__text{len}_text{left_A}__=_i,_text{len}_text{right_A}__=_m_-_i_.png) .
>
>Note: when *i = 0*, ![\text{left\_A} ](./p__text{left_A}_.png)  is empty, and when *i = m*, ![\text{right\_A} ](./p__text{right_A}_.png)  is empty.

With the same way, cut ![\text{B} ](./p__text{B}_.png)  into two parts at a random position *j*:

```

          left_B             |        right_B
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
```

Put ![\text{left\_A} ](./p__text{left_A}_.png)  and ![\text{left\_B} ](./p__text{left_B}_.png)  into one set, and put ![\text{right\_A} ](./p__text{right_A}_.png)  and ![\text{right\_B} ](./p__text{right_B}_.png)  into another set. Let's name them ![\text{left\_part} ](./p__text{left_part}_.png)  and ![\text{right\_part} ](./p__text{right_part}_.png) :

```
          left_part          |        right_part
    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
```

If we can ensure:

>1. ![\text{len}(\text{left\_part})=\text{len}(\text{right\_part}) ](./p__text{len}_text{left_part}__=_text{len}_text{right_part}__.png) 
>2. ![\max(\text{left\_part})\leq\min(\text{right\_part}) ](./p__max_text{left_part}__leq_min_text{right_part}__.png) 

then we divide all elements in ![\{\text{A},\text{B}\} ](./p__{text{A},_text{B}}_.png)  into two parts with equal length, and one part is always greater than the other. Then

![\text{median}=\frac{\text{max}(\text{left}\_\text{part})+\text{min}(\text{right}\_\text{part})}{2} ](./p___text{median}_=_frac{text{max}_text{left}_text{part}__+_text{min}_text{right}_text{part}_}{2}__.png) 

To ensure these two conditions, we just need to ensure:

>1. *i + j = m - i + n - j* (or: *m - i + n - j + 1*)  
>   if ![n\geqm ](./p__n_geq_m_.png) , we just need to set:  ![\i=0\simm,\j=\frac{m+n+1}{2}-i\\ ](./p____i_=_0_sim_m,__j_=_frac{m_+_n_+_1}{2}_-_i__.png)   
>  
>  
>2.  ![\text{B}\[j-1\]\leq\text{A}\[i\] ](./p__text{B}_j-1__leq_text{A}_i__.png)  and ![\text{A}\[i-1\]\leq\text{B}\[j\] ](./p__text{A}_i-1__leq_text{B}_j__.png) 

ps.1 For simplicity, I presume ![\text{A}\[i-1\],\text{B}\[j-1\],\text{A}\[i\],\text{B}\[j\] ](./p__text{A}_i-1_,_text{B}_j-1_,_text{A}_i_,_text{B}_j__.png)  are always valid even if *i=0*, *i=m*, *j=0*, or *j=n*.
I will talk about how to deal with these edge values at last.

ps.2 Why ![n\geqm ](./p__n_geq_m_.png) ? Because I have to make sure *j* is non-negative since ![0\leqi\leqm ](./p__0_leq_i_leq_m_.png)  and ![j=\frac{m+n+1}{2}-i ](./p__j_=_frac{m_+_n_+_1}{2}_-_i_.png) . If *n < m*, then *j* may be negative, that will lead to wrong result.

So, all we need to do is:

>Searching *i* in *[0, m]*, to find an object *i* such that:
>  
>![\qquad\text{B}\[j-1\]\leq\text{A}\[i\]\ ](./p__qquad_text{B}_j-1__leq_text{A}_i___.png)  and ![\\text{A}\[i-1\]\leq\text{B}\[j\],\ ](./p___text{A}_i-1__leq_text{B}_j_,__.png)  where ![j=\frac{m+n+1}{2}-i ](./p__j_=_frac{m_+_n_+_1}{2}_-_i_.png) 

And we can do a binary search following steps described below:

1. Set ![\text{imin}=0 ](./p__text{imin}_=_0_.png) , ![\text{imax}=m ](./p__text{imax}_=_m_.png) , then start searching in ![\[\text{imin},\text{imax}\] ](./p___text{imin},_text{imax}__.png) 
2. Set ![i=\frac{\text{imin}+\text{imax}}{2} ](./p__i_=_frac{text{imin}_+_text{imax}}{2}_.png) , ![j=\frac{m+n+1}{2}-i ](./p__j_=_frac{m_+_n_+_1}{2}_-_i_.png) 
3. Now we have ![\text{len}(\text{left}\_\text{part})=\text{len}(\text{right}\_\text{part}) ](./p__text{len}_text{left}_text{part}_=text{len}_text{right}_text{part}__.png) . And there are only 3 situations that we may encounter:  

    - ![\text{B}\[j-1\]\leq\text{A}\[i\] ](./p__text{B}_j-1__leq_text{A}_i__.png)  and ![\text{A}\[i-1\]\leq\text{B}\[j\] ](./p__text{A}_i-1__leq_text{B}_j__.png)   
      Means we have found the object *i*, so stop searching.  

    - ![\text{B}\[j-1\]>\text{A}\[i\] ](./p__text{B}_j-1____text{A}_i__.png)   
      Means ![\text{A}\[i\] ](./p__text{A}_i__.png)  is too small. We must adjust *i* to get ![\text{B}\[j-1\]\leq\text{A}\[i\] ](./p__text{B}_j-1__leq_text{A}_i__.png) .  
      Can we increase *i*?  
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Yes. Because when *i* is increased, *j* will be decreased.  
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;So ![\text{B}\[j-1\] ](./p__text{B}_j-1__.png)  is decreased and ![\text{A}\[i\] ](./p__text{A}_i__.png)  is increased, and ![\text{B}\[j-1\]\leq\text{A}\[i\] ](./p__text{B}_j-1__leq_text{A}_i__.png)  may  
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;be satisfied.  
      Can we decrease *i*?  
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No! Because when *i* is decreased, *j* will be increased.  
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;So ![\text{B}\[j-1\] ](./p__text{B}_j-1__.png)  is increased and ![\text{A}\[i\] ](./p__text{A}_i__.png)  is decreased, and ![\text{B}\[j-1\]\leq\text{A}\[i\] ](./p__text{B}_j-1__leq_text{A}_i__.png)  will  
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;be never satisfied.  
      So we must increase *i*. That is, we must adjust the searching range to ![\[i+1,\text{imax}\] ](./p___i+1,_text{imax}__.png) .  
      So, set ![\text{imin}=i+1 ](./p__text{imin}_=_i+1_.png) , and goto 2.

    - ![\text{A}\[i-1\]>\text{B}\[j\] ](./p__text{A}_i-1____text{B}_j__.png) :  
      Means ![\text{A}\[i-1\] ](./p__text{A}_i-1__.png)  is too big. And we must decrease *i* to get   ![\text{A}\[i-1\]\leq\text{B}\[j\] ](./p__text{A}_i-1_leq_text{B}_j__.png) .  
      That is, we must adjust the searching range to ![\[\text{imin},i-1\] ](./p___text{imin},_i-1__.png) .  
      So, set ![\text{imax}=i-1 ](./p__text{imax}_=_i-1_.png) , and goto 2.


When the object *i* is found, the median is:

>![\max(\text{A}\[i-1\],\text{B}\[j-1\]),\ ](./p__max_text{A}_i-1_,_text{B}_j-1__,___.png)  when *m + n* is odd

>![\frac{\max(\text{A}\[i-1\],\text{B}\[j-1\])+\min(\text{A}\[i\],\text{B}\[j\])}{2},\ ](./p__frac{max_text{A}_i-1_,_text{B}_j-1___+_min_text{A}_i_,_text{B}_j__}{2},___.png)  when *m + n* is even

Now let's consider the edges values *i=0,i=m,j=0,j=n* where ![\text{A}\[i-1\],\text{B}\[j-1\],\text{A}\[i\],\text{B}\[j\] ](./p__text{A}_i-1_,text{B}_j-1_,text{A}_i_,text{B}_j__.png)  may not exist.
Actually this situation is easier than you think.

What we need to do is ensuring that ![\text{max}(\text{left}\_\text{part})\leq\text{min}(\text{right}\_\text{part}) ](./p__text{max}_text{left}_text{part}__leq_text{min}_text{right}_text{part}__.png) . So, if *i* and *j* are not edges values (means ![\text{A}\[i-1\],\text{B}\[j-1\],\text{A}\[i\],\text{B}\[j\] ](./p__text{A}_i-1_,_text{B}_j-1_,text{A}_i_,text{B}_j__.png)  all exist), then we must check both ![\text{B}\[j-1\]\leq\text{A}\[i\] ](./p__text{B}_j-1__leq_text{A}_i__.png)  and ![\text{A}\[i-1\]\leq\text{B}\[j\] ](./p__text{A}_i-1__leq_text{B}_j__.png) .
But if some of ![\text{A}\[i-1\],\text{B}\[j-1\],\text{A}\[i\],\text{B}\[j\] ](./p__text{A}_i-1_,text{B}_j-1_,text{A}_i_,text{B}_j__.png)  don't exist, then we don't need to check one (or both) of these two conditions.
For example, if *i=0*, then ![\text{A}\[i-1\] ](./p__text{A}_i-1__.png)  doesn't exist, then we don't need to check ![\text{A}\[i-1\]\leq\text{B}\[j\] ](./p__text{A}_i-1__leq_text{B}_j__.png) .
So, what we need to do is:

>Searching *i* in *[0, m]*, to find an object *i* such that:
>
>*(j = 0* or *i = m* or ![\text{B}\[j-1\]\leq\text{A}\[i\]) ](./p__text{B}_j-1__leq_text{A}_i___.png)  and  
>*(i = 0* or *j = n* or ![\text{A}\[i-1\]\leq\text{B}\[j\]), ](./p__text{A}_i-1__leq_text{B}_j__,_.png)   where ![j=\frac{m+n+1}{2}-i ](./p__j_=_frac{m_+_n_+_1}{2}_-_i_.png) 

And in a searching loop, we will encounter only three situations:

>1. *(j = 0* or *i = m* or ![\text{B}\[j-1\]\leq\text{A}\[i\]) ](./p__text{B}_j-1__leq_text{A}_i___.png)  and  
    *(i = 0* or *j = n* or ![\text{A}\[i-1\]\leq\text{B}\[j\]) ](./p__text{A}_i-1__leq_text{B}_j___.png)   
    Means *i* is perfect, we can stop searching.
>2. *j > 0* and *i < m* and ![\text{B}\[j-1\]>\text{A}\[i\] ](./p__text{B}_j_-_1____text{A}_i__.png)   
    Means *i* is too small, we must increase it.
>3. *i > 0* and *j < n* and ![\text{A}\[i-1\]>\text{B}\[j\] ](./p__text{A}_i_-_1____text{B}_j__.png)   
    Means *i* is too big, we must decrease it.

Thanks to [@Quentin.chen](https://leetcode.com/Quentin.chen) for pointing out that: ![i<m\impliesj>0 ](./p__i___m_implies_j___0_.png)  and ![i>0\impliesj<n ](./p__i___0_implies_j___n_.png) . Because:


>![m\leqn,\i<m\impliesj=\frac{m+n+1}{2}-i>\frac{m+n+1}{2}-m\geq\frac{2m+1}{2}-m\geq0 ](./p__m_leq_n,__i___m_implies_j_=_frac{m+n+1}{2}_-_i___frac{m+n+1}{2}_-_m_geq_frac{2m+1}{2}_-_m_geq_0_.png) 
>
>![m\leqn,\i>0\impliesj=\frac{m+n+1}{2}-i<\frac{m+n+1}{2}\leq\frac{2n+1}{2}\leqn ](./p__m_leq_n,__i___0_implies_j_=_frac{m+n+1}{2}_-_i___frac{m+n+1}{2}_leq_frac{2n+1}{2}_leq_n_.png) 


So in situation 2. and 3. , we don't need to check whether *j > 0* and whether *j < n*.

```
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
```

**Complexity Analysis**

* Time complexity: ![O\big(\log\big(\text{min}(m,n)\big)\big) ](./p__Obig_logbig_text{min}_m,n_big_big__.png) .  
At first, the searching range is *[0, m]*.
And the length of this searching range will be reduced by half after each loop.
So, we only need ![\log(m) ](./p__log_m__.png)  loops. Since we do constant operations in each loop, so the time complexity is ![O\big(\log(m)\big) ](./p__Obig_log_m_big__.png) .
Since ![m\leqn ](./p__m_leq_n_.png) , so the time complexity is ![O\big(\log\big(\text{min}(m,n)\big)\big) ](./p__Obig_logbig_text{min}_m,n_big_big__.png) .

* Space complexity: *O(1)*.  
We only need constant memory to store *9* local variables, so the space complexity is *O(1)*.