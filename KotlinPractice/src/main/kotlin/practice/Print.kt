package practice

class Print {
    fun printMessage(s:String):Unit{
        println("Print.printMessage")
        println(s)
    }
    fun printFormat(s:String, s2:String = "Nothing"){
        println("Print.printFormat")
        println("s = [${s}], s2 = [${s2}]")
    }
    fun start(){
        printMessage("hello")
        printFormat("hello")
        printFormat("hello","exist")
        printFormat(s2 = "exist",s="hello")
    }
}