package main

import "fmt"

// 描述
// N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
//
// K名同学排成了合唱队形。
// 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
// 例子：
// 123 124 125 123 121 是一个合唱队形
// 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
// 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
//
// 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
//
// 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
//
// 数据范围：
// 1
// ≤
// �
// ≤
// 3000
//
// 1≤n≤3000
//
// 输入描述：
// 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
//
// 输出描述：
// 最少需要几位同学出列
//
// 示例1
// 输入：
// 8
// 186 186 150 200 160 130 197 200
// 复制
// 输出：
// 4
// 复制
// 说明：
// 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
func main() {
	var n, scanN int
	var heights []int

	for {
		//输入接受
		scanN, _ = fmt.Scan(&n)
		if scanN == 0 {
			break
		}
		heights = make([]int, n)
		for i := 0; i < n; i++ {
			//输出接受函数
			fmt.Scan(&heights[i])
		}

		fmt.Println(chorus(heights))
	}
}

// 合唱队的解法
// 使用动态规划分别求得每个人左边与右边的最多人数，进而获取合唱队的最多人数，最终求得最少出队人数
// 类似于 LeetCode 中求取最大的自增子序列的长度的一道题目，不过这个题目需要 左边的最大子序列 和 右边的最大子序列的降序 输出
func chorus(heights []int) int {
	// 两个数组，分别代表每一个人左边，右边最多站多少人
	var leftMost, rightMost = make([]int, len(heights)), make([]int, len(heights))

	// 以每一个人为中心求解每一个人左边最多站多少人
	// 小的 dp 方程应该是什么样子的？
	// dp[i],也就是从 0 开始，到 i  小于array[i] 的数，并且保持递增的顺序
	// dp[i] = max{dp[i-1] +1 , dp[i-2]+1}   heights[i] 必须小于 array[i]
	for center := 1; center < len(heights); center++ {
		for i := 0; i < center; i++ {
			if heights[center] > heights[i] && leftMost[center] < leftMost[i]+1 {
				leftMost[center] = leftMost[i] + 1
			}
		}
	}

	for center := len(heights) - 2; center >= 0; center-- {
		for i := len(heights) - 1; i > center; i-- {
			if heights[center] > heights[i] && rightMost[center] < rightMost[i]+1 {
				rightMost[center] = rightMost[i] + 1
			}
		}
	}

	// 获取合唱队的最多人数
	var max = 1
	for i := 0; i < len(heights); i++ {
		if max < leftMost[i]+rightMost[i]+1 {
			max = leftMost[i] + rightMost[i] + 1
		}
	}
	return len(heights) - max
}
