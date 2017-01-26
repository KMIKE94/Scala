/**
  * Created by kwhite on 23/01/2017.
  */
object Currying {

  def main(args : Array[String]): Unit ={

    println(getCircleStats(r=10))

    // Generics
    printPairTypes(10, "ABC")

    // Quarternary Function
    // F(w = W1, a, y = Y1, c = Z1)

    val defaultCompare = smartCompare(_:String,_:String, compareStrings)

    println(defaultCompare("abc", "xyz"))

    val PI = 3.14
    val r = 10
    val areaCalculator:(Double)=>Double = getAreaClosue
    println(areaCalculator(r))

  }

  def printPairTypes[K,V](k:K,v:V)  = {
    val keyType = k.getClass
    val valueType = v.getClass
    println(s"$k, $v are of types $keyType, $valueType")

    println(curriedCompare(compareStrings)("abc", "abc"))
    val defaultCompare = curriedCompare(compareStrings)(_:String, _:String)

    println(defaultCompare("abc", "abc"))
  }

  def getCircleStats(PI:Double = 3.14, r:Double)= {
    def getCircleArea(r:Double) = PI * r * r
    def getCircleCircumference(r:Double) = 2 * PI * r
    (getCircleArea(r), getCircleCircumference(r))
  }

  def compareStrings(s1:String,s2:String):Int = {
    if (s1 == s2) 0
    else if (s1 > s2) -1
    else {1}
  }

  def smartCompare(s1:String, s2:String, cmpFn:(String, String) => Int):Int = {
    cmpFn(s1,s2)
  }

  def curriedCompare(cmpFn:(String,String) => Int)
                    (s1:String, s2:String):Int = {
    cmpFn(s1,s2)
  }

  // Closures
  def getAreaClosue = {
    val PI = 3.14159
    val getArea = (radius:Double)=> {
      PI * radius * radius
    }:Double
    getArea
  }

}
