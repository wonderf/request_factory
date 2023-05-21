CREATE TABLE IF NOT EXISTS account(
    id bigserial NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL,
    pass    varchar(255) NOT NULL,
    shared_secret varchar(255) NOT NULL,
    identity_secret varchar(255) NOT NULL,
    steam_id varchar(255) NOT NULL,
    market_key varchar(255) NOT NULL,
    proxy_id bigserial,
    status_id bigserial NOT NULL
);
CREATE TABLE IF NOT EXISTS proxy_settings(
    id bigserial NOT NULL PRIMARY KEY,
    short_name varchar(255) NOT NULL,
    login varchar(255) NULL,
    pass varchar(255) NULL,
    ip varchar(255) NOT NULL,
    port integer NOT NULL

);
ALTER TABLE account add constraint fk_proxy foreign key (proxy_id) references proxy_settings;

create table if not exists account_status(
    id bigserial NOT NULL PRIMARY KEY,
    description varchar(255),
    name varchar(255) NOT NULL,
    code integer NOT NULL
);

ALTER TABLE account add constraint fk_status foreign key (status_id) references account_status;