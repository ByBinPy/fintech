CREATE TABLE users (
    id integer primary key,
    ip varchar(20) unique not null
);
CREATE TABLE translations (
    client_id integer references users(id),
    received_text varchar(500) not null,
    translated_text varchar(700) not null
)