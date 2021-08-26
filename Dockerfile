FROM ubuntu:18.04
COPY . /app
USER root
WORKDIR /app
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
RUN apt-get install -y wget
RUN apt-get install -y curl
RUN apt-get install -y gnupg
RUN wget www.scala-lang.org/files/archive/scala-2.13.0.deb
RUN apt-get install sudo
RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | sudo tee /etc/apt/sources.list.d/sbt.list
RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | sudo tee /etc/apt/sources.list.d/sbt_old.list
RUN curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | sudo apt-key add
RUN sudo apt-get update
RUN sudo apt-get -y install sbt

