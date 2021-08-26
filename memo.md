# Kotlin 관련 메모
***
마크다운 문서 참조:  
[MARKDOWN1](https://gist.github.com/ihoneymon/652be052a0727ad59601)  
[MARKDOWN2](https://heropy.blog/2017/09/30/markdown/)
***
## 1. 타입
* var: 계속해서 재정의가 가능한 일반적인 타입
```
var str:String = "hello world"
str = "hello world!"
```
* let: 한번 정의하면 재정의가 불가능한 타입 (java- final)
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

