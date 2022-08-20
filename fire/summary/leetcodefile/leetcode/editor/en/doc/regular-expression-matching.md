[TOC]

## Solution

---
#### Approach 1: Recursion

**Intuition**

If there were no Kleene stars (the `*` wildcard character for regular expressions), the problem would be easier - we simply check from left to right if each character of the text matches the pattern.

When a star is present, we may need to check many different suffixes of the text and see if they match the rest of the pattern.  A recursive solution is a straightforward way to represent this relationship.

**Algorithm**

Without a Kleene star, our solution would look like this:


```
def match(text, pattern):
    if not pattern: return not text
    first_match = bool(text) and pattern[0] in {text[0], '.'}
    return first_match and match(text[1:], pattern[1:])
```

If a star is present in the pattern, it will be in the second position ![\text{pattern\[1\]} ](./p__text{pattern_1_}_.png) .  Then, we may ignore this part of the pattern, or delete a matching character in the text.  If we have a match on the remaining strings after any of these operations, then the initial inputs matched.

```
class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
}
```

**Complexity Analysis**

* Time Complexity: Let *T, P* be the lengths of the text and the pattern respectively.  In the worst case, a call to `match(text[i:], pattern[2j:])` will be made ![\binom{i+j}{i} ](./p__binom{i+j}{i}_.png)  times, and strings of the order *O(T - i)* and *O(P - 2*j)* will be made.  Thus, the complexity has the order ![\sum_{i=0}^T\sum_{j=0}^{P/2}\binom{i+j}{i}O(T+P-i-2j) ](./p__sum_{i_=_0}^T_sum_{j_=_0}^{P_2}_binom{i+j}{i}_O_T+P-i-2j__.png) .  With some effort outside the scope of this article, we can show this is bounded by ![O\big((T+P)2^{T+\frac{P}{2}}\big) ](./p__Obig__T+P_2^{T_+_frac{P}{2}}big__.png) .

* Space Complexity:  For every call to `match`, we will create those strings as described above, possibly creating duplicates.  If memory is not freed, this will also take a total of ![O\big((T+P)2^{T+\frac{P}{2}}\big) ](./p__Obig__T+P_2^{T_+_frac{P}{2}}big__.png)  space, even though there are only order *O(T^2 + P^2)* unique suffixes of *P* and  *T* that are actually required.
<br />
<br />
---
#### Approach 2: Dynamic Programming

**Intuition**

As the problem has an **optimal substructure**, it is natural to cache intermediate results.  We ask the question ![\text{dp(i,j)} ](./p__text{dp_i,_j_}_.png) : does ![\text{text\[i:\]} ](./p__text{text_i:_}_.png)  and ![\text{pattern\[j:\]} ](./p__text{pattern_j:_}_.png)  match?  We can describe our answer in terms of answers to questions involving smaller strings.

**Algorithm**

We proceed with the same recursion as in [Approach 1](#approach-1-recursion), except because calls will only ever be made to `match(text[i:], pattern[j:])`, we use ![\text{dp(i,j)} ](./p__text{dp_i,_j_}_.png)  to handle those calls instead, saving us expensive string-building operations and allowing us to cache the intermediate results.


*Top-Down Variation*
```
enum Result {
    TRUE, FALSE
}

class Solution {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                       first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
```

*Bottom-Up Variation*

```
class Solution {
    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
```

**Complexity Analysis**

* Time Complexity: Let *T, P* be the lengths of the text and the pattern respectively.  The work for every call to `dp(i, j)` for *i=0, ... ,T*; *j=0, ... ,P* is done once, and it is *O(1)* work.  Hence, the time complexity is *O(TP)*.

* Space Complexity:  The only memory we use is the *O(TP)* boolean entries in our cache.  Hence, the space complexity is *O(TP)*.