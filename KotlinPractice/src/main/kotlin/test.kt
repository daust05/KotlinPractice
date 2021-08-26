fun main(){
    var list = readLine()!!.split(" ").map{it.toInt()}
    while ((list[0] != 0) or (list[1] != 0)){
        println(list[0] + list[1])
        list = readLine()!!.split(" ").map{it.toInt()}
    }
}

