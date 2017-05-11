#!/usr/bin/env bash
curl -H "Content-Type: application/json" -X POST -d '{"tipo":"sms","destinatario":"654767676","mensaje":"Hola Mundo!"}' http://localhost:8080/tinsa
