This project offers efficient text search functionality without using out of the box solutions like Lucene or Solr. It should work on any valid folder path.
The solution will use BFS to traverse through the directory structure of the input path. Once all the files have been identified & listed, it reads the files & builds a Search Index on each File. The Index is a Trie, optimised for the specific scenario . 
Solution has been tested on the redis codebase. Indexing happens very fast & each individual query returns matching results from all files in sub-second time. For each match, the line in which the match occurs is returned.

Each query should return in O(N*K) time (worst case), where N-> search term length, K->no of files

This was a Tech Challenge posted as part of a Hiring process 

Currently it works for any file using charset 0-255, but can be extended to full Unicode by just modifying the size of the pointer array in each trie node.

Currently only single term search is supported. Prefix search can be implemented easily & I plan to implement it soon. Multi term search is not possible without something like Suffix Tree. But suffix tree based index is running out of heap space when the number & size of files is large.

How To Use:-

>Run the solution

>Enter Directory\file Path

>Enter query term

>If you wish to enter more queries enter true when prompted
