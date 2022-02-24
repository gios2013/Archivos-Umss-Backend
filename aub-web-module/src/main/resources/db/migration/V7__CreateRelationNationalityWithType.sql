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
