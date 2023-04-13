# GridHeapSort
Heap sort for N*N grids in Java

Heap sort is an in-place but unstable sorthing algorithm. This is its implementation to sort a N * N grid. The integer "compares" allows to check how many actual compares it took to sort the grid. In heap-sort, the average case time complexity is usually O(nlog(n)), and n here would be the number of elements in the grid (which will be N^2).

After doing same basic experimenting to figure out the number of compares it takes to sort N = 10 to 200 (incremented by 10) length grids populated with random integers in java, the best-fit curve for compares done came out to be x^1.15.
