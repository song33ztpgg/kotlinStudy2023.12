package com.example.myapplication.Kiosk2

import kotlinx.coroutines.delay

suspend fun main() {
    val burgerImpomaion = mutableListOf<AllBurgerList>()
    val burgerNames = settingBurgerName()
    val burgerPrice = settingBurgerPrice()
    val burgerExpain = settingBurgerExpain()

    for (i in burgerNames.indices) {
        burgerImpomaion.add(AllBurgerList(burgerNames[i], burgerPrice[i], burgerExpain[i]))
    }


    val bearImpomation = mutableListOf<AllBearList>()
    val bearNames = settingBearName()
    val bearPrice = settingBearPrice()
    val bearExpain = settingBearExpain()

    for(i in bearNames.indices) {
        bearImpomation.add(AllBearList(bearNames[i],bearPrice[i],bearExpain[i]))
    }

    val burger = mutableListOf<Burger>(Burger("햄버거", "앵거스 비프 통살을 다져만든 버거"))
    val bear = mutableListOf<Bear>(Bear("맥주", "뉴욕 브루클린 브루어리에서 양조한 맥주"))
    val drink = mutableListOf<Drink>(Drink("음료", "매장에서 직접 만드는 음료"))
    val order = mutableListOf<Order>(Order("주문", "구매목록을 확인합니다"))
    val cancel = mutableListOf<Cancel>(Cancel("취소", "모든 예약 제품을 취소합니다"))

    val myOrderList = mutableListOf<String>()
    val myBuyList = mutableListOf<String>()

    while (true) {
        display(burger[0], bear[0], drink[0], order[0], cancel[0])

        var select = readLine().toString().toInt()
        when (select) {
            1 -> {
                println("\n\n\n")
                println("[원하시는 상품의 번호를 입력하세요]")
                for ((idx) in burgerImpomaion.withIndex()) {
                    print("${idx+1}. ")
                    burgerImpomaion[idx].view()
                }

                when (readLine().toString().toInt()) {
                    1 -> {
                        myOrderList.add("ShackBurger")
                    }

                    2 -> {
                        myOrderList.add("SmokeShack")
                    }

                    3 -> {
                        myOrderList.add("Shroom Burger")
                    }

                    4 -> {
                        myOrderList.add("Cheeseburger")
                    }

                    5 -> {
                        myOrderList.add("Hamburger")
                    }
                }
            }

            2->{
                println("\n\n\n")
                println("[원하시는 상품의 번호를 입력하세요]")
                for ((idx) in bearImpomation.withIndex()) {
                    print("${idx+1}. ")
                    bearImpomation[idx].view()
                }

                when (readLine().toString().toInt()) {
                    1 -> {
                        myOrderList.add("Heineken")
                    }

                    2 -> {
                        myOrderList.add("Budweiser")
                    }

                    3 -> {
                        myOrderList.add("Guinness")
                    }
                }
            }
            3 -> {
                println("현재 구매 불가능한 제품입니다")
                delay(2000)
            }

            4 -> {
                if(myOrderList.size == 0) {
                    println("\n\n\n")
                    println("[선택하신 매뉴가 존재하지 않습니다]")
                    delay(1500)
                } else {
                    println("\n\n\n")
                    println("[선택하신 매뉴]")

                    val countMap = myOrderList.groupingBy { it }.eachCount()
                    var totalPrice = 0.0;
                    var myListCount = 1
                    for ((item, count) in countMap) {
                        if (count > 0) {

                            val bugerIndex = burgerNames.indexOf(item)
                            if (bugerIndex != -1) {
                                println( String.format("%d.  %-15s ||  %.2f (%-2d개) ||%s",myListCount,burgerNames[bugerIndex], burgerPrice[bugerIndex]*count,count, burgerExpain[bugerIndex]))
                                totalPrice += burgerPrice[bugerIndex] * count
                                myListCount++
                            }

                            val bearIndex = bearNames.indexOf(item)
                            if (bearIndex != -1) {
                                println( String.format("%d.  %-15s ||  %.2f (%-2d개) ||%s",myListCount,bearNames[bearIndex], bearPrice[bearIndex]*count,count, bearExpain[bearIndex]))
                                totalPrice += bearPrice[bearIndex] * count
                                myListCount++
                            }


                        }
                    }
                    println()
                    println("[총 금액]")
                    println("%.2f".format(totalPrice))
                    println("1.구매하기     2.돌아가기")

                    when (readLine().toString().toInt()) {
                        1 -> {
                            println("구매 완료 하였습니다")

                            for(i in myOrderList){
                                myBuyList.add(i)
                            }
                            myOrderList.clear()
                            delay(1500)
                        }

                        2 -> {
                            println("메인 화면으로 돌아갑니다")
                            delay(1500)
                        }

                        else -> {
                            println("잘못된 접근입니다")
                            delay(1500)
                        }
                    }
                }

            }

            5 -> {
                println("\n\n\n")
                println("모든 주문을 취소하시겠습니까?")
                println("1.모든주문 취소     2.돌아가기")

                when (readLine().toString().toInt()) {
                    1 -> {
                        myOrderList.clear()
                        println("모든 주문을 취소합니다")
                        delay(1500)
                    }

                    2 -> {
                        println("메인 화면으로 돌아갑니다")
                        delay(1500)
                    }

                    else -> {
                        println("잘못된 접근입니다")
                        delay(1500)
                    }
                }

            }
            6->{
                println("\n\n\n")
                val countMap = myBuyList.groupingBy { it }.eachCount()
                var myListCount = 1
                for ((item, count) in countMap) {
                    if (count > 0) {

                        val buyIndex = myBuyList.indexOf(item)
                        if (buyIndex != -1) {
//                            println( String.format("%d.  %-15s ||  %.2f (%-2d개) ||%s",myListCount,myBuyList[buyIndex], myBuyList[buyIndex],count, myBuyList[buyIndex]))
                            println(myListCount)
                            println(myBuyList[buyIndex])
                            println(myBuyList[buyIndex])
                            println( count)
                            println( myBuyList[buyIndex])

                            myListCount++
                        }

//                        val bugerIndex = burgerNames.indexOf(item)
//                        if (bugerIndex != -1) {
//                            println( String.format("%d.  %-15s ||  %.2f (%-2d개) ||%s",myListCount,burgerNames[bugerIndex], burgerPrice[bugerIndex]*count,count, burgerExpain[bugerIndex]))
//
//                            myListCount++
//                        }
//
//                        val bearIndex = bearNames.indexOf(item)
//                        if (bearIndex != -1) {
//                            println( String.format("%d.  %-15s ||  %.2f (%-2d개) ||%s",myListCount,bearNames[bearIndex], bearPrice[bearIndex]*count,count, bearExpain[bearIndex]))
//                            myListCount++
//                        }


                    }
                }

//                for(i in myBuyList){
//                    println(i)
//                }
                println("판매기록")
                delay(3000)
            }
        }

    }


}


