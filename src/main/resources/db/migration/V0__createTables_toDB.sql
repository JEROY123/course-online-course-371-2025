create table categories
(
    id          bigint not null auto_increment,
    description varchar(255),
    link_images varchar(255),
    name        varchar(255),
    primary key (id)
) engine=InnoDB;
create table clients
(
    id       bigint not null auto_increment,
    password varchar(255),
    username varchar(50),
    primary key (id)
) engine=InnoDB;
create table clients_roles_set
(
    clients_set_id bigint not null,
    roles_set_id   bigint not null,
    primary key (clients_set_id, roles_set_id)
) engine=InnoDB;
create table course_has_order
(
    id        bigint not null auto_increment,
    course_id bigint,
    order_id  bigint,
    primary key (id)
) engine=InnoDB;
create table courses
(
    id                bigint not null auto_increment,
    full_description  varchar(1024),
    link_image        varchar(255),
    name              varchar(255),
    price             decimal(38, 2),
    short_description varchar(200),
    category_id       bigint,
    teacher_id        bigint,
    primary key (id)
) engine=InnoDB;
create table customers
(
    id         bigint      not null,
    email      varchar(255),
    first_name varchar(60) not null,
    last_name  varchar(60) not null,
    phone      varchar(255),
    primary key (id)
) engine=InnoDB;
create table learning_archive
(
    id            bigint  not null auto_increment,
    course_grade  integer not null,
    finished_date datetime(6),
    course_id     bigint,
    student_id    bigint,
    teacher_id    bigint,
    primary key (id)
) engine=InnoDB;
create table orders
(
    id           bigint not null auto_increment,
    date_created datetime(6),
    status_order varchar(255),
    customer_id  bigint,
    payment_id   bigint,
    primary key (id)
) engine=InnoDB;
create table payments
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB;
create table roles
(
    id   bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB;
alter table clients_roles_set
    add constraint FKmbwe4nwag7myt4aqpevxlgvat foreign key (roles_set_id) references roles (id);
alter table clients_roles_set
    add constraint FKcklxarrjpprcxwgmru29srgpv foreign key (clients_set_id) references clients (id);
alter table course_has_order
    add constraint FK9fbp17vogp2vq8dd5uhbbxxs9 foreign key (course_id) references courses (id);
alter table course_has_order
    add constraint FKork2gcri395dagqdud33nftt foreign key (order_id) references orders (id);
alter table courses
    add constraint FK72l5dj585nq7i6xxv1vj51lyn foreign key (category_id) references categories (id);
alter table courses
    add constraint FKbexa0vbgy22xkb15gaaxrjwgw foreign key (teacher_id) references customers (id);
alter table customers
    add constraint FK6wx1ltbmqdavt7qutvrqcppg2 foreign key (id) references clients (id);
alter table learning_archive
    add constraint FKhmr90vqqmq0kwsffh55lrtpv7 foreign key (course_id) references courses (id);
alter table learning_archive
    add constraint FKay8atxrfaxr1ol4bvirdaq72h foreign key (student_id) references customers (id);
alter table learning_archive
    add constraint FKkuiydm1pmav9bl2dqa4yyad5 foreign key (teacher_id) references customers (id);
alter table orders
    add constraint FKpxtb8awmi0dk6smoh2vp1litg foreign key (customer_id) references customers (id);
alter table orders
    add constraint FK8aol9f99s97mtyhij0tvfj41f foreign key (payment_id) references payments (id);