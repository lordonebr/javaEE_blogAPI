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
  GET http://localhost:8080/templatejee/rest/authors/{id_author}
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
  DELETE http://localhost:8080/templatejee/rest/authors/{id_author}
  ```  
  Exemplo para deletar o autor de id = 1:
  http://localhost:8080/templatejee/rest/authors/1


---- POSTAGENS------------------------------------------------------- 
  * Recupera todas as postagens por ordem cronológica (por ordem da data de criação):  
  ```
  GET http://localhost:8080/templatejee/rest/posts
  ```  
  
  * Recupera uma postagem específica:  
  ```
  GET http://localhost:8080/templatejee/rest/posts/{id_post}
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
  
  * Operação para remover uma postagem:  
  ```   
  DELETE http://localhost:8080/templatejee/rest/posts/{id_post}
  ```  
  Exemplo para deletar a postagem de id = 2:
  http://localhost:8080/templatejee/rest/posts/2
  
  
  * Operação para remover uma postagem de um autor:  
  ```   
  DELETE http://localhost:8080/templatejee/rest/authors/{id_author}/posts/{id_post}
  ```  
  Exemplo para deletar a postagem de id = 2 do autor de id = 1:  
  http://localhost:8080/templatejee/rest/authors/1/posts/2


---- COMENTÁRIOS------------------------------------------------------- 
  * Recupera todos os comentários por ordem cronológica (por ordem da data de criação):  
  ```
  GET http://localhost:8080/templatejee/rest/comments
  ```  
  
  * Recupera um comentário específico:  
  ```
  GET http://localhost:8080/templatejee/rest/comments/{id_comment}
  ```
  Exemplo para recuperar o comentário de id = 1:
  http://localhost:8080/templatejee/rest/comments/1  
  
  * Recupera todas os comentários de uma postagem:  
  ```
  GET http://localhost:8080/templatejee/rest/posts/{id_post}/comments
  ```  
  Exemplo para recuperar todos os comentários da postagem de id = 1:
  http://localhost:8080/templatejee/rest/posts/1/comments
  
  * Operação para adicionar um comentário em uma postagem (JSON obrigatório):  
  ```
  POST http://localhost:8080/templatejee/rest/posts/{id_post}/comments
  ```  
  Exemplo para criar um novo comentário para a postagem de id = 1:
  http://localhost:8080/templatejee/rest/posts/1/comments 
  JSON:
  {
		    "text": "novo texto comentário",
		    "userName": "Ana Luiza"
		}
  
  * Operação para remover um comentário:  
  ```   
  DELETE http://localhost:8080/templatejee/rest/comments/{id_comment}
  ```  
  Exemplo para deletar o comentário de id = 2:
  http://localhost:8080/templatejee/rest/comments/2
  
