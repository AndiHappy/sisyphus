<p>Given an input string <code>s</code>&nbsp;and a pattern <code>p</code>, implement regular expression matching with support for <code>&#39;.&#39;</code> and <code>&#39;*&#39;</code> where:</p>

<ul>
	<li><code>&#39;.&#39;</code> Matches any single character.​​​​</li>
	<li><code>&#39;*&#39;</code> Matches zero or more of the preceding element.</li>
</ul>

<p>The matching should cover the <strong>entire</strong> input string (not partial).</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;, p = &quot;a&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> &quot;a&quot; does not match the entire string &quot;aa&quot;.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aa&quot;, p = &quot;a*&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> &#39;*&#39; means zero or more of the preceding element, &#39;a&#39;. Therefore, by repeating &#39;a&#39; once, it becomes &quot;aa&quot;.
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;ab&quot;, p = &quot;.*&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> &quot;.*&quot; means &quot;zero or more (*) of any character (.)&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length&nbsp;&lt;= 20</code></li>
	<li><code>1 &lt;= p.length&nbsp;&lt;= 30</code></li>
	<li><code>s</code> contains only lowercase English letters.</li>
	<li><code>p</code> contains only lowercase English letters, <code>&#39;.&#39;</code>, and&nbsp;<code>&#39;*&#39;</code>.</li>
	<li>It is guaranteed for each appearance of the character <code>&#39;*&#39;</code>, there will be a previous valid character to match.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>String | Dynamic Programming | Recursion</details><br>

<div>👍 8991, 👎 1403</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；[第十期刷题打卡挑战](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 报名即将截止。**



<p><strong><a href="https://labuladong.github.io/article?qno=10" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 155 页。

`s` 和 `p` 相互匹配的过程大致是，两个指针 `i, j` 分别在 `s` 和 `p` 上移动，如果最后两个指针都能移动到字符串的末尾，那么就匹配成功，反之则匹配失败。

正则表达算法问题只需要把住一个基本点：看 `s[i]` 和 `p[j]` 两个字符是否匹配，一切逻辑围绕匹配/不匹配两种情况展开即可。

动态规划算法的核心就是「状态」和「选择」，**「状态」无非就是 `i` 和 `j` 两个指针的位置，「选择」就是模式串的 `p[j]` 选择匹配几个字符**。

`dp` 函数的定义如下：

**若 `dp(s, i, p, j) = true`，则表示 `s[i..]` 可以匹配 `p[j..]`；若 `dp(s, i, p, j) = false`，则表示 `s[i..]` 无法匹配 `p[j..]`**。

**详细题解：[经典动态规划：正则表达式](https://labuladong.github.io/article/fname.html?fname=动态规划之正则表达)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，字符串**

## 解法代码

```cpp
class Solution {
    public:
    // 备忘录
    vector<vector<int>> memo;

    bool isMatch(string s, string p) {
        int m = s.size(), n = p.size();
        memo = vector<vector<int>>(m, vector<int>(n, -1));
        // 指针 i，j 从索引 0 开始移动
        return dp(s, 0, p, 0);
    }

    /* 计算 p[j..] 是否匹配 s[i..] */
    bool dp(string& s, int i, string& p, int j) {
        int m = s.size(), n = p.size();
        // base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p[j + 1] != '*') {
                    return false;
                }
            }
            return true;
        }

        // 查备忘录，防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        bool res = false;

        if (s[i] == p[j] || p[j] == '.') {
            if (j < n - 1 && p[j + 1] == '*') {
                res = dp(s, i, p, j + 2)
                        || dp(s, i + 1, p, j);
            } else {
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p[j + 1] == '*') {
                res = dp(s, i, p, j + 2);
            } else {
                res = false;
            }
        }
        // 将当前结果记入备忘录
        memo[i][j] = res;
        return res;
    }
};
```

**类似题目**：
  - [44. 通配符匹配 🔴](/problems/wildcard-matching)
  - [剑指 Offer 19. 正则表达式匹配 🔴](/problems/zheng-ze-biao-da-shi-pi-pei-lcof)

</details>
</div>





