package anounce

import userOperation._

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

  def selectOrInsert(): Boolean = {
    println(">> SelectUsers: s InsertUser: i")
    var answer = io.StdIn.readLine()
    if(answer == "s")
      return true
    else if(answer == "i")
      return false
    else
      selectOrInsert()
  }

  def start() = {
    println(">> Welcome to myApp!")
    println(">> Select order")
    if(selectOrInsert()){
      select()
    }else{
      insert()
    }
  }

  def select() = {
    try{
      println("Display to users!!")
      var users = UserOperation.select()
      for (user <- users) {
        println(s"[id]   ${user.id}")
        println(s"[name] ${user.name}")
        println(s"[age]  ${user.age}")
        println(s"[sex]  ${user.sex}\n")
      }
      println("SeeYouAgain!!")
    }catch{
      case e: Any => println("[Error] Server Error!!")
    }
  }

  def insert() = {
    println(">> Please type of parameter")
    try{
      print(">> [name]: ")
      var name = io.StdIn.readLine()

      print(">> [age]: ")
      val age = io.StdIn.readInt()

      print(">> [sex]('man' or 'woman'): ")
      val sex = io.StdIn.readLine()
      if (!(sex == "man") && !(sex == "woman"))
        throw new IllegalArgumentException()

      println(">> Submit?")
      if(yesOrNo()){
        var result = UserOperation.insert(name,age,sex)
        println(s"InsertSuccess! userId is ${result}!")
      }else{
        println("SeeYouAgain!!")
      }
    }catch{
      case err: Any => println("[Error] Invalid input!!")
    }
  }
}
