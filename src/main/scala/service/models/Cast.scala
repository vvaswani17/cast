package com.org.cast.models

import play.api.libs.json.{Format, Json}

case class Cast(originatorUserId: Int,
                bondId: Int,
                side: String,
                price: Option[Double],
                quantity: Option[Int],
                status: String,
                targetUserIds: Int,
               )

object Cast {
  /* Format for converting greeting messages to and from JSON.
   This will be picked up by a Lagom implicit conversion from Play's JSON format to Lagom's message serializer.*/
  implicit val format: Format[Cast] = Json.format[Cast]
}
