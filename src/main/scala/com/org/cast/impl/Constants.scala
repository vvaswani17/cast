package com.org.cast.impl

object Constants {
  val DROPCAST = "DROP TABLE IF EXISTS Cast"
  val CREATECAST = "CREATE TABLE IF NOT EXISTS Cast(originatorUserId int NOT NULL,bondId int NOT NULL,side varchar(255),price double,quantity int,status varchar(255),targetUserIds int,CONSTRAINT PK_cast PRIMARY KEY (originatorUserId ,bondId,side ));"
  val CANCELLED = "Cancelled"
  val ACTIVE = "Active"
}
