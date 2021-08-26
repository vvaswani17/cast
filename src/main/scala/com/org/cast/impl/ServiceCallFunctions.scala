package com.org.cast.impl

import scala.concurrent.ExecutionContext.Implicits.global
//import org.apache.log4j.Logger

import com.org.cast.models.Cast
//import java.sql.Connection
import scala.concurrent.Future

class ServiceCallFunctions () {

  /*
val logger = Logger.getLogger(this.getClass.getName)
  def sendCast(cast: Cast): Future[String] = Future {
    logger.info(">>>--- sendCast Request Received ---<<<")
    try {
      val statement = connection.createStatement()
      val sql = s"insert into cast values(${cast.originatorUserId},${cast.bondId},'${cast.side}',${cast.price.getOrElse(0)},${cast.quantity.getOrElse(0)},'${cast.status}',${cast.targetUserIds})"
      statement.executeUpdate(sql)
      logger.info(">>>--- Record Inserted ---<<<")
    } catch {
      case NonFatal(e) => throw new Exception(e.getMessage)
    }
    "Success"
  }
*/

  def getActiveCasts(id: Int): Future[List[Cast]] = Future {
//    logger.info(">>>--- getActiveCasts Request Received ---<<<")
    List(Cast(originatorUserId = 1, bondId = 1, side = "buy", status = "", targetUserIds = 1, quantity = None, price = None))
  }

  /* def cancelCast(originatorUserId: Int, bondId: Int, side: String):Future[String] = Future{
    logger.info(">>>--- cancelCast Request Received ---<<<")
    try {
      val statement = connection.createStatement()
      val sql = s"update cast set status = '$CANCELLED' where originatorUserId = $originatorUserId AND bondId = $bondId AND side = '$side'"
      statement.executeUpdate(sql)
      logger.info(">>>--- Record Updated ---<<<")
    } catch {
      case NonFatal(e) => throw new Exception(e.getMessage)
    }
    "Success"
  }
}
*/
}
//cast should be unique based on originatorUserId: Int, bondId: Int, side: String