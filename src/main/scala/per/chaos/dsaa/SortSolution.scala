package per.chaos.dsaa

object SortSolution {

  /** 冒泡排序
    *
    * <ol> <li>1.指向数组中相邻的两个元素（最开始是数组的头两个元素），比较两者大小 </li>
    * <li>2.如果两者的顺序反了（即左边的值大于右边），就互换位置。如果顺序是正确的，此步什么都不用做。</li>
    * <li>3.将两个指针右移一格（此时是数组的第二和第三个元素），重复第1和第2步，直至指针达到数组的末尾</li>
    * <li>4.重复第1～3步，直至从头到尾无须再做交换。这时数组就排好序了。</li> </ol>
    * @param arr
    * @return
    */
  def bubbleSort(arr: Array[Int]): Array[Int] = {
    // 该索引之前的数据都没排过序, 刚开始所有的数据都是未排序的，所以值为数组的最后一个索引。
    var unsortedUntilIndex = arr.length - 1
    // 记录数组是否已经有序，初始为 false
    var sorted = false
    // 未有序之前一直循环
    while (!sorted) {
      // 先设置为true，发生任何交换的时候，设置为false。如果没有发生交换，就可以确定已经排好序了。
      sorted = true
      for (i <- 0 until unsortedUntilIndex) {
        // 比较相邻元素，如果有顺序错误，就进行交换，并将sorted改为false
        if (arr(i) > arr(i + 1)) {
          sorted = false
          val temp = arr(i)
          arr(i) = arr(i + 1)
          arr(i + 1) = temp

        }
      }
      unsortedUntilIndex -= 1
    }
    arr
  }

  /** 选择排序
    *
    * <ul><li>1.从左至右检查每一个元素，找出值最小的那个。在此过程中，我们用变量记住检查过的数字的最小值（记的是索引）。
    * 如果一个格子中的数字比记录的最小值还要小，就把最小值改成该格子的索引。</li>
    * <li>2.知道哪个格子的值最小之后，将该格子与本次检查的起点交换。第一次检查的起点索引是0，第二次是1，以此类推。</li>
    * <li>3.重复第1～2步，直至数组排好序。 </li></ul>
    * @param arr
    * @return
    */
  def selectionSort(arr: Array[Int]): Array[Int] = {
    // 外层循环代表每一轮检查
    for (i <- 0 until arr.length) {
      // 此变量将记录本轮最小值的索引
      var lowestNumberIndex: Int = i 
      // 发起一个以 i + 1 开始的内层循环
      // 循环内逐个检查未排序的数值，若遇到比之前记录的本轮最小值还小的数值，就将lowestNumberIndex更新为该值的索引。
      // 内层循环结束后会得到未排序数值中最小值的索引。
      for (j  <- i + 1 until arr.length) {
        if (arr(j) < arr(lowestNumberIndex)) {
          lowestNumberIndex = j
        }
      }
      // 检查最小值是否在正确的位置，即该索引是否等于i。如果不是就将i所指的指与最小值交换。
      if (lowestNumberIndex != i) {
        val temp = arr(i)
        arr(i) = arr(lowestNumberIndex)
        arr(lowestNumberIndex) = temp
      }
    }

    arr
  }

  /**
    * 插入排序
    * 
    * <ul>
    * <li>1.在第一轮中，将索引为2的值移走，并用一个临时变量来保存它，这使得该索引处留下一个空隙，因为他不包含值，在之后的轮回，移走后面索引的值</li>
    * <li>2.接下来是平移阶段。拿空隙左侧的每一个值与临时变量进行比较。如果空隙左侧的值大于临时变量的值，就将该值右移。随着右移，空隙会左移。
    *   如果遇到比临时变量小的值，或者空隙已经到了数组的最左端，就结束平移阶段。</li>
    * <li>3.将临时移走的值插入当前空隙</li>
    * <li>4.重复第1～3步，直至数组完全有序</li>
    * </ul>
    *
    * @param arr
    * @return
    */
  def insertionSort(arr: Array[Int]): Array[Int] = {
    // 从索引1开始循环遍历数组
    for (index <- 1 until arr.length) {
      // 空隙的索引
      var position = index
      // 临时变量的值
      var tempValue = arr(index)
      // 内层循环 检查临时变量左边的值是否大于临时变量，若是，则将该值右移，空隙左移。然后继续检查空隙左边的值是否大于临时变量的值......
      // 如此重复，直至遇到的值比临时变量小
      while (position > 0 && arr(position - 1) > tempValue) {
        arr(position) = arr(position - 1)
        position -= 1
      }
      // 最后，将临时变量放回数组的空隙中。
      arr(position) = tempValue
    }

    arr
  }
}
