<p>Given the <code>head</code> of a linked list, remove the <code>n<sup>th</sup></code> node from the end of the list and return its head.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/remove_ex1.jpg" style="width: 542px; height: 222px;" />
<pre>
<strong>Input:</strong> head = [1,2,3,4,5], n = 2
<strong>Output:</strong> [1,2,3,5]
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> head = [1], n = 1
<strong>Output:</strong> []
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> head = [1,2], n = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is <code>sz</code>.</li>
	<li><code>1 &lt;= sz &lt;= 30</code></li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
	<li><code>1 &lt;= n &lt;= sz</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you do this in one pass?</p>
<details><summary><strong>Related Topics</strong></summary>Linked List | Two Pointers</details><br>

<div>ð 11874, ð 527</div>

<div id="labuladong"><hr>

**éç¥ï¼[æ°æ®ç»æç²¾åè¯¾ V1.8](https://aep.h5.xeknow.com/s/1XJHEO) æç»­æ´æ°ä¸­ï¼[ç¬¬åæå·é¢æå¡ææ](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) æ¥åå³å°æªæ­¢ã**



<p><strong><a href="https://labuladong.github.io/article?qno=19" target="_blank">â­ï¸labuladong é¢è§£</a></strong></p>
<details><summary><strong>labuladong æè·¯</strong></summary>

## åºæ¬æè·¯

> æ¬ææè§é¢çï¼[é¾è¡¨åæéæå·§å¨é¢æ±æ»](https://www.bilibili.com/video/BV1q94y1X7vy)

PSï¼è¿éé¢å¨[ãç®æ³å°æã](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) çç¬¬ 64 é¡µã

è¦å é¤åæ°ç¬¬ `n` ä¸ªèç¹ï¼å°±å¾è·å¾åæ°ç¬¬ `n + 1` ä¸ªèç¹çå¼ç¨ã

è·ååé¾è¡¨çåæ°ç¬¬ `k` ä¸ªèç¹ï¼å°±æ¯æ³èå¯ [åæéæå·§](https://labuladong.github.io/article/fname.html?fname=é¾è¡¨æå·§) ä¸­å¿«æ¢æéçè¿ç¨ï¼ä¸è¬é½ä¼è¦æ±ä½ **åªéåä¸æ¬¡é¾è¡¨**ï¼å°±ç®åºåæ°ç¬¬ `k` ä¸ªèç¹ã

ç¬¬ä¸æ­¥ï¼æä»¬åè®©ä¸ä¸ªæé `p1` æåé¾è¡¨çå¤´èç¹ `head`ï¼ç¶åèµ° `k` æ­¥ï¼

![](https://labuladong.github.io/algo/images/é¾è¡¨æå·§/1.jpeg)

ç¬¬äºæ­¥ï¼ç¨ä¸ä¸ªæé `p2` æåé¾è¡¨å¤´èç¹ `head`ï¼

![](https://labuladong.github.io/algo/images/é¾è¡¨æå·§/2.jpeg)

ç¬¬ä¸æ­¥ï¼è®© `p1` å `p2` åæ¶ååèµ°ï¼`p1` èµ°å°é¾è¡¨æ«å°¾çç©ºæéæ¶èµ°äº `n - k` æ­¥ï¼`p2` ä¹èµ°äº `n - k` æ­¥ï¼ä¹å°±æ¯é¾è¡¨çåæ°ç¬¬ `k` ä¸ªèç¹ï¼

![](https://labuladong.github.io/algo/images/é¾è¡¨æå·§/3.jpeg)

è¿æ ·ï¼åªéåäºä¸æ¬¡é¾è¡¨ï¼å°±è·å¾äºåæ°ç¬¬ `k` ä¸ªèç¹ `p2`ã

è§£æ³ä¸­å¨é¾è¡¨å¤´é¨æ¥ä¸ä¸ªèæèç¹ `dummy` æ¯ä¸ºäºé¿åå é¤åæ°ç¬¬ä¸ä¸ªåç´ æ¶åºç°ç©ºæéå¼å¸¸ï¼å¨å¤´é¨å å¥ `dummy` èç¹å¹¶ä¸å½±åå°¾é¨åæ°ç¬¬ `k` ä¸ªåç´ æ¯ä»ä¹ã

**è¯¦ç»é¢è§£ï¼[åæéæå·§ç§æä¸éé¾è¡¨é¢ç®](https://labuladong.github.io/article/fname.html?fname=é¾è¡¨æå·§)**

**æ ç­¾ï¼[æ°æ®ç»æ](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)ï¼[é¾è¡¨](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)ï¼[é¾è¡¨åæé](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## è§£æ³ä»£ç 

```java
class Solution {
    // ä¸»å½æ°
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // èæå¤´ç»ç¹
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // å é¤åæ°ç¬¬ n ä¸ªï¼è¦åæ¾åæ°ç¬¬ n + 1 ä¸ªèç¹
        ListNode x = findFromEnd(dummy, n + 1);
        // å æåæ°ç¬¬ n ä¸ªèç¹
        x.next = x.next.next;
        return dummy.next;
    }

    // è¿åé¾è¡¨çåæ°ç¬¬ k ä¸ªèç¹
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 åèµ° k æ­¥
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 å p2 åæ¶èµ° n - k æ­¥
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 ç°å¨æåç¬¬ n - k ä¸ªèç¹
        return p2;
    }
}
```

**ç±»ä¼¼é¢ç®**ï¼
  - [141. ç¯å½¢é¾è¡¨ ð¢](/problems/linked-list-cycle)
  - [142. ç¯å½¢é¾è¡¨ II ð ](/problems/linked-list-cycle-ii)
  - [160. ç¸äº¤é¾è¡¨ ð¢](/problems/intersection-of-two-linked-lists)
  - [21. åå¹¶ä¸¤ä¸ªæåºé¾è¡¨ ð¢](/problems/merge-two-sorted-lists)
  - [23. åå¹¶Kä¸ªååºé¾è¡¨ ð´](/problems/merge-k-sorted-lists)
  - [86. åéé¾è¡¨ ð ](/problems/partition-list)
  - [876. é¾è¡¨çä¸­é´ç»ç¹ ð¢](/problems/middle-of-the-linked-list)
  - [åæ Offer 22. é¾è¡¨ä¸­åæ°ç¬¬kä¸ªèç¹ ð¢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [åæ Offer 25. åå¹¶ä¸¤ä¸ªæåºçé¾è¡¨ ð¢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [åæ Offer 52. ä¸¤ä¸ªé¾è¡¨çç¬¬ä¸ä¸ªå¬å±èç¹ ð¢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [åæ Offer II 021. å é¤é¾è¡¨çåæ°ç¬¬ n ä¸ªç»ç¹ ð ](/problems/SLwz0R)
  - [åæ Offer II 022. é¾è¡¨ä¸­ç¯çå¥å£èç¹ ð ](/problems/c32eOV)
  - [åæ Offer II 023. ä¸¤ä¸ªé¾è¡¨çç¬¬ä¸ä¸ªéåèç¹ ð¢](/problems/3u1WK4)
  - [åæ Offer II 078. åå¹¶æåºé¾è¡¨ ð´](/problems/vvXgSW)

</details>
</div>