fun display(burger: Burger, bear: Bear, drink: Drink, order: Order, cancel: Cancel) {

    println("\n\n\n")
    println("SHAKESHACK BURGER 에 오신걸 환영합니다.")
    println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
    println()
    println("[ SHAKESHACK MENU ]")
    print("1. ")
    burger.view()
    print("2. ")
    bear.view()
    print("3. ")
    drink.view()
    println()
    println("[ ORDER MENU ]")
    print("4. ")
    order.view()
    print("5. ")
    cancel.view()
    print("6. ")
    println("구매목록")

}


fun settingBurgerName(): List<String> {
    return listOf(
        "ShackBurger",
        "SmokeShack",
        "Shroom Burger",
        "Cheeseburger",
        "Hamburger"
    )
}

fun settingBurgerPrice(): List<Double> {
    return listOf(6.9, 8.9, 9.4, 6.9, 5.4)
}


fun settingBurgerExpain(): List<String> {
    return listOf(
        "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
        "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
        "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
        "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
        "비프패티를 기반으로 야채가 들어간 기본버거"
    )
}


fun settingBearName():List<String>{
    return listOf(
        "Heineken",
        "Budweiser",
        "Guinness"
    )
}

fun settingBearPrice():List<Double> {
    return listOf(3.4,2.8,4.5)
}


fun settingBearExpain():List<String>{
    return listOf (
        "명확하고 깔끔한 맛 네덜란드산",
        "가벼운스타일의 고소한맛 미국산",
        "진한 거품의 흑맥주 스타일의 아일랜드산"
    )
}
