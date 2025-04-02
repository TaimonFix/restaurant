-- create schema waiter;
CREATE TABLE IF NOT EXISTS waiter_account (
    waiter_id BIGINT PRIMARY KEY,
    name VARCHAR NOT NULL,
    employment_date TIMESTAMP WITH TIME ZONE NOT NULL,
    sex VARCHAR NOT NULL
);

CREATE TABLE IF NOT EXISTS waiter_order (
    order_no BIGINT PRIMARY KEY,
    status VARCHAR NOT NULL,
    create_dttm TIMESTAMP WITH TIME ZONE NOT NULL,
    waiter_id BIGINT NOT NULL,
    table_no VARCHAR NOT NULL,
    FOREIGN KEY (waiter_id) REFERENCES waiter_account(waiter_id)
);

CREATE TABLE IF NOT EXISTS payment (
    order_no BIGINT PRIMARY KEY,
    payment_type VARCHAR,
    payment_date TIMESTAMP WITH TIME ZONE,
    payment_sum NUMERIC,
    FOREIGN KEY (order_no) REFERENCES waiter_order(order_no)
);

CREATE TABLE IF NOT EXISTS menu (
    id BIGINT PRIMARY KEY,
    dish_name VARCHAR NOT NULL,
    dish_cost NUMERIC NOT NULL
);

    CREATE TABLE IF NOT EXISTS order_positions (
    composition_id BIGINT PRIMARY KEY,
    dish_num BIGINT NOT NULL,
    order_no BIGINT NOT NULL,
    menu_position_id BIGINT NOT NULL,
    FOREIGN KEY (order_no) REFERENCES waiter_order(order_no),
    FOREIGN KEY (menu_position_id) REFERENCES menu(id)
);
