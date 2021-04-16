#!/bin/sh
mvn clean package && docker build -t com.mycompany/DiarioJSF .
docker rm -f DiarioJSF || true && docker run -d -p 9080:9080 -p 9443:9443 --name DiarioJSF com.mycompany/DiarioJSF