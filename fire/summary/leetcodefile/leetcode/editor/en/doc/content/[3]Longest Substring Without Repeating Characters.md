<p>Given a string <code>s</code>, find the length of the <strong>longest substring</strong> without repeating characters.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abcabcbb&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is &quot;abc&quot;, with the length of 3.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;bbbbb&quot;
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is &quot;b&quot;, with the length of 1.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;pwwkew&quot;
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is &quot;wke&quot;, with the length of 3.
Notice that the answer must be a substring, &quot;pwke&quot; is a subsequence and not a substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
</ul>
<div><div>Related Topics</div><div><li>Hash Table</li><li>String</li><li>Sliding Window</li></div></div><br><div><li>ð 20232</li><li>ð 919</li></div>

<div id="labuladong"><hr>

**éç¥ï¼[æ°æ®ç»æç²¾åè¯¾ V1.8](https://aep.h5.xeknow.com/s/1XJHEO) æç»­æ´æ°ä¸­ï¼[ç¬¬åæå·é¢æå¡ææ](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) æ¥åå³å°æªæ­¢ã**



<p><strong><a href="https://labuladong.github.io/article?qno=3" target="_blank">â­ï¸labuladong é¢è§£</a></strong></p>
<details><summary><strong>labuladong æè·¯</strong></summary>

## åºæ¬æè·¯

> æ¬ææè§é¢çï¼[æ»å¨çªå£ç®æ³æ ¸å¿æ¨¡æ¿æ¡æ¶](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PSï¼è¿éé¢å¨[ãç®æ³å°æã](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) çç¬¬ 85 é¡µã

è¿é¢æ¯å¶ä»æ»å¨çªå£çé¢ç®ç®åï¼è¿ `need` å `valid` é½ä¸éè¦ï¼èä¸æ´æ°çªå£åæ°æ®ä¹åªéè¦ç®åçæ´æ°è®¡æ°å¨ `window` å³å¯ã

å½ `window[c]` å¼å¤§äº 1 æ¶ï¼è¯´æçªå£ä¸­å­å¨éå¤å­ç¬¦ï¼ä¸ç¬¦åæ¡ä»¶ï¼å°±è¯¥ç§»å¨ `left` ç¼©å°çªå£äºã

å¦å¤ï¼è¦å¨æ¶ç¼©çªå£å®æåæ´æ° `res`ï¼å ä¸ºçªå£æ¶ç¼©ç while æ¡ä»¶æ¯å­å¨éå¤åç´ ï¼æ¢å¥è¯è¯´æ¶ç¼©å®æåä¸å®ä¿è¯çªå£ä¸­æ²¡æéå¤ã

**è¯¦ç»é¢è§£ï¼[æåäºé¦è¯ï¼ææ»å¨çªå£ç®æ³åæäºé»åé¢](https://labuladong.github.io/article/fname.html?fname=æ»å¨çªå£æå·§è¿é¶)**

**æ ç­¾ï¼[æ»å¨çªå£](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## è§£æ³ä»£ç 

```cpp
class Solution {
    public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;

        int left = 0, right = 0;
        int res = 0; // è®°å½ç»æ
        while (right < s.size()) {
            char c = s[right];
            right++;
            // è¿è¡çªå£åæ°æ®çä¸ç³»åæ´æ°
            window[c]++;
            // å¤æ­å·¦ä¾§çªå£æ¯å¦è¦æ¶ç¼©
            while (window[c] > 1) {
                char d = s[left];
                left++;
                // è¿è¡çªå£åæ°æ®çä¸ç³»åæ´æ°
                window[d]--;
            }
            // å¨è¿éæ´æ°ç­æ¡
            res = max(res, right - left);
        }
        return res;
    }
};
```

**ç±»ä¼¼é¢ç®**ï¼
  - [438. æ¾å°å­ç¬¦ä¸²ä¸­ææå­æ¯å¼ä½è¯ ð ](/problems/find-all-anagrams-in-a-string)
  - [567. å­ç¬¦ä¸²çæå ð ](/problems/permutation-in-string)
  - [76. æå°è¦çå­ä¸² ð´](/problems/minimum-window-substring)
  - [åæ Offer 48. æé¿ä¸å«éå¤å­ç¬¦çå­å­ç¬¦ä¸² ð ](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)
  - [åæ Offer II 014. å­ç¬¦ä¸²ä¸­çåä½è¯ ð ](/problems/MPnaiL)
  - [åæ Offer II 015. å­ç¬¦ä¸²ä¸­çææåä½è¯ ð ](/problems/VabMRr)
  - [åæ Offer II 016. ä¸å«éå¤å­ç¬¦çæé¿å­å­ç¬¦ä¸² ð ](/problems/wtcaE1)
  - [åæ Offer II 017. å«æææå­ç¬¦çæç­å­ç¬¦ä¸² ð´](/problems/M1oyTv)

</details>
</div>

