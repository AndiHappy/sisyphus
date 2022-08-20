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
<div><div>Related Topics</div><div><li>Hash Table</li><li>String</li><li>Sliding Window</li></div></div><br><div><li>👍 20232</li><li>👎 919</li></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；[第十期刷题打卡挑战](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 报名即将截止。**



<p><strong><a href="https://labuladong.github.io/article?qno=3" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

> 本文有视频版：[滑动窗口算法核心模板框架](https://www.bilibili.com/video/BV1AV4y1n7Zt)

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 85 页。

这题比其他滑动窗口的题目简单，连 `need` 和 `valid` 都不需要，而且更新窗口内数据也只需要简单的更新计数器 `window` 即可。

当 `window[c]` 值大于 1 时，说明窗口中存在重复字符，不符合条件，就该移动 `left` 缩小窗口了。

另外，要在收缩窗口完成后更新 `res`，因为窗口收缩的 while 条件是存在重复元素，换句话说收缩完成后一定保证窗口中没有重复。

**详细题解：[我写了首诗，把滑动窗口算法变成了默写题](https://labuladong.github.io/article/fname.html?fname=滑动窗口技巧进阶)**

**标签：[滑动窗口](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```cpp
class Solution {
    public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;

        int left = 0, right = 0;
        int res = 0; // 记录结果
        while (right < s.size()) {
            char c = s[right];
            right++;
            // 进行窗口内数据的一系列更新
            window[c]++;
            // 判断左侧窗口是否要收缩
            while (window[c] > 1) {
                char d = s[left];
                left++;
                // 进行窗口内数据的一系列更新
                window[d]--;
            }
            // 在这里更新答案
            res = max(res, right - left);
        }
        return res;
    }
};
```

**类似题目**：
  - [438. 找到字符串中所有字母异位词 🟠](/problems/find-all-anagrams-in-a-string)
  - [567. 字符串的排列 🟠](/problems/permutation-in-string)
  - [76. 最小覆盖子串 🔴](/problems/minimum-window-substring)
  - [剑指 Offer 48. 最长不含重复字符的子字符串 🟠](/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)
  - [剑指 Offer II 014. 字符串中的变位词 🟠](/problems/MPnaiL)
  - [剑指 Offer II 015. 字符串中的所有变位词 🟠](/problems/VabMRr)
  - [剑指 Offer II 016. 不含重复字符的最长子字符串 🟠](/problems/wtcaE1)
  - [剑指 Offer II 017. 含有所有字符的最短字符串 🔴](/problems/M1oyTv)

</details>
</div>

