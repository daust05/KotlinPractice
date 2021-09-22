package practice

class Infix {
    class Person(val name:String){
        val likedPeople = mutableListOf<Person>()
        infix fun like(other:Person) = likedPeople.add(other)
        fun printLiked(){
            println("Person.printLiked")
            likedPeople.forEach{println(it.name)}
        }
    }
    infix fun Int.times(str:String) = str.repeat(this)
    fun start(){
        println(3 times "infix ")
        println("Hello" to "World")
        val p1 = Person("p1")
        val p2 = Person("p2")
        p1 like p2
        p1.printLiked()
    }
}