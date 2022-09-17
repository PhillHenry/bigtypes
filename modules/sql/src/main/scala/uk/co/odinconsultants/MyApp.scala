package uk.co.odinconsultants

import io.getquill.*

object MyApp {
  case class Person(firstName: String, lastName: String, age: Int)

  // SnakeCase turns firstName -> first_name
  val ctx = new PostgresJdbcContext(SnakeCase, "ctx")
  import ctx.*

  def main(args: Array[String]): Unit = {
    val named                = "Joe"
    inline def somePeople    = quote {
      query[Person].filter(p => p.firstName == lift(named))
    }
    val people: List[Person] = run(somePeople)
    // TODO Get SQL
    println(people)
  }
}
