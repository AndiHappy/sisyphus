<p>You are given the heads of two sorted linked lists <code>list1</code> and <code>list2</code>.</p>

<p>Merge the two lists in a one <strong>sorted</strong> list. The list should be made by splicing together the nodes of the first two lists.</p>

<p>Return <em>the head of the merged linked list</em>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" />
<pre>
<strong>Input:</strong> list1 = [1,2,4], list2 = [1,3,4]
<strong>Output:</strong> [1,1,2,3,4,4]
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = []
<strong>Output:</strong> []
</pre>

<p><strong>Example 3:</strong></p>

<pre>
<strong>Input:</strong> list1 = [], list2 = [0]
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in both lists is in the range <code>[0, 50]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>Both <code>list1</code> and <code>list2</code> are sorted in <strong>non-decreasing</strong> order.</li>
</ul>
<details><summary><strong>Related Topics</strong></summary>Linked List | Recursion</details><br>

<div>ð 14245, ð 1276</div>

<div id="labuladong"><hr>

**éç¥ï¼[æ°æ®ç»æç²¾åè¯¾ V1.8](https://aep.h5.xeknow.com/s/1XJHEO) æç»­æ´æ°ä¸­ï¼[ç¬¬åæå·é¢æå¡ææ](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) æ¥åå³å°æªæ­¢ã**



<p><strong><a href="https://labuladong.github.io/article?qno=21" target="_blank">â­ï¸labuladong é¢è§£</a></strong></p>
<details><summary><strong>labuladong æè·¯</strong></summary>

## åºæ¬æè·¯

> æ¬ææè§é¢çï¼[é¾è¡¨åæéæå·§å¨é¢æ±æ»](https://www.bilibili.com/video/BV1q94y1X7vy)

ç»å¸ç®æ³é¢äºï¼[åæéæå·§](https://labuladong.github.io/article/fname.html?fname=é¾è¡¨æå·§) ç¨èµ·æ¥ã

![](https://labuladong.github.io/algo/images/é¾è¡¨æå·§/1.gif)

è¿ä¸ªç®æ³çé»è¾ç±»ä¼¼äºãææé¾ãï¼`l1, l2` ç±»ä¼¼äºæé¾ä¸¤ä¾§çé¯é½¿ï¼æé `p` å°±å¥½åæé¾çæç´¢ï¼å°ä¸¤ä¸ªæåºé¾è¡¨åå¹¶ã

**ä»£ç ä¸­è¿ç¨å°ä¸ä¸ªé¾è¡¨çç®æ³é¢ä¸­æ¯å¾å¸¸è§çãèæå¤´ç»ç¹ãæå·§ï¼ä¹å°±æ¯ `dummy` èç¹**ï¼å®ç¸å½äºæ¯ä¸ªå ä½ç¬¦ï¼å¯ä»¥é¿åå¤çç©ºæéçæåµï¼éä½ä»£ç çå¤ææ§ã

**è¯¦ç»é¢è§£ï¼[åæéæå·§ç§æä¸éé¾è¡¨é¢ç®](https://labuladong.github.io/article/fname.html?fname=é¾è¡¨æå·§)**

**æ ç­¾ï¼[æ°æ®ç»æ](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)ï¼[é¾è¡¨](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)ï¼[é¾è¡¨åæé](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## è§£æ³ä»£ç 

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // èæå¤´ç»ç¹
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {/**<extend down -200>

![](https://labuladong.github.io/algo/images/é¾è¡¨æå·§/1.gif)
*/
            // æ¯è¾ p1 å p2 ä¸¤ä¸ªæé
            // å°å¼è¾å°ççèç¹æ¥å° p æé
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p æéä¸æ­åè¿
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;
    }
}
```

**ç±»ä¼¼é¢ç®**ï¼
  - [1305. ä¸¤æ£µäºåæç´¢æ ä¸­çææåç´  ð ](/problems/all-elements-in-two-binary-search-trees)
  - [141. ç¯å½¢é¾è¡¨ ð¢](/problems/linked-list-cycle)
  - [142. ç¯å½¢é¾è¡¨ II ð ](/problems/linked-list-cycle-ii)
  - [160. ç¸äº¤é¾è¡¨ ð¢](/problems/intersection-of-two-linked-lists)
  - [19. å é¤é¾è¡¨çåæ°ç¬¬ N ä¸ªç»ç¹ ð ](/problems/remove-nth-node-from-end-of-list)
  - [23. åå¹¶Kä¸ªååºé¾è¡¨ ð´](/problems/merge-k-sorted-lists)
  - [264. ä¸æ° II ð ](/problems/ugly-number-ii)
  - [313. è¶çº§ä¸æ° ð ](/problems/super-ugly-number)
  - [86. åéé¾è¡¨ ð ](/problems/partition-list)
  - [876. é¾è¡¨çä¸­é´ç»ç¹ ð¢](/problems/middle-of-the-linked-list)
  - [88. åå¹¶ä¸¤ä¸ªæåºæ°ç» ð¢](/problems/merge-sorted-array)
  - [97. äº¤éå­ç¬¦ä¸² ð ](/problems/interleaving-string)
  - [977. æåºæ°ç»çå¹³æ¹ ð¢](/problems/squares-of-a-sorted-array)
  - [åæ Offer 22. é¾è¡¨ä¸­åæ°ç¬¬kä¸ªèç¹ ð¢](/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof)
  - [åæ Offer 25. åå¹¶ä¸¤ä¸ªæåºçé¾è¡¨ ð¢](/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof)
  - [åæ Offer 52. ä¸¤ä¸ªé¾è¡¨çç¬¬ä¸ä¸ªå¬å±èç¹ ð¢](/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof)
  - [åæ Offer II 021. å é¤é¾è¡¨çåæ°ç¬¬ n ä¸ªç»ç¹ ð ](/problems/SLwz0R)
  - [åæ Offer II 022. é¾è¡¨ä¸­ç¯çå¥å£èç¹ ð ](/problems/c32eOV)
  - [åæ Offer II 023. ä¸¤ä¸ªé¾è¡¨çç¬¬ä¸ä¸ªéåèç¹ ð¢](/problems/3u1WK4)
  - [åæ Offer II 078. åå¹¶æåºé¾è¡¨ ð´](/problems/vvXgSW)

</details>
</div>



