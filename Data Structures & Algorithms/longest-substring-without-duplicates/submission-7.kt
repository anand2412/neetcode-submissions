class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char?, Int?>()
        var left = 0
        var maxLen = 0
        s.forEachIndexed { index, ch -> 
            if(ch in map && map[ch]!! >= left) {
               left = map[ch]!! + 1 
            }
            map[ch] = index
            maxLen = maxOf(maxLen, index - left + 1)
        }
        
        return maxLen
    }
}
