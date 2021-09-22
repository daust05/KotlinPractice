package practice

class Hello(s:String?) {
    val greeting = s?:"hello world"

    fun greet(){
        println(greeting)
    }
}