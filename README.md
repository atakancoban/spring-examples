Spring-Boot ile ilgili örnekler burada paylaşılacaktır.

# spring-examples

## Docker + Mongo Repository ile Rest api örneği
spring-mongo-rest-api
## Hazır proje kurulumu
[1] Docker ile örnekteki image'ı ayağa kaldırmak için 
Mongo DB ile docker file ayağa kaldırmak için 


`docker-compose -f eclipse-workspace/spring-mongo-rest-api/src/main/resources/docker-compose.yml up -d`

GET
http://localhost:9091/user/list

POST
http://localhost:9091/user/add/
### Post body example parameter: 

    
       {
        "id": "10",
        "name": "Alex",
        "surname": "de souza",
        "properties": {
            "position": "Captain"
        }
      }
          

