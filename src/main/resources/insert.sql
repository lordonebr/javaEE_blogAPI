insert into AUTHOR (id, name) values ('1', 'Andre');
insert into AUTHOR (id, name) values ('2', 'Alice');
insert into AUTHOR (id, name) values ('3', 'Marina');
insert into AUTHOR (id, name) values ('4', 'M�rcia');
 call next value for SE_AUTHOR;
 call next value for SE_AUTHOR;
 call next value for SE_AUTHOR;
 call next value for SE_AUTHOR;
insert into POST (id, title, text) values ('1', 'T�tulo postagem 1', 'Primeira postagem!');
insert into POST (id, title, text) values ('2', 'T�tulo postagem 2', 'Segunda postagem!');
  call next value for SE_POST;
  call next value for SE_POST;
update POST set POST_ID = 1 where id = 1
update POST set POST_ID = 2 where id = 2  