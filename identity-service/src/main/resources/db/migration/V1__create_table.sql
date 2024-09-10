create table permission
(
    id                varchar(50) not null PRIMARY KEY,
    created_by        varchar(50),
    created_date_time timestamp(6),
    transaction_date  date,
    updated_by        varchar(50),
    updated_date_time timestamp(6),
    description       varchar(150),
    name              varchar(100)
);

create table role
(
    id                varchar(50) not null PRIMARY KEY,
    created_by        varchar(50),
    created_date_time timestamp(6),
    transaction_date  date,
    updated_by        varchar(50),
    updated_date_time timestamp(6),
    description       varchar(150),
    name              varchar(100)
);

create table authority
(
    id                varchar(50) not null PRIMARY KEY,
    created_by        varchar(50),
    created_date_time timestamp(6),
    transaction_date  date,
    updated_by        varchar(50),
    updated_date_time timestamp(6),
    feature_name      varchar(100),
    permission_id     varchar(50),
    role_id           varchar(50),
    constraint fk2hibyy3xk3s82ao3xa08sjm7r
        foreign key (permission_id) references permission,
    constraint fkm3ayk11jc13258isylu5wpney
        foreign key (role_id) references role
);

create table users
(
    id                varchar(50) not null PRIMARY KEY,
    created_by        varchar(50),
    created_date_time timestamp(6),
    transaction_date  date,
    updated_by        varchar(50),
    updated_date_time timestamp(6),
    username          varchar(50),
    password          varchar(100),
    full_name         varchar(150),
    dob               date,
    email             varchar(100),
    status            varchar(30)
);

create table users_roles
(
    user_id  varchar(50) not null,
    roles_id varchar(50) not null,
    constraint fk15d410tj6juko0sq9k4km60xq
        foreign key (roles_id) references role,
    constraint fk2o0jvgh89lemvvo17cbqvdxaa
        foreign key (user_id) references users
);

