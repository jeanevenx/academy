# BOOTCAMP BANCO PAN JAVA DEVELOPER
## Explorando JPA e Padrões de projeto em SpringBoot

Para explorar as possibilidades do **JPA** e os **padrões de projeto** em **Spring Boot**, desenvolvi uma 
**API Restful** para uma academia digital. Essa **API** permite que um aluno seja registrado no banco de dados, 
o que automaticamente o matricula e grava as informações na tabela correspondente. Além disso, ela possibilita 
o cadastro da avaliação física do aluno. Embora ainda haja espaço para aprimoramentos, este projeto foi uma oportunidade 
para demonstrar como implementar uma **API** em **Spring Boot** utilizando padrões como **_Singleton_**, **_Strategy_** e **_Facade_**.

### As principais tecnologias utilizadas para o desenvolvimento desta API Restful, incluindo
- Java 17
- Maven
- Spring Boot

### As principais dependências:
- Spring Data JPA
- OpenFeign
- H2 Database
- Lombok
- Hibernate validator


## Endpoints

### **Cadastrar um aluno**
#### `POST` `/student`


#### **Exemplo de requisição**

```
// POST /student
{
    "name": "Jean Evenx",
    "cpf": "335.789.410-69",
    "yearOfBirth": "2000-02-19",
    "cep": "08431290"
}
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
**status code: 200 OK** 

```
{
    "name": "Jean Evenx",
    "cpf": "335.789.410-69",
    "yearOfBirth": "2000-02-19",
    "cep": "08431190"
}
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 




### **Atualizar um aluno**
#### `PUT` `/student/{id}`


#### **Exemplo de requisição**

```
// PUT /student/1
{
    "name": "Jean Evenx",
    "yearOfBirth": "2001-02-20",
    "cep": "08431290",
    "complemento": "3"
}
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
**status code: 200 OK** 

```
{
    "name": "Jean Evenx",
    "yearOfBirth": "2001-02-20",
    "cep": "08431290",
    "complemento": "3"
}
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 


### **Buscar todos os alunos**
#### `GET` `/student`


#### **Exemplo de requisição**

```
Get /student
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
**status code: 200 OK** 

```
[
    {
        "id": 1,
        "name": "Jean Evenx",
        "cpf": "335.789.410-69",
        "address": {
            "cep": "08431190",
            "logradouro": "Rua Manuel Xavier dos Passos",
            "complemento": "",
            "bairro": "Jardim Guaianazes",
            "localidade": "São Paulo",
            "uf": "SP",
            "ibge": "3550308",
            "gia": "1004",
            "ddd": "11",
            "siafi": "7107"
        },
        "yearOfBirth": "2000-02-19"
    }
    ...
]
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 



### **Buscar um aluno pelo id**
#### `GET` `/student/{id}`


#### **Exemplo de requisição**

```
GET /student/1
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
**status code: 200 OK** 

```
    {
        "id": 1,
        "name": "Jean Evenx",
        "cpf": "335.789.410-69",
        "address": {
            "cep": "08431190",
            "logradouro": "Rua Manuel Xavier dos Passos",
            "complemento": "",
            "bairro": "Jardim Guaianazes",
            "localidade": "São Paulo",
            "uf": "SP",
            "ibge": "3550308",
            "gia": "1004",
            "ddd": "11",
            "siafi": "7107"
        },
        "yearOfBirth": "2000-02-19"
    }
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 



### **Deletar um aluno pelo id**
#### `DELETE` `/student/{id}`


#### **Exemplo de requisição**

```
DELETE /student/1
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 


### **Buscar todas as matrículas**
#### `GET` `/enrollment`


#### **Exemplo de requisição**

```
GET /enrollment
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
  **status code: 200 OK**

```
[
    {
        "id": 1,
        "enrollmentDate": "2023-04-26T12:23:41.824579",
        "studentInfo": {
            "studentId": 1,
            "name": "Jean Evenx",
            "cpf": "335.789.410-69"
        }
    }
    ...
]
```
- Caso não: <br>
  **status code: 500 Internal Server Error**


### **Cadastrar uma avaliação para um aluno**
#### `POST` `/evaluation`


#### **Exemplo de requisição**

```
// POST /evaluation
{
    "studentId": 1,
    "weight": 66.3,
    "height": 185.6
}
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
  **status code: 200 OK**

```
{
    "studentId": 1,
    "weight": 66.3,
    "height": 185.6
}
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 

### **Buscar todas as avaliações**
#### `GET` `/evaluation`


#### **Exemplo de requisição**

```
GET /evaluation
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
  **status code: 200 OK**

```
[
    {
        "id": 1,
        "name": "Jean Evenx",
        "cpf": "335.789.410-69",
        "address": {
            "cep": "08431190",
            "logradouro": "Rua Manuel Xavier dos Passos",
            "complemento": "",
            "bairro": "Jardim Guaianazes",
            "localidade": "São Paulo",
            "uf": "SP",
            "ibge": "3550308",
            "gia": "1004",
            "ddd": "11",
            "siafi": "7107"
        },
        "yearOfBirth": "2000-02-19"
    },
        "evaluationDate": "2023-04-26T12:16:46.308076",
        "weight": 66.3,
        "height": 185.6
    }
    ...
]
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 


### **Buscar uma avaliação pelo id do aluno**
#### `GET` `/evaluation{id}`


#### **Exemplo de requisição**

```
GET /evaluation/1
```

#### **Exemplos de resposta**

- Caso a requisição tenha sido bem sucedida, a seguinte resposta será retornada: <br>
  **status code: 200 OK**

```
{
        "id": 1,
        "name": "Jean Evenx",
        "cpf": "335.789.410-69",
        "address": {
            "cep": "08431190",
            "logradouro": "Rua Manuel Xavier dos Passos",
            "complemento": "",
            "bairro": "Jardim Guaianazes",
            "localidade": "São Paulo",
            "uf": "SP",
            "ibge": "3550308",
            "gia": "1004",
            "ddd": "11",
            "siafi": "7107"
        },
        "yearOfBirth": "2000-02-19"
    },
        "evaluationDate": "2023-04-26T12:16:46.308076",
        "weight": 66.3,
        "height": 185.6
    }
```
- Caso não: <br>
  **status code: 500 Internal Server Error** 



<span style="color:red">**OBS:**</span> Esta foi a minha implementação para os dois últimos desafios do Bootcamp Banco Pan Java Developer. 
         Sinta-se à vontade para relatar problemas e contribuir com o projeto.
