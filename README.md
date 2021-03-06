# EcommerceSpringMicro-Servico

Aplicação utiliza:
RabbitMQ
Spring Netflix Eureka
Spring Netflix Zull

## Arquitetura do projeto

 ![alt text](https://i.imgur.com/qjBSljU.jpg)
 
 ## configurar microservico de email
 
 sendMail/src/main/resources/env/mail.properties

 ![alt text](https://i.imgur.com/uA3lQn0.png)

## Executar os microservicos

 ![alt text](https://i.imgur.com/i52vFnQ.png)
 
 

## executar rabitMQ

![alt text](https://i.imgur.com/Y6cRsk8.png)

docker-compose up -d

![alt text](https://i.imgur.com/r1HppmO.png)


http://localhost:15672/
 
 user: admin
 password: admin
 
  ## criar Exchange
 
 auth.exchange
 
 ![alt text](https://i.imgur.com/quRI7V2.png)
 
 crud.exchange
 
 ![alt text](https://i.imgur.com/DoBowid.png)
 
 ## add filas
 
 auth.user.queue
 
 ![alt text](https://i.imgur.com/pc7E0FA.png)
 
  crud.produto.queue
 
 ![alt text](https://i.imgur.com/quRI7V2.png)
 
  ## add bind na minha exchange
 
  queue = auth.user.queue
  Routing key = auth.user.routingkey
 
 ![alt text](https://i.imgur.com/dXowFdY.png)
 
  queue = crud.produto.queue
  Routing key = crud.produto.routingkey
 
 ![alt text](https://i.imgur.com/voo1mWW.png)
 
## Criar uma nova instancia

 ![alt text](https://i.imgur.com/l4NlyQs.png)


## executar Spring Eureka

http://localhost:8761/registry

 ![alt text](https://i.imgur.com/dCPsf1B.png)
 
 

## cadastro de usuario

http://localhost:8080/api/auth/user/register POST

{
    "name":"Lucas Capelotto",
    "userName": "lucas@email.com",
    "password": "123456"
}

## login de usuario

http://localhost:8080/api/auth/user/login POST

{
    "userName":"lucas@email.com",
    "password":"123456"
}

## Cadastro produto

http://localhost:8080/api/crud/produto POST
{
    "nome":"Celular",
    "estoque":"50",
    "preco":"80.00"
}

## Cadastro de venda

http://localhost:8080/api/pagamento/venda POST

{
                "data": "2020-10-07T00:00:00.000+00:00",
                "produtos": [
                    {
                        "idProduto":1,
                        "quantidade":1
                    }
                ],
                "valorTotal": 2000.0}
               
}

## Mostrar porta loadBalance

http://localhost:8080/api/pagamento/venda/mostrarPorta


 ![alt text](https://i.imgur.com/IZ0Dmvl.png)
 
 
 ## Documentação das tecnologias
 
 spring = https://spring.io/
 
 Spring Netflix = https://spring.io/projects/spring-cloud-netflix
 
 spring security+JWT = https://www.baeldung.com/spring-security-oauth-jwt
 
 RabbitMQ = https://spring.io/guides/gs/messaging-rabbitmq/
 
 sendMail spring = https://www.baeldung.com/spring-email
 
