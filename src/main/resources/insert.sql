insert into AUTHOR (id, name) values ('1', 'Andre');
insert into AUTHOR (id, name) values ('2', 'Alice');
insert into AUTHOR (id, name) values ('3', 'Mariana');
insert into AUTHOR (id, name) values ('4', 'Márcia');
 call next value for SE_AUTHOR;
 call next value for SE_AUTHOR;
 call next value for SE_AUTHOR;
 call next value for SE_AUTHOR;
insert into POST (id, title, text, dateCreated, dateLastUpdated) values ('1', 'Título postagem 1', 'Primeira postagem do autor 1!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into POST (id, title, text, dateCreated, dateLastUpdated) values ('2', 'Título postagem 2', 'Segunda postagem do autor 1!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into POST (id, title, text, dateCreated, dateLastUpdated) values ('3', 'Título postagem 3', 'Primeira postagem do autor 2!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
  call next value for SE_POST;
  call next value for SE_POST;
  call next value for SE_POST;
update POST set POST_ID = 1 where id = 1
update POST set POST_ID = 1 where id = 2
update POST set POST_ID = 2 where id = 3  
insert into COMMENT (id, userName, text, dateCreated) values ('1', 'Paulo', 'Primeiro comentário na postagem 1!', CURRENT_TIMESTAMP);
insert into COMMENT (id, userName, text, dateCreated) values ('2', 'Arthur', 'Segundo comentário na postagem 1!', CURRENT_TIMESTAMP);
insert into COMMENT (id, userName, text, dateCreated) values ('3', 'Maria', 'Primeiro comentário na postagem 3!', CURRENT_TIMESTAMP);
  call next value for SE_COMMENT;
  call next value for SE_COMMENT;
  call next value for SE_COMMENT;
update COMMENT set COMMENT_ID = 1 where id = 1
update COMMENT set COMMENT_ID = 1 where id = 2
update COMMENT set COMMENT_ID = 3 where id = 3    