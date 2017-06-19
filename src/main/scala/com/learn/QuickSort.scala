package com.learn

/**
  * Created by admin on 2017/6/16.
  */
class QuickSort {
  /**
    * 交换元素
    * @param xs
    */
  def sort(xs: Array[Int]): Unit ={
    def swap(i: Int, j: Int): Unit ={
      val t = xs(i); xs(i) = xs(j); xs(j) = t;
    }

    /**
      * 排序
      *   首先取数组中的中间值 pivot
      *   对数据进行遍历
      *
      * @param l
      * @param r
      */
    def sort1(l: Int, r: Int): Unit ={
      val pivot = xs((l + r) /2)
      var i = l; var j = r;
      while (i < j){
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if(i <= j){
          swap(i, j)
          i += 1;
          j -= 1;
        }
      }
      if(l < j) sort1(l, j)
      if(j < r) sort1(i, r)

    }
    sort1(0, xs.length -1 )
  }

  /**
    *   如果数组为空，或者只包含一个元素，则数组已经是有序的，直接返回。
    *   如果数组不为空（译注：且长度>1，原文没有说），则取居中的元素作为基准（pivot）。
    *   把数组中小于基准和大于基准的元素分别放进两个数组，等于基准的元素放入第三 个数组
    *   递归调用 sort 方法，对前两个数组进行排序1。
    *   把三个数组合并起来，就得到排序结果。
    * @param xs
    * @return
    */
  def sortS(xs: Array[Int]): Array[Int] ={
    if(xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(sortS(xs.filter(pivot >)),
        xs.filter(pivot ==),
        xs.filter(pivot <))
    }
  }

}
object QuickSort extends App{
  val quickSort = new QuickSort()
  val list = Array(1,3,5,7,2,3,32,3,3,21,3,21,321,3)

//  quickSort.sort(list)
  quickSort.sortS(list).map(x => print(x + " "))


}