@echo off
call mvn clean package
call docker build -t com.mycompany/DiarioJSF .
call docker rm -f DiarioJSF
call docker run -d -p 9080:9080 -p 9443:9443 --name DiarioJSF com.mycompany/DiarioJSF