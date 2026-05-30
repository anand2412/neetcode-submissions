class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val arr = IntArray(26)
        var left = 0
        var maxCount = 0
        var maxLen = 0
        s.forEachIndexed { right, ch ->
            arr[ch.code - 'A'.code]++
            maxCount = max(maxCount, arr[ch.code - 'A'.code])
            if ((right - left + 1) - maxCount > k) {
                val temp = s[left]
                arr[temp.code - 'A'.code]--
                left++
            }
            maxLen = max(maxLen, right - left + 1)
        }

        return maxLen
    }
}
