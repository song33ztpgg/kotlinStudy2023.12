package com.example.myapplication.Kiosk

import com.example.myapplication.sampledata.study2.inputMyInfo

fun main() {

    val burgerNames = settingBurgerName()
    val burgerPrice = settingBurgerPrice()
    val burgerExpain = settingBurgerExpain()

    var myOrderList = mutableListOf<Int>()

    while (true) {
        titleDisplay()
        display()
        var select = readLine().toString().toInt()

        when (select) {
            1 -> {
                titleDisplay()
                for ((idx) in burgerNames.withIndex()) {
                    println("${idx + 1}.  ${burgerNames[idx]}  ${burgerPrice[idx]}  ${burgerExpain[idx]}")
                }

                var selectBurger = readLine().toString().toInt()
                myOrderList.add(selectBurger)

            }

            2, 3, 4 -> {
                println("현재 준비되어 있는 매뉴가 없습니다")
            }

            5 -> {
                var OrderCheck = myOrderList.size
                if (OrderCheck < 1) {
                    println("현재 존재하는 주문이 없습니다")

                } else {

                    myOrderList.sort()
                    for ((idx, res) in myOrderList.withIndex()) {
                        println("현재 장바구니 상황입니다")
                        println("${burgerNames[res - 1]}  || ${burgerPrice[res - 1]} || || ${burgerExpain[res - 1]}")
                    }

                    println()
                    println("1. 구매  2.돌아가기")
                    while (true) {
                        var choice = readLine().toString().toInt()
                        if (choice == 1) {
                            myOrderList.clear()
                            println("구매 되었습니다")
                            break
                        } else if (choice == 2) {
                            println("메인 화면으로 돌아 갑니다")
                            break
                        } else {
                            println("잘못된 접급입니다")
                        }
                    }
                }
                println("돌아가려면 아무키나 Enter 누르세요")
                readLine()
            }

            6 -> {
                var OrderCheck = myOrderList.size
                if (OrderCheck < 1) {
                    println("현재 존재하는 주문이 없습니다")

                } else {
                    println("주문하신 모든 상품을 취소 하시겠습니까?")
                    println("1. 취소  2.돌아가기")

                    while (true) {
                        var choice = readLine().toString().toInt()
                        if (choice == 1) {
                            myOrderList.clear()
                            println("취소 되었습니다")
                            break
                        } else if (choice == 2) {
                            println("메인 화면으로 돌아 갑니다")
                            break
                        } else {
                            println("잘못된 접급입니다")
                        }
                    }
                }
                println("돌아가려면 아무키나 Enter 누르세요")
                readLine()

            }

            else -> {
                println("종료됩니다")
                break
            }
        }

    }
}

fun titleDisplay() {
    repeat(5) { println() }
    println("SHAKESHACK BURGER 에 오신걸 환영합니다.")
    println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.")
}

fun display() {

    println("[ SHAKESHACK MENU ]")
    println("1. Burger         | 앵거스 비프 통살을 다져만든 버거")
    println("2. Forzen Custard | 매장에서 신선하게 만드는 아이스크림")
    println("3. Drink          | 매장에서 직접 만드는 음료")
    println("4. Beer           | 뉴욕 브루클린 브루어리에서 양조한 맥주")
    println("[ ORDER MENU ]")
    println("5. Order          | 장바구니를 확인 후 주문합니다.")
    println("6. Cancel         | 진행중인 주문을 취소합니다.")

}


fun settingBurgerName(): MutableList<String> {
    val burgerNames = mutableListOf<String>(
        "ShackBurger",
        "SmokeShack",
        "Shroom Burger",
        "Cheeseburger",
        "Hamburger"
    )
    return burgerNames
}

fun settingBurgerPrice(): MutableList<Double> {
    val burgerPrice = mutableListOf<Double>(6.9, 8.9, 9.4, 6.9, 5.4)
    return burgerPrice
}

fun settingBurgerExpain(): MutableList<String> {

    val burgerExpain = mutableListOf<String>(
        "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
        "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
        "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
        "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
        "비프패티를 기반으로 야채가 들어간 기본버거"
    )

    return burgerExpain
}