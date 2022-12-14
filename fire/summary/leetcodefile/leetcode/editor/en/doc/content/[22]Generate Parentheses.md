<p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre><p><strong>Example 2:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>String | Dynamic Programming | Backtracking</details><br>

<div>ð 14650, ð 552</div>

<div id="labuladong"><hr>

**éç¥ï¼[æ°æ®ç»æç²¾åè¯¾ V1.8](https://aep.h5.xeknow.com/s/1XJHEO) æç»­æ´æ°ä¸­ï¼[ç¬¬åæå·é¢æå¡ææ](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) æ¥åå³å°æªæ­¢ã**



<p><strong><a href="https://labuladong.github.io/article?qno=22" target="_blank">â­ï¸labuladong é¢è§£</a></strong></p>
<details><summary><strong>labuladong æè·¯</strong></summary>

## åºæ¬æè·¯

PSï¼è¿éé¢å¨[ãç®æ³å°æã](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) çç¬¬ 306 é¡µã

æ¬é¢å¯ä»¥æ¹åä¸ºï¼

ç°å¨æ `2n` ä¸ªä½ç½®ï¼æ¯ä¸ªä½ç½®å¯ä»¥æ¾ç½®å­ç¬¦ `(` æè `)`ï¼ç»æçæææ¬å·ç»åä¸­ï¼æå¤å°ä¸ªæ¯åæ³çï¼

è¿å°±æ¯å¸åçåæº¯ç®æ³æéï¼æ´åç©·ä¸¾å°±è¡äºã

ä¸è¿ä¸ºäºåå°ä¸å¿è¦çç©·ä¸¾ï¼æä»¬è¦ç¥éåæ³æ¬å·ä¸²æä»¥ä¸æ§è´¨ï¼

**1ãä¸ä¸ªãåæ³ãæ¬å·ç»åçå·¦æ¬å·æ°éä¸å®ç­äºå³æ¬å·æ°éï¼è¿ä¸ªå¾å¥½çè§£**ã

**2ãå¯¹äºä¸ä¸ªãåæ³ãçæ¬å·å­ç¬¦ä¸²ç»å `p`ï¼å¿ç¶å¯¹äºä»»ä½ ` 0 <= i < len(p)` é½æï¼å­ä¸² `p[0..i]` ä¸­å·¦æ¬å·çæ°éé½å¤§äºæç­äºå³æ¬å·çæ°é**ã

å ä¸ºä»å·¦å¾å³ç®çè¯ï¼è¯å®æ¯å·¦æ¬å·å¤åï¼å°æåå·¦å³æ¬å·æ°éç¸ç­ï¼è¯´æè¿ä¸ªæ¬å·ç»åæ¯åæ³çã

ç¨ `left` è®°å½è¿å¯ä»¥ä½¿ç¨å¤å°ä¸ªå·¦æ¬å·ï¼ç¨ `right` è®°å½è¿å¯ä»¥ä½¿ç¨å¤å°ä¸ªå³æ¬å·ï¼å°±å¯ä»¥ç´æ¥å¥ç¨ [åæº¯ç®æ³å¥è·¯æ¡æ¶](https://labuladong.github.io/article/fname.html?fname=åæº¯ç®æ³è¯¦è§£ä¿®è®¢ç) äºã

**è¯¦ç»é¢è§£ï¼[åæº¯ç®æ³æä½³å®è·µï¼æ¬å·çæ](https://labuladong.github.io/article/fname.html?fname=åæ³æ¬å·çæ)**

**æ ç­¾ï¼[åæº¯ç®æ³](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## è§£æ³ä»£ç 

```java
class Solution {
    public:
    vector<string> generateParenthesis(int n) {
        if (n == 0) return {};
        // è®°å½ææåæ³çæ¬å·ç»å
        vector<string> res;
        // åæº¯è¿ç¨ä¸­çè·¯å¾
        string track;
        // å¯ç¨çå·¦æ¬å·åå³æ¬å·æ°éåå§åä¸º n
        backtrack(n, n, track, res);
        return res;
    }

    // å¯ç¨çå·¦æ¬å·æ°éä¸º left ä¸ªï¼å¯ç¨çå³æ¬å·æ°éä¸º rgiht ä¸ª
    void backtrack(int left, int right, 
                string& track, vector<string>& res) {
        // è¥å·¦æ¬å·å©ä¸çå¤ï¼è¯´æä¸åæ³
        if (right < left) return;
        // æ°éå°äº 0 è¯å®æ¯ä¸åæ³ç
        if (left < 0 || right < 0) return;
        // å½æææ¬å·é½æ°å¥½ç¨å®æ¶ï¼å¾å°ä¸ä¸ªåæ³çæ¬å·ç»å
        if (left == 0 && right == 0) {
            res.push_back(track);
            return;
        }
        
        // å°è¯æ¾ä¸ä¸ªå·¦æ¬å·
        track.push_back('('); // éæ©
        backtrack(left - 1, right, track, res);
        track.pop_back(); // æ¤æ¶éæ©

        // å°è¯æ¾ä¸ä¸ªå³æ¬å·
        track.push_back(')'); // éæ©
        backtrack(left, right - 1, track, res);
        track.pop_back(); // æ¤æ¶éæ©
    }
}
```

**ç±»ä¼¼é¢ç®**ï¼
  - [åæ Offer II 085. çæå¹éçæ¬å· ð ](/problems/IDBivT)

</details>
</div>





