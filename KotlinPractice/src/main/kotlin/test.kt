class Solution {
    fun solution(new_id: String): String {
        var answer = new_id.toLowerCase()
            .replace("[^\\w.\\-]".toRegex(),"")
            .replace("\\.{2,}".toRegex(),".")
            .replace("^\\.|\\.$".toRegex(),"")
        if(answer.isEmpty()){
            answer = "a"
        }
        else{
            var maxLength = 0
            if(answer.length < 15){
                maxLength = answer.length
            }else{
                maxLength = 15
            }
            answer = answer.substring(0,maxLength).replace("\\.$".toRegex(),"")
        }
        while(answer.length<3){
            answer+= answer[answer.length-1]
        }
        return answer
    }
}

fun main(args:Array<String>){
    val sol = Solution()

    val ans = sol.solution("...!@BaT#*..y.abcdefghijklm")
    println(ans)
}