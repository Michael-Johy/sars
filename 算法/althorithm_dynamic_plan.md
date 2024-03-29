# 动态规划问题
* 一般形式(求最值)
* 三要素
  * 重叠子问题
  * 最优子结构
  * 状态转移方程(如何把dp[i+1]和dp[i]关联起来)
* 优化技巧
  * 状态压缩:当状态转移只需要DP table中的一部分就可以尝试状态压缩
* 状态转移方程思考过程
  明确base case -> 明确状态 -> 明确选择 -> 定义dp数组或函数的含义
* 解法
  * 带备忘录的递归解法(自顶向下)
  * 带dp数组的迭代解法(自低向上)
* 模版
  dp[0][0] ... =base
    for 状态1 in 状态1的所有值
      for 状态2 in 状态2的所有值 ....
        dp[状态1][状态2] = 求最值(选择1， 选择2)


# 股票买卖问题(动态规划)
* 分析思路 dp[i][k][o or 1]
  其中： 0<=i<n n为天数 1<=k<=K K为最大交易次数 o or 1 表示当天持有股票或不持有股票 for 0<=i<=n for 1<=k<=K for [0, 1]
  dp[i][k][0] = max(选择1， 选择2)
  dp[i][k][1] = max(可选11， 可选22)
* 模版 第i天不持有股票:前一天不持有或前一天持有，当天卖掉 dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
  第i天持有股票:前一天持有股票或前一天不持有股票，当天买入 dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] -prices[i])
  
# 打家劫舍问题
* 分析思路 状态：房子的索引index 选择：抢或不抢

# 背包问题
## 0-1背包问题
## 子集背包问题(切分成2个相同的子集)
## 完全背包问题(凑零钱问题)
* 分析思路: dp[i][j] 若只在前i个物品中选择，若当前背包的容量为j，则最多有dp[i][j]种方法可刚好填满背包

# 子序列类型
## 最短编辑距离
* 解决两个字符串的动态规划问题，一般都是用两个指针 i,j 分别指向两个字符串的最后，然后一步步往前走，缩小问题的规模
* 分析思路: 状态是当前索引，选择是插入、删除、替换、啥都不做
* dp(s[0, i], t[0, j]) 返回s[0-i] 和t[0-j]的最短编辑距离

## 最长递增子序列问题 & 最大子数组只和
* 分析思路： dp[i] 表示以num[i] 结尾的最长递增子序列。 num[i] 必须包含在内

## 信封嵌套问题(二维最长递增子序列)
* 分析思路：标准的LIS算法只能在一维数组中寻找最长递增子序列，需要把二维的转换成一维数组
* 宽度升序，高度降序，求高度最长递增子序列

## 最长公共子序列LCS
* dp(s1, i, s2, j) 计算s1[i...]和s2[j...]的最长公共子序列长度

## 模版
* 一维数组：在数组array中，以array[i]结尾的目标子序列长度是dp[i]
  题目：最长递增子序列
* 二维数组：
    涉及到2个字符串或数组时，在子数组arr1[0..i]和arr2[0..j]中，我们要求的子序列长度为dp[i][j]
      解决LCS和最短编辑距离问题
    涉及到一个字符串或数组时,在子数组arr[i...j]中，我们要求的子序列(最长回文子序列)长度是dp[i][j]
  
# 贪心算法：特殊的动态规划问题
* 区间调度问题：最多可以参加几个活动[start, end]

# dp数组定义方法(二维数组)
* 自底向上： 从(0, 0) 走到位置(i, j)的最小路径是dp(grid[][], i, j)
* 自顶向下： 从(i, j) 走到位置(m, n)的最小路径是dp(grid[][], i, j)
  通过画图，找到状态转移路径