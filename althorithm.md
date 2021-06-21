# 算法
* 递归算法关键：明确函数的定义是什么;相信这个定义，根据这个定义推导最终的结果，不要陷入递归的细节



# 回溯算法

* 解决问题
    * N皇后
    * 全排列
* 特点
    * DFS算法
    * 暴力求解算法(无重叠子问题)
* 三要素
    * 结束条件
    * 选择列表
    * 路径
* 模版 result = []
  void backTrack(路径, 选择)
  if 满足结束条件 result.add(路径)
  return; for item in 选择 路径.add(item)
  backTrack(路径, 选择)
  路径.remove(item)

# BFS

* 解决问题(求最短路径)
    * 开锁问题
    * 走迷宫问题
* 特点
    * 一般使用链表结构，不断加入当前节点的相邻节点, 满足条件时则退出
* 模版 void bfs(head)
  queue.add(head); steps = 0; while(queue is not empty){ int size = queue.size(); for i=0;i<size;i++{ item =
  queue.poll(); if item 满足条件 return steps; queue.addAll(item.neighbors) //所有相邻节点 } steps++; }

# 二分搜索

* 解决问题(有序数组中查找某个元素，或元素左边界，或元素右边界, 搜索空间有序)
* 模版 int bs(int[] nums, int target)
  int left=0; int right=nums.length-1; while(left<=right){ int mid=left+(right-left)/2; if (nums[mid] == target){ return
  mid; //查找元素 right=mid-1; //左边界, 向左收缩 left=mid+1; //右边界, 向右收缩 }else if(nums[mid] > target){ right = mid-1; //查找元素, 左边界,
  右边界 }else if(nums[mid] < target){ left = mid+1; //查找元素, 左边界, 右边界 } } return -1; //查找元素 //左边界 if (left > nums.length ||
  nums[left] != target){ return -1; } return left; //右边界 if (right < 0 || nums[right] != target){ return -1; } return
  right;

# 双指针

* 类型以及解决问题
    * 快慢指针(链表 - 是否有环，环起始节点，链表中间，lastN节点)
    * 左右指针(数组 - 数组倒序，二分搜索， 2数之和)
    * 滑动窗口
        * 最小字串问题 即source包含所有target的元素, 满足条件了左侧需要收缩
        * 字符串排列问题 即source包含所有target元素，且不包含其它元素。 注意包含的元素多了要去除 出现重复了，左侧收缩去除重复元素

* 滑动窗口模版 String minSubString(source, target){ char[] targets = target.toCharArray(); Map<Character, Integer> need = new
  HashMap<>(); for(char item : targets){ need.put(item, need.getOrDefault(item, 0) + 1)
  } Map<Character, Integer> window = new HashMap<>(); char[] sources = source.toCharArray(); int end = sources.length;
  int left =0;right=0; int resultStart = 0; int resultLength = Integer.MAX_VALUE; while(right < end){ //增大窗口 window.add(
  sources[right])
  //更新结果 right++; while(结果满足条件){ //收缩窗口 resultLength = right-left; resultStart = left; leftV = sources[left]; left++
  //更新结果， } } }

# 区间问题

* 线段起始位置升序，结束位置降序

# nsum问题

* 2sum时可以采用hashMap帮助减少时间
* nsum时

# 二叉树

* 写二叉树的算法，都是基于递归框架的。先搞清楚当前root节点该做什么，然后根据函数定义递归调用子节点
* 模版 void traverse(TreeNode root){ //先序遍历 traverse(root.left); //中序遍历 traverse(root.right); //后序遍历 }
    


    
    