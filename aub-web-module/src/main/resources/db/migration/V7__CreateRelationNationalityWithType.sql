create TABLE nationality_type (
                             id SMALLSERIAL PRIMARY KEY,
                             id_nationality SMALLINT,
                             id_type SMALLINT,
                             active bool NOT NULL
);
alter table nationality_type add constraint FK_nationality_type_RefNationality foreign key (id_nationality)
    references nationality (id) on delete restrict on update restrict;

alter table nationality_type add constraint FK_nationality_type_RefTypeFile foreign key (id_type)
    references type_file (id) on delete restrict on update restrict;

INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (24,1000,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (24,1001,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (24,1003,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (24,1004,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (24,1,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (27,1000,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (27,1001,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (27,1003,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (27,1004,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (27,1,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (3,1000,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (3,1001,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (3,1003,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (3,1004,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (3,1,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (9,1000,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (9,1001,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (9,1003,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (9,1004,true);
INSERT INTO nationality_type (id_nationality,id_type,active) VALUES (9,1,true);