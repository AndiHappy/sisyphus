<p>Given a string <code>s</code> containing just the characters <code>&#39;(&#39;</code>, <code>&#39;)&#39;</code>, <code>&#39;{&#39;</code>, <code>&#39;}&#39;</code>, <code>&#39;[&#39;</code> and <code>&#39;]&#39;</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
</ol>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()&quot;
<strong>Output:</strong> true
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;()[]{}&quot;
<strong>Output:</strong> true
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;(]&quot;
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>&#39;()[]{}&#39;</code>.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>String | Stack</details><br>

<div>ð 15032, ð 733</div>

<div id="labuladong"><hr>

**éç¥ï¼[æ°æ®ç»æç²¾åè¯¾ V1.8](https://aep.h5.xeknow.com/s/1XJHEO) æç»­æ´æ°ä¸­ï¼[ç¬¬åæå·é¢æå¡ææ](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) æ¥åå³å°æªæ­¢ã**



<p><strong><a href="https://labuladong.github.io/article?qno=20" target="_blank">â­ï¸labuladong é¢è§£</a></strong></p>
<details><summary><strong>labuladong æè·¯</strong></summary>

## åºæ¬æè·¯

æ æ¯ä¸ç§åè¿ååºçæ°æ®ç»æï¼å¤çæ¬å·é®é¢çæ¶åå°¤å¶æç¨ã

éå°å·¦æ¬å·å°±å¥æ ï¼éå°å³æ¬å·å°±å»æ ä¸­å¯»æ¾æè¿çå·¦æ¬å·ï¼çæ¯å¦å¹éã

**è¯¦ç»é¢è§£ï¼[å¦ä½è§£å³æ¬å·ç¸å³çé®é¢](https://labuladong.github.io/article/fname.html?fname=æ¬å·æå¥)**

**æ ç­¾ï¼æ¬å·é®é¢ï¼[æ ](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121993002939219969)**

## è§£æ³ä»£ç 

```java
class Solution {
    public boolean isValid(String str) {
        Stack<Character> left = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            else // å­ç¬¦ c æ¯å³æ¬å·
                if (!left.isEmpty() && leftOf(c) == left.peek())
                    left.pop();
                else
                    // åæè¿çå·¦æ¬å·ä¸å¹é
                    return false;
        }
        // æ¯å¦ææçå·¦æ¬å·é½è¢«å¹éäº
        return left.isEmpty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
}
```

**ç±»ä¼¼é¢ç®**ï¼
  - [1541. å¹³è¡¡æ¬å·å­ç¬¦ä¸²çæå°æå¥æ¬¡æ° ð ](/problems/minimum-insertions-to-balance-a-parentheses-string)
  - [921. ä½¿æ¬å·ææçæå°æ·»å  ð ](/problems/minimum-add-to-make-parentheses-valid)

</details>
</div>



