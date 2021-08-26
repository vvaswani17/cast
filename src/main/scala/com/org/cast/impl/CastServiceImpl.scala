package com.org.cast.impl

import akka.NotUsed
import akka.util.Timeout
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.org.cast.models.Cast
import service.CastService

import scala.concurrent.ExecutionContext
import scala.concurrent.duration._

class CastServiceImpl (service: ServiceCallFunctions)(implicit ec: ExecutionContext)
  extends CastService {

  implicit val timeout = Timeout(1200.seconds)

/*  override def sendCast(): ServiceCall[Cast, String] = {
    request =>
      service.sendCast(request)
  }*/

   def getActiveCasts(id: Int): ServiceCall[NotUsed, List[Cast]] = {
    _ =>
      service.getActiveCasts(id)
  }

/*
  override def cancelCast(originatorUserId: Int, bondId: Int, side: String): ServiceCall[NotUsed, String] = {
    _ =>
      service.cancelCast(originatorUserId: Int, bondId: Int, side: String)
  }
*/

}
