package com.org.cast.impl

import com.lightbend.lagom.scaladsl.api.ServiceLocator
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._
import service.CastService
import com.softwaremill.macwire.wire
import play.api.libs.ws.ahc.AhcWSComponents

class CastLoader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new CastLoaderApplication(context) {
      override def serviceLocator: ServiceLocator = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new CastLoaderApplication(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[CastService])
}

abstract class CastLoaderApplication(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {
  override lazy val lagomServer: LagomServer = serverFor[CastService](wire[CastServiceImpl])
  lazy val castService: CastService = serviceClient.implement[CastService]
  lazy val service: ServiceCallFunctions = wire[ServiceCallFunctions]
//  lazy val connection = DBOperations.getConnection()
//  DBOperations.runQuery(connection,DROPCAST)
//  DBOperations.runQuery(connection,CREATECAST)
}
