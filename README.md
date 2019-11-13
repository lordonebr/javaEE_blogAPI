# javaEE_blogAPI
Trabalho Final da disciplina: FRAMEWORKS BACK-END - JAVA

### To access web services:    
---- AUTORES------------------------------------------------------- 
  * Recupera todos os autores:  
  ```
  GET http://localhost:8080/templatejee/rest/authors
  ```  
      
  * Recupera um autor específico:  
  ```
  GET http://localhost:8080/templatejee/rest/authors/{id}
  ```
  Exemplo para recuperar o autor de id = 1:
  http://localhost:8080/templatejee/rest/authors/1      
    
  * Operação para adicionar um autor (JSON obrigatório):  
  ```
  POST http://localhost:8080/templatejee/rest/authors
  ```  
  Exemplo de JSON onde cria um novo autor com o nome Harry Potter:
  {
    "name": "Harry Potter"
  }  
      
  * Operação para atualizar um autor (JSON obrigatório):  
  ```   
  PUT http://localhost:8080/templatejee/rest/authors
  ```
  Exemplo de JSON que atualiza o nome do autor de id = 1:
  {
    "id": 1,
    "name": "Tony Hawk"
  }  
      
  * Operação para remover um autor:  
  ```   
  DELETE http://localhost:8080/templatejee/rest/authors/{id}
  ```  
  Exemplo para deletar o autor de id = 1:
  http://localhost:8080/templatejee/rest/authors/1


---- POSTAGENS------------------------------------------------------- 
  * Recupera todas as postagens:  
  ```
  GET http://localhost:8080/templatejee/rest/posts
  ```  
  
  * Recupera uma postagem específica:  
  ```
  GET http://localhost:8080/templatejee/rest/posts/{id}
  ```
  Exemplo para recuperar a postagem de id = 1:
  http://localhost:8080/templatejee/rest/posts/1  
  
  * Recupera todas as postagens de um autor:  
  ```
  GET http://localhost:8080/templatejee/rest/authors/{id_author}/posts
  ```  
  Exemplo para recuperar todos as postagens do autor de id = 1:
  http://localhost:8080/templatejee/rest/authors/1/posts  
      
  * Operação para adicionar uma postagem de um autor (JSON obrigatório):  
  ```
  POST http://localhost:8080/templatejee/rest/authors/{id_author}/posts
  ```  
  Exemplo para criar uma nova postagem para o autor de id = 1:
  http://localhost:8080/templatejee/rest/authors/1/posts   
  JSON:
  {
    "text": "novo texto",
    "title": "novo titulo"
  }
  
  * Operação para atualizar uma postagem de um autor (JSON obrigatório):  
  ```   
  PUT http://localhost:8080/templatejee/rest/authors/{id_author}/posts
  ```
  Exemplo para atualizar a postagem de id = 2 do autor de id = 1:
  http://localhost:8080/templatejee/rest/authors/1/posts   
  JSON:
  {
    "id": 2,
    "text": "texto atualizado",
    "title": "titulo atualizado"
  }
