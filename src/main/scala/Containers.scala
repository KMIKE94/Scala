/**
  * Created by kwhite on 24/01/2017.
  */
object Containers {
  def main(args: Array[String]) {
    // Tuples, ordered containers, elements can be of different types


    val personInfo = ("Keith", "White", 36,"M")
    println(personInfo)

    val genderPair = ("Keith" -> "M")

    personInfo.productIterator.foreach{i => println("Value = " + i)}

    val(firstname,surname,age,gender) = personInfo
    println(firstname + " " + surname)

    println(personInfo._1)

    (printPersonGender _) tupled(genderPair)

    println(personInfo.productArity)


    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    // Lists
    // immutable collections, fixed length, and elements cannot be saved
    // singly linked lists, terminated using "Nil" -> List[Nothing]
    val weekdays = "Mon" :: "Tue" :: "Wed" :: "Thur" :: "Fri" :: Nil
    println(weekdays)

    // preferred
    val weekdays2 = List("Mon","Tues","Wed","Thu","Fri")
    println(weekdays2)

    val combinedLists = weekdays ::: weekdays2
    println(combinedLists)

    val combinedLists2 = weekdays ++ weekdays2
    println(combinedLists2)

    val daysAgain = List(weekdays, weekdays2).flatten
    println(daysAgain)

    val daysInd = List(1,2,3,4,5,6,7)
    println(daysInd zip daysInd)

    println(weekdays.head)
    println(weekdays.tail)
    println(weekdays.size)
    println(weekdays.reverse)
    println(weekdays(1))
    println(weekdays.contains("Mon"))
    for(c <- weekdays) println(c)
    println(weekdays forall(_ != "Monday"))
    println(weekdays endsWith weekdays2)




    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////

    // Maps, key/value pairs
    val stateCodes = Map(
      "California" -> "CA",
      "New York" -> "NY",
      ("Vermont","VT")
    )

    println(stateCodes)

    println(stateCodes("Vermont"))
    println(stateCodes.contains("Georgia"))
//    println(stateCodes("Georgia")) // error
    stateCodes.foreach(((p: (String, String)) => println(p._1 + "=" + p._2)))

    // Map from two lists
    val states = List("California", "New York", "Vermont")
    val codes = List("CA", "NY", "VT")

    val stateMap = (states zip codes).toMap
    println(stateMap)

    // map to list of keys
    val st = stateCodes.keySet.toList
    println(st)



    // Options for Error-handling
    println(fraction(2,3))
    println(fraction(2,0))

//    val pi = fraction(22, 7) getOrElse "Oops, something went wrong"
    val pi = fraction(22, 0) getOrElse "Oops, something went wrong"
    println(pi)

    println(fraction(22,7) match{
      case Some(pi) => pi
      case None => "Something bad happened"
    })

    val state = util.Try(stateCodes("California"))
    state match {
      case util.Success(code) => println(code)
      case util.Failure(error) => println(error)
    }

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////

    // Mutable lists are called buffers
    val someNumbers = collection.mutable.Buffer(10,20,30,40,50)
    println(someNumbers)

    val stCodes = collection.mutable.Map("Cal" ->  "CA", "Ver" -> "VT")
    val listBuilder = List.newBuilder[Int]
    someNumbers.foreach(listBuilder+=_)
    println(listBuilder.result)


    // Arrays not mutable collections
    val DOW = Array("Mon", "Tue", "Wed")

    println(DOW(0))

    DOW(0) = "Monday"





  }

  def fraction(numer:Double,denom:Double):Option[Double] = {
    if(denom == 0)
      None
    else
      Option(numer/denom)
  }

  def printPersonGender(name:String, gender:String) = println(s"Name:$name M/F:$gender")
}
