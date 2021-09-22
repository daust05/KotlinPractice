package Algorithm

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var rank = intArrayOf(6,6,5,4,3,2,1)
        var zero = 0
        var right = 0
        lottos.forEach{
            when(it){
                0-> zero++
                in win_nums -> right++
            }
        }
        var answer: IntArray = intArrayOf(rank[zero+right],rank[right])
        return answer
    }
}