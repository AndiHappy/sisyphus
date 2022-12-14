<p>Given a string <code>s</code>, return <em>the longest palindromic substring</em> in <code>s</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;babad&quot;
<strong>Output:</strong> &quot;bab&quot;
<strong>Explanation:</strong> &quot;aba&quot; is also a valid answer.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;cbbd&quot;
<strong>Output:</strong> &quot;bb&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> consist of only digits and English letters.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>String | Dynamic Programming</details><br>

<div>ð 20796, ð 1193</div>

<div id="labuladong"><hr>

**éç¥ï¼[æ°æ®ç»æç²¾åè¯¾ V1.8](https://aep.h5.xeknow.com/s/1XJHEO) æç»­æ´æ°ä¸­ï¼[ç¬¬åæå·é¢æå¡ææ](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) æ¥åå³å°æªæ­¢ã**



<p><strong><a href="https://labuladong.github.io/article?qno=5" target="_blank">â­ï¸labuladong é¢è§£</a></strong></p>
<details><summary><strong>labuladong æè·¯</strong></summary>

## åºæ¬æè·¯

> æ¬ææè§é¢çï¼[æ°ç»åæéæå·§æ±æ»](https://www.bilibili.com/video/BV1iG411W7Wm)

PSï¼è¿éé¢å¨[ãç®æ³å°æã](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) çç¬¬ 373 é¡µã

**å¯»æ¾åæä¸²çé®é¢æ ¸å¿ææ³æ¯ï¼ä»ä¸­é´å¼å§åä¸¤è¾¹æ©æ£æ¥å¤æ­åæä¸²**ï¼å¯¹äºæé¿åæå­ä¸²ï¼å°±æ¯è¿ä¸ªææï¼

```python
for 0 <= i < len(s):
    æ¾å°ä»¥ s[i] ä¸ºä¸­å¿çåæä¸²
    æ´æ°ç­æ¡
```

æ¾åæä¸²çå³é®æå·§æ¯ä¼ å¥ä¸¤ä¸ªæé `l` å `r` åä¸¤è¾¹æ©æ£ï¼å ä¸ºè¿æ ·å®ç°å¯ä»¥åæ¶å¤çåæä¸²é¿åº¦ä¸ºå¥æ°åå¶æ°çæåµã

```python
for 0 <= i < len(s):
    # æ¾å°ä»¥ s[i] ä¸ºä¸­å¿çåæä¸²
    palindrome(s, i, i)
    # æ¾å°ä»¥ s[i] å s[i+1] ä¸ºä¸­å¿çåæä¸²
    palindrome(s, i, i + 1)
    æ´æ°ç­æ¡
```

**è¯¦ç»é¢è§£ï¼[åæéæå·§ç§æä¸éæ°ç»é¢ç®](https://labuladong.github.io/article/fname.html?fname=åæéæå·§)**

**æ ç­¾ï¼ä¸­å¿åä¸¤ç«¯çåæéï¼[æ°ç»](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## è§£æ³ä»£ç 

```java
class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // ä»¥ s[i] ä¸ºä¸­å¿çæé¿åæå­ä¸²
            String s1 = palindrome(s, i, i);
            // ä»¥ s[i] å s[i+1] ä¸ºä¸­å¿çæé¿åæå­ä¸²
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int l, int r) {
        // é²æ­¢ç´¢å¼è¶ç
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // åä¸¤è¾¹å±å¼
            l--;
            r++;
        }
        // è¿åä»¥ s[l] å s[r] ä¸ºä¸­å¿çæé¿åæä¸²
        return s.substring(l + 1, r);
    }
}
```

**ç±»ä¼¼é¢ç®**ï¼
  - [167. ä¸¤æ°ä¹å II - è¾å¥æåºæ°ç» ð¢](/problems/two-sum-ii-input-array-is-sorted)
  - [26. å é¤æåºæ°ç»ä¸­çéå¤é¡¹ ð¢](/problems/remove-duplicates-from-sorted-array)
  - [27. ç§»é¤åç´  ð¢](/problems/remove-element)
  - [283. ç§»å¨é¶ ð¢](/problems/move-zeroes)
  - [344. åè½¬å­ç¬¦ä¸² ð¢](/problems/reverse-string)
  - [83. å é¤æåºé¾è¡¨ä¸­çéå¤åç´  ð¢](/problems/remove-duplicates-from-sorted-list)
  - [åæ Offer 57. åä¸ºsçä¸¤ä¸ªæ°å­ ð¢](/problems/he-wei-sde-liang-ge-shu-zi-lcof)
  - [åæ Offer II 006. æåºæ°ç»ä¸­ä¸¤ä¸ªæ°å­ä¹å ð¢](/problems/kLl5u1)

</details>
</div>





