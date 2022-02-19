create TABLE attachment (
                              id SMALLSERIAL PRIMARY KEY,
                              name varchar (55) not null,
                              numTitulo integer not null,
                              register_date date,
                              observation character varying(255),
                              size BIGINT not null,
                              path varchar (100) not null,
                              degreeId SMALLINT,
                              attachment_id character varying(255),
                              creation_date timestamp without time zone
);

alter table attachment add constraint FK_Attachment_RefDegree foreign key (degreeId)
    references degree (id) on delete restrict on update restrict;

create TABLE student_record (
                            id SMALLSERIAL PRIMARY KEY,
                            name varchar (55) not null,
                            numTitulo integer not null,
                            register_date date,
                            observation character varying(255),
                            size BIGINT not null,
                            path varchar (100) not null,
                            degreeId SMALLINT,
                            attachment_id character varying(255),
                            creation_date timestamp without time zone
);

alter table student_record add constraint FK_Student_Record_RefDegree foreign key (degreeId)
    references degree (id) on delete restrict on update restrict;