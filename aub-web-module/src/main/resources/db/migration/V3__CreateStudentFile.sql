create table student (
                         id SMALLSERIAL PRIMARY KEY,
                         student_id character varying(255),
                         ci integer not null,
                         passport integer not null,
                         lastname varchar (55) not null,
                         name varchar (55) not null,
                         gender character varying(55) NOT NULL,
                         nationality character varying(55) NOT NULL,
                         creation_date timestamp without time zone,
                         modified_date timestamp without time zone
);

create table degree (
                        id SMALLSERIAL PRIMARY KEY,
                        degree_id character varying(255),
                        degree_num integer not null,
                        date_initial date,
                        observation character varying(255) NOT NULL,
                        folio_num integer not null,
                        folio_date date,
                        typeId     SMALLINT,
                        studentId     SMALLINT,
                        creation_date timestamp without time zone,
                        modified_date timestamp without time zone
);
alter table degree add constraint FK_Degree_RefTypeFile foreign key (typeId)
    references type_file (id) on delete restrict on update restrict;

alter table degree add constraint FK_Degree_RefStudent foreign key (studentId)
    references student (id) on delete restrict on update restrict;