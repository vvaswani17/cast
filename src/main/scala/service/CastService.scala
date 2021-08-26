package service

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import com.org.cast.models.Cast

trait CastService extends Service {

//  def sendCast(): ServiceCall[Cast,String]
//  def cancelCast(originatorUserId: Int, bondId: Int, side: String): ServiceCall[NotUsed, String]
  def getActiveCasts(id: Int): ServiceCall[NotUsed,List[Cast]]

  override final def descriptor: Descriptor = {
    import Service._
    named("ds-casts")
      .withCalls(
//        restCall(Method.POST,"/v1/cast/api/sendCast", sendCast _),
//        restCall(Method.PUT,"/v1/cast/api/cancelCast/:originatorUserId/:bondId/:side", cancelCast _),
        restCall(Method.GET,"/v1/cast/api/getActiveCasts/:id", getActiveCasts _),
      ).withAutoAcl(true)
  }
}




