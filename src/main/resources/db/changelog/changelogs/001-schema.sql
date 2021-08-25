--liquibase formatted sql

--changeset djigit:create_init_schema
create table event (id int4 not null, date timestamp, description varchar(255), title varchar(255), primary key (id));
create table event_visitors (event_id int4 not null, visitors_id int4 not null);
create table news (id int4 not null, description varchar(255), likes int4 not null, title varchar(255), views int4 not null, primary key (id));
create table "User" (id int4 not null, email varchar(255), lastname varchar(255), login varchar(255), name varchar(255), primary key (id));
--rollback drop table event;
--rollback drop table event_visitors;
--rollback drop table news;
--rollback drop table "User";

--changeset djigit:alter_news_and_create_puzzle

alter table news
    add column author_id int4;

alter table news
    add constraint fk_news_author
        foreign key (author_id)
            references "User"(id);

create table puzzle(
    id int4 not null ,
    description varchar(100),
    imageUrl varchar(100),
    userFirstMove varchar(10),
    correctFirstMoves varchar(50),
    primary key (id)
)

--rollback alter table news
--rollback drop column author_id;
--rollback drop table puzzle;