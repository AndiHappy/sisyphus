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

<div>👍 14650, 👎 552</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；[第十期刷题打卡挑战](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 报名即将截止。**



<p><strong><a href="https://labuladong.github.io/article?qno=22" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 306 页。

本题可以改写为：

现在有 `2n` 个位置，每个位置可以放置字符 `(` 或者 `)`，组成的所有括号组合中，有多少个是合法的？

这就是典型的回溯算法提醒，暴力穷举就行了。

不过为了减少不必要的穷举，我们要知道合法括号串有以下性质：

**1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解**。

**2、对于一个「合法」的括号字符串组合 `p`，必然对于任何 ` 0 <= i < len(p)` 都有：子串 `p[0..i]` 中左括号的数量都大于或等于右括号的数量**。

因为从左往右算的话，肯定是左括号多嘛，到最后左右括号数量相等，说明这个括号组合是合法的。

用 `left` 记录还可以使用多少个左括号，用 `right` 记录还可以使用多少个右括号，就可以直接套用 [回溯算法套路框架](https://labuladong.github.io/article/fname.html?fname=回溯算法详解修订版) 了。

**详细题解：[回溯算法最佳实践：括号生成](https://labuladong.github.io/article/fname.html?fname=合法括号生成)**

**标签：[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)**

## 解法代码

```java
class Solution {
    public:
    vector<string> generateParenthesis(int n) {
        if (n == 0) return {};
        // 记录所有合法的括号组合
        vector<string> res;
        // 回溯过程中的路径
        string track;
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n, n, track, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    void backtrack(int left, int right, 
                string& track, vector<string>& res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.push_back(track);
            return;
        }
        
        // 尝试放一个左括号
        track.push_back('('); // 选择
        backtrack(left - 1, right, track, res);
        track.pop_back(); // 撤消选择

        // 尝试放一个右括号
        track.push_back(')'); // 选择
        backtrack(left, right - 1, track, res);
        track.pop_back(); // 撤消选择
    }
}
```

**类似题目**：
  - [剑指 Offer II 085. 生成匹配的括号 🟠](/problems/IDBivT)

</details>
</div>





