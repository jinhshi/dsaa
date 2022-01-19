package per.chaos.dsaa

import per.chaos.UnitSpec

class SortSolutionTest extends UnitSpec {
  def fixture =
    new {
      val array = Array(4, 2, 7, 1, 3)
    }

  "An array" should "sorted after bubble sort" in {

    val arr = fixture.array

    SortSolution.bubbleSort(arr) shouldBe sorted
  }

  it should "sorted after selection sort" in {

    val arr = fixture.array

    SortSolution.selectionSort(arr) shouldBe sorted
  }

  it should "sorted after insertion sort" in {
    
    val arr = fixture.array

    SortSolution.insertionSort(arr) shouldBe sorted
  }


}
