# Kotlin 관련 메모
***
마크다운 문서 참조:  
[MARKDOWN1](https://gist.github.com/ihoneymon/652be052a0727ad59601)  
[MARKDOWN2](https://heropy.blog/2017/09/30/markdown/)
***
## 1. 타입
### var 
* 계속해서 재정의가 가능한 일반적인 타입
```kotlin
var str:String = "hello world"
str = "hello world!"
```
### val  
* 한번 정의하면 재정의가 불가능한 타입 (java- final)
```kotlin
val str:String = "hello world"
// 컴파일 오류
// str = "hello world!"
```
***
## 2. Nullable
|사용법|설명|
|:---|:---------|
| [variable]:[type]?|변수가 null을 가질 수 있음을 의미|
| [variable]!!|nullable인 변수를 not null type으로 변환|
| [variable]?.[method]|nullable인 변수가 null일 경우 null 반환 / 아닐경우 method 실행|
| [variable]!!.[method]|nullable인 변수를 not null로 변환하여 method실행|
| [variable]?:[variable]|null이 아닐경우 전자 null 일경우 후자를 선택|
***
## 3. Lazy Initialization
### lateinit
* not null type을 사용하면서 나중에 초기화할수 있도록 허용해준다.  
* 특징 및 조건
  + var에서만 사용 가능
  + null을 통한 초기화 불가능
  + 초기화전엔 사용 불가능(NPE)
```kotlin
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
```kotlin
class Test{
  private val testStr:String by lazy{
    "initialized"
  }
  
  fun printTest(){
    println(testStr)
  }
}
```
***
## 4. Unit, Nothing
[참고](https://medium.com/@lunay0ung/kotlin-unit%EA%B3%BC-nothing-e3ff9143fd65)
### Unit
* 자바의 void와 비슷한 개념으로 사용되는 타입
* 하지만 자바의 void와 다른 점도 존재한다.
  + void: 반환값이 없음을 나타내는 특수타입
  + unit: 싱글톤 unit 타입 객체를 반환
### Nothing
* 어떠한 값도 갖고 있지 않으면서 어떠한 값과도 호환되는 타입
* 도달이 불가능한 코드의 위치를 나타내기위해 사용
* null은 Nothing? 타입으로 나타낼 수 있다.
***
## 5. Infix Function  
* 가독성 향상을 위해 사용  

### 예시
```kotlin
val pair = "Ferrari" to "Katrina"
// val pair = Pair("Ferrari,"Katrina")
```
### 구현
```kotlin
// 함수 형식
infix fun [Dispatcher Type].[fun Name]([receiver]):[return type]{
  // this: Dispatcher
  return ***
}

// 기본 형식
infix fun String.to(s:String):String{
  return Pair(this,s)
}

// inline version
infix fun String.to(s:String) = Pair(this,s)
```
***
## 6. Variance
[참조](https://medium.com/mj-studio/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%A0%9C%EB%84%A4%EB%A6%AD-in-out-3b809869610e)
* 너무 어려워서 나중에 정리
***
## 7. Let / Also / Apply / With / Run
[참조](https://medium.com/@limgyumin/%EC%BD%94%ED%8B%80%EB%A6%B0-%EC%9D%98-apply-with-let-also-run-%EC%9D%80-%EC%96%B8%EC%A0%9C-%EC%82%AC%EC%9A%A9%ED%95%98%EB%8A%94%EA%B0%80-4a517292df29)
### let
  + 지정된 값이 null 이 아닌 경우에 코드를 실행해야 하는 경우 / Nullable 객체를 다른 Nullable 객체로 변환하는 경우 / 단일 지역 변수의 범위를 제한 하는 경우
```kotlin
val t: R = T.let{
  println(it)
  it.toR()
}
```
### also
  + 수신 객체 람다가 전달된 수신 객체를 전혀 사용 하지 않거나 수신 객체의 속성을 변경하지 않고 사용하는 경우
  + 예시: 사이드 이팩트를 확인, 유효성 검사
```kotlin
val t: T = T.also{
  println(it)
}
```  
### apply
  + 수신 객체 람다 내부에서 수신 객체의 함수를 사용하지 않고 수신 객체 자신을 다시 반환 하려는 경우에 apply 를 사용
  + 예시: 객체의 초기화
```kotlin
val t: T = T.apply{
  println(this)
}
```
### with
  + Non-nullable (Null 이 될수 없는) 수신 객체 이고 결과가 필요하지 않은 경우
```kotlin
T.name
T.age
with(T){
  print(name)
  print(age)
}
```
### run
  + 어떤 값을 계산할 필요가 있거나 여러개의 지역 변수의 범위를 제한
```kotlin
val t:R = T.run{
  println(this)
  this.toR()
}
```
***
# 그 외 쓸모있는 메모
## 1. 정규표현식
[참고](https://wormwlrm.github.io/2020/07/19/Regular-Expressions-Tutorial.html)
* """ 삼중 따움표를 사용하면 escape를 사용하지 않아도 된다.
