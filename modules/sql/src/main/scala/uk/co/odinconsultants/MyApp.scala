package uk.co.odinconsultants

import io.getquill.*
import io.getquill.context.ExecutionInfo

import java.sql.Connection

object MyApp {
  case class Person(firstName: String, lastName: String, age: Int)

  // SnakeCase turns firstName -> first_name
  val ctx = new H2JdbcContext(SnakeCase, "ctx")
  import ctx.*

  def main(args: Array[String]): Unit   = {
    createPersonTable()

    val named                = "Joe"
    inline def somePeople    = quote {
      query[Person].filter(p => p.firstName == lift(named))
    }
    inline def insertJoe     = quote {
      query[Person].insertValue(Person("Joe", "Henry", 62))
    }
    inline def insertPhillip = quote {
      query[Person].insertValue(Person("Phillip", "Henry", 62))
    }
    run(insertJoe)
    run(insertPhillip)
    val people: List[Person] = run(somePeople)
    println(people)
  }
  private def createPersonTable(): Unit = {
    val sql                    =
      "CREATE TABLE PERSON(FIRST_NAME VARCHAR(255), last_name VARCHAR(255), age int);"
    val connection: Connection = ctx.dataSource.getConnection
    connection.createStatement.execute("drop table person;")
    connection.createStatement.execute(sql)
    connection.commit()
  }
}
