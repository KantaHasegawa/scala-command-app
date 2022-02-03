package userOperation

import scalikejdbc._
import scalikejdbc.config._

object UserOperation {
  case class User(
      id: Int,
      name: String,
      age: Int,
      sex: String
  )

  object User {
      def fromDb(rs: WrappedResultSet): User = {
          val id = rs.int("id")
          val name  = rs.string("name")
          val age    = rs.int("age")
          val sex     = rs.string("sex")
          return User(id, name, age, sex)
      }
  }

  def insert (name: String, age: Int, sex: String): Long = {
    DB localTx { implicit session =>
    var result = sql"insert into user (name, age, sex, created_at, updated_at) values (${name}, ${age}, ${sex}, current_timestamp, current_timestamp)"
      .updateAndReturnGeneratedKey.apply()
    return result
  }
}

  def select (): List[User] = {
    val users: List[User] = DB readOnly { implicit session =>
      sql"select * from user".map(rs => User.fromDb(rs)).list.apply()
    }
    return users
  }
}
