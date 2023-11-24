CREATE USER 'group01'@'%' IDENTIFIED BY '123456a@';
GRANT ALL ON finding_tutor.* TO 'group01'@'%';

CREATE DATABASE finding_tutor;
USE finding_tutor;
DROP TABLE IF EXISTS qualification;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS finding_tutor.schedule;
DROP TABLE IF EXISTS finding_tutor.subject;
DROP TABLE IF EXISTS transaction_history;
DROP TABLE IF EXISTS user;

create table qualification
(
    qualification_id BIGINT NOT NULL AUTO_INCREMENT,
    name             VARCHAR(250),
    description      VARCHAR(250),
    expiry_date      DATE,
    image     VARCHAR(1000),
    user_id          BIGINT,
    PRIMARY KEY (qualification_id)
);

create table review
(
    review_id   BIGINT NOT NULL AUTO_INCREMENT,
    content     VARCHAR(500),
    sender_id   VARCHAR(250),
    receiver_id DATE,
    create_at   TIMESTAMP,
    update_at   TIMESTAMP,
    PRIMARY KEY (review_id)
);

create table finding_tutor.schedule
(
    schedule_id BIGINT NOT NULL AUTO_INCREMENT,
    user_id     BIGINT,
    start_time  TIMESTAMP,
    end_time    TIMESTAMP,
    title       VARCHAR(250),
    description VARCHAR(250),
    PRIMARY KEY (schedule_id)
);

create table finding_tutor.subject
(
    subject_id   BIGINT NOT NULL AUTO_INCREMENT,
    subject_name VARCHAR(250),
    description  VARCHAR(250),
    PRIMARY KEY (subject_id)
);

create table transaction_history
(
    trans_id    BIGINT NOT NULL AUTO_INCREMENT,
    createAt    TIMESTAMP,
    amount      DOUBLE,
    send_id     BIGINT,
    receiver_id BIGINT,
    PRIMARY KEY (trans_id)
);

create table user
(
    user_id   BIGINT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(250),
    dob       DATE,
    email     VARCHAR(250),
    major     VARCHAR(250),
    password  VARCHAR(250),
    role      VARCHAR(250),
    image     VARCHAR(1000),
    PRIMARY KEY (user_id)
);

create table tutor_subject
(
    user_id    BIGINT NOT NULL,
    subject_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, subject_id)
);

create table user_schedule
(
    user_id    BIGINT NOT NULL,
    schedule_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, schedule_id)
);

