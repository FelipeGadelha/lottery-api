# lottery-api

<p align="center">
  <a href="https://www.youtube.com/channel/UCTHEnDuI2uIYeTwV4RR7nOA" target="_blank">
    <img src="https://img.shields.io/badge/YouTube-FF0000?logo=youtube&logoColor=write" /><a/>
   <a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
    <img src="https://img.shields.io/badge/LinkedIn-0077B5?logo=linkedin&logoColor=white" /><a/>
  <a href="https://www.instagram.com/fe3liip3/" target="_blank">  
    <img src="https://img.shields.io/badge/Instagram-E4405F?logo=instagram&logoColor=white" /><a/>
  <a href="https://www.facebook.com/felipe.gadelha.545/" target="_blank">
    <img src="https://img.shields.io/badge/Facebook-1877F2?logo=facebook&logoColor=white" /><a/>
    <a href="felipegadelha90@gmail.com" target="_blank">
    <img src="https://img.shields.io/badge/Gmail-D14836?logo=gmail&logoColor=white" /></a>
  <a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
      <img alt="Twitter" src="https://img.shields.io/twitter/follow/Felipe52956739?label=Follow%20%40Felipe52956739&logo=Twitter&style=flat"></a>
</p>
<p align="center">
	<img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/FelipeGadelha/lottery-api?logo=GitHub&style=flat">
	<img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/FelipeGadelha/lottery-api?logo=GitHub">
	<img alt="GitHub closed pull requests" src="https://img.shields.io/github/issues-pr-closed/FelipeGadelha/lottery-api?logo=GitHub">
	<img alt="GitHub language count" src="https://img.shields.io/github/languages/count/FelipeGadelha/lottery-api?logo=GitHub">
	<img alt="GitHub top language" src="https://img.shields.io/github/languages/top/FelipeGadelha/lottery-api?logo=GitHub">
</p>

