# Kotlin 관련 메모
***
마크다운 문서 참조:  
[MARKDOWN1](https://gist.github.com/ihoneymon/652be052a0727ad59601)  
[MARKDOWN2](https://heropy.blog/2017/09/30/markdown/)
***
## 1. 타입
### var 
* 계속해서 재정의가 가능한 일반적인 타입
```
var str:String = "hello world"
str = "hello world!"
```
### let  
* 한번 정의하면 재정의가 불가능한 타입 (java- final)
```
val str:String = "hello world"
// 컴파일 오류
// str = "hello world!"
```

## 2. Nullable
|사용법|설명|
|:---|:---------|
| [variable]:[type]?|변수가 null을 가질 수 있음을 의미|
| [variable]!!|nullable인 변수를 not null type으로 변환|
| [variable]?.[method]|nullable인 변수가 null일 경우 null 반환 / 아닐경우 method 실행|
| [variable]!!.[method]|nullable인 변수를 not null로 변환하여 method실행|
| [variable]?:[variable]|null이 아닐경우 전자 null 일경우 후자를 선택|

## 3. Lazy Initialization
### lateinit
* not null type을 사용하면서 나중에 초기화할수 있도록 허용해준다.  
* 특징 및 조건
  + var에서만 사용 가능
  + null을 통한 초기화 불가능
  + 초기화전엔 사용 불가능(NPE)
```
class Test{
  private lateinit var testStr:String
  
  fun init(s:String){
      testStr = s
  }
}
```
### by lazy
* 호출 시점에 함수를 통해 정의됨
* 특징 및 조건
  + val에서만 사용 가능
  + 호출 시점에 정의됨
```
class Test{
  private val testStr:String by lazy{
    "initialized"
  }
  
  fun printTest(){
    println(testStr)
  }
}
```
