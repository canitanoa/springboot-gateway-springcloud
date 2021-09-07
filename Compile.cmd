@echo off
@ECHO ***********
@ECHO GENERAR JAR
@ECHO ***********
CALL mvnw.cmd clean install
CD..
pause