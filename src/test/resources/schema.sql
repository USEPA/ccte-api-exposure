-- create schema
create schema ep;

-- create tables

create table ep.v_product_data
(
    id                    bigint not null
        constraint product_data_pkey
            primary key,
    dtxsid                varchar(50),
    docid                 integer,
    doctitle              varchar(500),
    docdate               varchar(25),
    productname           varchar(255),
    gencat                varchar(50),
    prodfam               varchar(50),
    prodtype              varchar(100),
    classificationmethod  varchar(100),
    rawmincomp            varchar(100),
    rawmaxcomp            varchar(100),
    rawcentralcomp        varchar(100),
    unittype              varchar(50),
    lowerweightfraction   numeric(16, 15),
    upperweightfraction   numeric(16, 15),
    centralweightfraction numeric(16, 15),
    weightfractiontype    varchar(50),
    component             varchar(200)
);

create table ep.v_puc
(
    id         bigint not null
        constraint puc_pkey
            primary key,
    kind_name  varchar(50),
    gen_cat    varchar(50),
    prodfam    varchar(50),
    prodtype   varchar(100),
    definition text
);

create table ep.v_demo_expo_predictions
(
    id          serial,
    dtxsid      varchar(20),
    demographic varchar(25),
    predictor   varchar(25),
    median      double precision,
    median_text varchar(25),
    l95         double precision,
    l95_text    varchar(25),
    u95         double precision,
    u95_text    varchar(25),
    units       varchar(20),
    ad          integer,
    reference   varchar(20),
    data_version        varchar(50),
    import_date         timestamp default now()
);


create table ep.v_functional_use_category
(
    id            integer,
    created_at    timestamp,
    updated_at    timestamp,
    title         varchar(100),
    description   text,
    created_by_id integer,
    updated_by_id integer
);

create table ep.v_functional_use
(
    id               bigint,
    dtxsid           varchar(50),
    datatype         varchar(50),
    docid            integer,
    doctitle         varchar(500),
    docdate          varchar(25),
    reportedfunction varchar(255),
    functioncategory varchar(100)
);

create table ep.v_list_presence
(
    id               bigint not null
        constraint list_presence_pk
            primary key,
    dtxsid           varchar(50),
    docid            integer,
    doctitle         varchar(500),
    docsubtitle      varchar(250),
    docdate          varchar(25),
    organization     varchar(255),
    reportedfunction varchar(255),
    functioncategory varchar(100),
    component        varchar(200),
    keywordset       text
);

create table ep.v_list_presence_tag
(
    id             bigint not null
        constraint list_presence_tag_pk
            primary key,
    tag_name       varchar(100),
    tag_definition varchar(750),
    kind_name      varchar(50)
);

create table ep.v_gen_expo_predictions
(
    dtxsid                  varchar(20),
    production_volume       numeric,
    units                   varchar(7),
    stockholm_convention    integer,
    probability_dietary     numeric(5, 4),
    probability_residential numeric(5, 4),
    probability_pesticde    numeric(5, 4),
    probability_industrial  numeric(5, 4),
    data_version            varchar(50),
    import_date         timestamp default now()
);


create table ep.v_httk_data
(
    id                  serial,
    dtxsid              varchar(20),
    parameter           varchar(15),
    measured            numeric,
    measured_text       varchar(15),
    predicted           numeric,
    predicted_text      varchar(15),
    units               varchar(30),
    model               varchar(15),
    reference           varchar(150),
    percentile          varchar(5),
    species             varchar(10),
    data_source_species varchar(10),
    data_version        varchar(50),
    import_date         timestamp default now()
);

create sequence ep.qsur_data_id_seq
    as integer;

create table ep.v_qsur_data
(
    id                        integer default nextval('ep.qsur_data_id_seq'::regclass) not null
        constraint qsur_data_pk
            primary key,
    dtxsid                    varchar(50),
    harmonized_functional_use varchar(50),
    probability               numeric
);

alter sequence ep.qsur_data_id_seq owned by ep.v_qsur_data.id;






