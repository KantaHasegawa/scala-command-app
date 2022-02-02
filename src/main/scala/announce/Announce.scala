package anounce

object Anounce{
  def yesOrNo(): Boolean = {
    println(">> Yes: y No: n")
    var answer = io.StdIn.readLine()
    if(answer == "y")
      return true
    else if(answer == "n")
      return false
    else
      yesOrNo()
    }

  def start() = {
    println(">> Welcome to myApp!")
    println(">> Please type of parameter")
    try{
      print(">> [name]: ")
      val name = io.StdIn.readLine()
      print(">> [age]: ")
      val age = io.StdIn.readInt()
      print(">> [sex]('man' or 'woman'): ")
      val sex = io.StdIn.readLine()
      if (!(sex == "man") && !(sex == "woman"))
        throw new IllegalArgumentException()
    }catch{
      case err: Any => println("[Error] Invalid input!!")
    }
    println(">> Submit?")
    if(yesOrNo())
      println("Yes OK")
    else
      println("No OK")
    }
}