## :heavy_check_mark:O que há neste documento
- [Missão deste projeto](https://github.com/FelipeGadelha/lottery-api#speech_balloonmissão-deste-projeto)
- [Ferramentas utilizadas](https://github.com/FelipeGadelha/lottery-api#hammer_and_wrenchferramentas-utilizadas)
- [Executando os testes](https://github.com/FelipeGadelha/lottery-api#executando-todos-os-testes)
- [Executando o projeto com Docker](https://github.com/FelipeGadelha/lottery-api#whaleexecutando-o-projeto-com-docker)
- [Executando o projeto localmente](https://github.com/FelipeGadelha/lottery-api#computerexecutando-o-projeto-localmente)
- [Endpoints disponíveis](https://github.com/FelipeGadelha/lottery-api#mag_rightendpoints-disponíveis)

## :speech_balloon:Missão deste projeto

_Criar uma API REST que gerar números aleatórios para loteria._

## :mag_right:Endpoints disponíveis

Antecedido por <Strong>http://\<seu-host\>:8080/api/lottery</Strong> temos os endpoints

- /v1/user/register \(POST\) <br>

_Para a identificação da pessoa, é necessário associar cada número a um e-mail que é enviado no corpo da requisição, exemplo:_

```Json
{
	"email": "felipe@email.com"
}
```
- /v1/user/{email}/tickets \(GET\) <br>

_Este endpoint retorna uma lista em ordem de criação todas as apostas de um solicitante, passando seu e-mail como parâmetro, exemplo:_

```Json
[
    {
        "id": 5,
        "numbers": {
            "first": 3,
            "second": 44,
            "third": 13,
            "fourth": 30,
            "fifth": 39,
            "sixth": 15
        },
        "creationDate": "2021-04-04T22:40:05.149546-03:00"
    },
]
```

- /v1/user \(GET\) <br>

_Este endpoint retorna uma lista com todos os usuários e todas as suas apostas pertencentes, exemplo:_

```Json
[
    {
        "email": "felipe@email.com",
        "ticketsRs": [
            {
                "id": 1,
                "numbers": {
                    "first": 8,
                    "second": 17,
                    "third": 34,
                    "fourth": 26,
                    "fifth": 52,
                    "sixth": 31
                },
                "creationDate": "2021-04-02T21:54:45.868476-03:00"
            },
            {
                "id": 2,
                "numbers": {
                    "first": 24,
                    "second": 32,
                    "third": 25,
                    "fourth": 42,
                    "fifth": 18,
                    "sixth": 27
                },
                "creationDate": "2021-04-03T00:54:26.006615-03:00"
            },
            {
                "id": 3,
                "numbers": {
                    "first": 16,
                    "second": 48,
                    "third": 27,
                    "fourth": 28,
                    "fifth": 15,
                    "sixth": 23
                },
                "creationDate": "2021-04-04T22:39:02.899506-03:00"
            },
            {
                "id": 4,
                "numbers": {
                    "first": 49,
                    "second": 33,
                    "third": 57,
                    "fourth": 36,
                    "fifth": 20,
                    "sixth": 39
                },
                "creationDate": "2021-04-04T22:39:17.948983-03:00"
            }
        ]
    },
    {
        "email": "isabella@email.com",
        "ticketsRs": [
            {
                "id": 5,
                "numbers": {
                    "first": 3,
                    "second": 44,
                    "third": 13,
                    "fourth": 30,
                    "fifth": 39,
                    "sixth": 15
                },
                "creationDate": "2021-04-04T22:40:05.149546-03:00"
            },
            {
                "id": 6,
                "numbers": {
                    "first": 2,
                    "second": 3,
                    "third": 1,
                    "fourth": 5,
                    "fifth": 6,
                    "sixth": 4
                },
                "creationDate": "2021-04-04T22:43:26.126928-03:00"
            }
        ]
    }
]
```
- /v1/tickets/winner \(GET\) <br>

_Este endpoint gera uma sequência de 6 números aleatóreos entre 1 e 60_ <strong> (é possível existir mais de um ganhador)</strong>_, exemplo:_


```Json
{
    "numbers": {
        "first": 32,
        "second": 33,
        "third": 10,
        "fourth": 35,
        "fifth": 11,
        "sixth": 53
    }
}
```
- /swagger-ui/index.html?configUrl=/api/lottery/v3/api-docs/swagger-config# <br>

_Documentação da API._ 

## :hammer_and_wrench:Ferramentas utilizadas
<ul style="list-style-type: none;">
	<li  style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Java-FF0000?logo=java&logoColor=white" /></a></li>
		<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Maven-C71A36?logo={https://simpleicons.org/icons/apachemaven.svg}&logoColor=white" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=spring&logoColor=white" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Spring%20Validation-6DB33F?logo=spring&logoColor=white" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Spring%20Spring%20Data%20JPA-6DB33F?logo=spring&logoColor=white" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://springdoc.org" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Springdoc%20OpenApi-6DB33F?logo=spring&logoColor=white" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Modelmapper-14354C?logo=Maven&logoColor=white" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Flyway-1572B6?logoColor=white" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-316192?logo=postgresql" /></a></li>
	<li style="margin-bottom: 3px"><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Git-F05032?logo=git&logoColor=white" /></a></li>
	<li><a href="https://www.linkedin.com/in/felipe-gadelha-diniz-da-silva-aaaa4a158/" target="_blank">
		<img alt="PostgreSQL" src="https://img.shields.io/badge/Docker-2CA5E0?logo=docker&logoColor=white" /></a></li>
</ul>


## Executando os testes

No terminal, navegue até a pasta raiz do projeto e execute:

```shell
./mvnw test
```
no Windows:

```shell
./mvnw test
```

## :whale:Executando o projeto com Docker

No terminal, navegue até a pasta raiz do projeto e execute:

```shell
docker-compose up -d
```