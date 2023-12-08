package com.example.myapplication.sampledata.study2




//fun main() {
//    var student = Student("참새", 10)
//
//    var result = student?.apply {
//        student.age = 50
//    }
//    result?.displayInfo()
//    student.displayInfo()
//}
//
//class Student(name: String, age: Int) {
//    var name: String
//    var age: Int
//
//    init {
//        this.name = name
//        this.age = age
//    }
//
//    fun displayInfo() {
//        println("이름은 ${name} 입니다")
//        println("나이는 ${age} 입니다")
//    }
//}


fun main() {
    println("입렫할 마리수를 작성하시오")
    var count = readLine().toString().toInt()
    var bird = mutableListOf<Bird>()

    for (idx in 0..count -1) {
        println("${idx + 1} 새 이름 작성하시오")
        var name = readLine().toString()

        bird.add(Duck(name))
    }

    for (b in bird) {
      b.swim()
    }
}

open class Bird(name: String) {
    var name: String

    init {
        this.name = name
    }

    fun swim() {
        println("${name} 세가 날아갑니다")
    }

}

class Duck(name: String) : Bird(name) {

}


//
//fun main() {
//
//     var count = readLine()!!.toInt()
////    var test = Bird();
////    test.name = "테스트"
////    birds.add(Bird("이름"))
//    var birds = mutableListOf<Bird>()
//
//
//    for(idx in 0 .. count) {
//        birds.add(Sparrow("이름2"))
//    }
//
//    for(idx in birds) {
//        println(birds.name)
//    }
//
//
//    println("------------------")
//    println(count)
//}
//
//open class Bird(name:String) {
//    lateinit var name: String
//    init {
//        this.name = name
//    }
//
//    fun speakName() {
//        println(name)
//    }
//}
//
//class Sparrow(name:String) :Bird(name) {
//
//}

//
//fun main() {
//    println("몇 마리를 생성하시겠습니까?")
//    var count = readLine()!!.toInt()
//    var birds = mutableListOf<Bird>()
//
//    for(idx in 0..count-1) {
//        println("조류의 이름을 입력해주세요")
//        var name = readLine()!!
//
//        // as Bird는 생략가능
//        birds.add(Sparrow(name) as Bird)
//    }
//    println("============조류 생성완료============")
//    for(bird in birds) {
//        bird.fly()
//    }
//}
//
//open class Bird(name: String) {
//    var name: String
//
//    init {
//        this.name = name
//    }
//
//    fun fly() {
//        println("${name}이름의 조류가 날아요~")
//    }
//}
//
//class Sparrow(name: String): Bird(name) {

//}
