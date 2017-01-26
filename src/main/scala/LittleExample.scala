/**
  * Created by kwhite on 19/01/2017.
  */

object LittleExample{

  def main(args : Array[String]){
    println("Hello World!")

    val weekDays = List("Mon", "Tues", "Wed", "Thur", "Fri", "Sat", "Sun")
    println(weekDays.map(_ == "Mon"))

    var someVal = 5
    var someRef = List(3,5)
    printAny(someVal)
    printAny(someRef)
    printAnyVal(someVal)
//    printAnyVal(someRef)  // error
    printAnyRef(someRef)
//    printAnyRef(someVal)  // error


    val name = "Keith"
    var greetings = "Hello"

    println(s"${greetings*2} $name, I hope you have a great day")

    val numer : Double = 22
    var denom:Double = 7

    val PI = if(denom != 0) {numer/denom} else {None}

    println(PI)

    val PIC = if(denom == 0) {numer/denom}
    println(PIC)

    val daysOfWeek = List("Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun")
    for(day <- daysOfWeek){
      day match {
        case "Mon" => println("Manic Monday")
        case otherDay => println(otherDay)
      }
    }

    val x = for(day <- daysOfWeek) yield {
      day match {
        case "Mon" => "Manic Monday"
        case otherDay => otherDay
      }
    }

    print(x)

    val y = for(i <- 0 to daysOfWeek.size-1){
      println(i)
    }

    val z = for(i <- 0 until daysOfWeek.size) {
      println(i)
    }

    val a = for(day <- daysOfWeek if day == "Mon"){
      println("Manic Monday")
    }

    val loops = for{i <- 0 until 7
                    j <- daysOfWeek}{
      println(s"$i,$j")
    }

    var t : Int = 0
    while(t < daysOfWeek.size) {
      println(daysOfWeek(t))
      t+=1
    }

    patternMatching()

  }

  // Scala types
  def printAny(x : Any) = println(x)
  def printAnyVal(y : AnyVal) = println(y)
  def printAnyRef(z : AnyRef) = println(z)


  def patternMatching(): Unit = {
    val dayOfWeek = "Monday"
    var errorDayOfWeek = "monday"
    val typeOfDay = errorDayOfWeek match {
      case "Monday" => "Manic Monday"
      case "Sunday" => "Sleepy Sunday"
      case _ => "Error, did not find match"
    }

    println(typeOfDay)


    val newDayOfWeek = "Saturday"
    val typeOfDay2 = newDayOfWeek match {
      case "Monday" => "Manic Monday"
      case "Sunday" | "Saturday" => "Lazy Weekend"
      case "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "Bad days"
    }
    println(typeOfDay2)

    // catch all clause
    var typeDay = dayOfWeek match {
      case "Monday" => "Manic Monday"
      case "Sunday" => "Sleepy Sunday"
      case someOtherDay => someOtherDay
    }

    //must belong to a base class
    val radius: Any = 10
    //    val radius:String = 10  // error
    val typeOfRadius = radius match {
      case radius: Int => "Integer"
      case radius: String => "String"
      case radius: Double => "Double"
    }

//    println(getArea(14))


    // cannot use underscore on other side clause

    // Converting method to function
    convertMethodToFunction()
  }

  // functions are objects wheras methods are not

  //method
//  def getArea2(radius : Double) : Double = {
//    val PI = 3.14;
//    PI * radius * radius
//  }

  //function
//  val getArea = (radius : Double) => {
//    val PI = 3.14;
//    PI * radius * radius
//  }:Double

  def convertMethodToFunction(): Unit = {
    val PI = 3.14
    val r = 2
    def getCircleArea(r : Double): Double = PI * r * r

    val getCirArea : (Double) => Double = getCircleArea

    println(getCirArea(14))

    val calc = getCircleArea _
    // calc is now a function


    def getAreaClosure = {
      val PI = 3.14
      val getArea = (radius : Double) => {
        PI * radius * radius
      }:Double
      getArea
    }

    println(getCircleStats(4))

    println(smartCompare("abc","xyz",compareStringsAscending))

    val reverseComparatorObj = getComparator(true)
    println(reverseComparatorObj("abc", "xyz"))
  }

  def getCircleStats(r:Double) = {
    val PI = 3.14
    def getCircleArea(r:Double) = PI * r * r
    def getCircleCircumference(r:Double) = 2 * PI * r

    (getCircleArea(r), getCircleCircumference(r))
  }

  def compareStringsAscending(s1:String, s2:String):Int = {
    if(s1 == s2) 0
    else if (s1 > s2) -1
    else {1}
  }

  def smartCompare(s1:String,s2:String,cmpFn:(String,String) => Int):Int = {
    cmpFn(s1,s2)
  }


  def getComparator(reverse:Boolean):(String,String) => Int = {
    if(reverse == true) compareStringsAscending
    else compareStringsAscending
  }

}
