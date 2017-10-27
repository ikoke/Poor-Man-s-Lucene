WIP ALERT- This was a Tech Challenge posted as part of a Hiring process (company shall remain unnamed). They wanted an efficient text search 
functionality without using out of the box solutions like Lucene or Solr. So I decided to take a whack at it.
The challenge specified that the solution should work on the Redis source code folder. My solution should work on any valid folder path
(not seeing the catch with mentioning a specific folder, as yet).
The solution will use BFS to traverse through the directory structure of the input path. Once all the files have been identified & listed, 
it reads the files & builds a Search Index on each File. The Index is basically a Suffix Trie (note:not the even more optimised & path compressedsuffix tree). It should 
demonstrate pretty good search performance & would allow searching based on partal or full words & phrases.
The system is implemented. But unit testing of the index building & E2E testing are not yet done. BFS traversal of directory, listing & reading
of files is confirmed to be working.
