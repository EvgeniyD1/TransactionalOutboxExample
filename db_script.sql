create table if not exists customer_orders
(
    id bigserial
    constraint customer_order_pk
    primary key,
    quantity integer,
    name varchar
);


create table if not exists outbox
(
    id bigserial
    constraint outbox_pk
    primary key,
    event varchar,
    event_id bigint,
    payload varchar,
    created_at timestamp
);