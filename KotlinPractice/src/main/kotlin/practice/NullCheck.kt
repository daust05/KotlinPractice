package practice

class NullCheck(s:String?){
    var isNull:String? = s

    fun getString(ins:String?):String{
        return ins?:"is null"
    }

    fun getLength(ins:String?):Int?{
        return ins?.length
    }

    fun transNull(ins:String?){
        var notNull:String? = ins
        println(ins?.length)
        notNull = ins!!
        println(ins.length)
    }

}