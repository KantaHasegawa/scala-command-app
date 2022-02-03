import anounce.Anounce
import scalikejdbc.config.DBs
object Main extends App {
  DBs.setupAll()
  Anounce.start()
}
