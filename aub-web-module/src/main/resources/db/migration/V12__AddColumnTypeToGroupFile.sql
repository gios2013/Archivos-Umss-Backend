AlTER table group_file add type_group_id SMALLINT;

alter table group_file add constraint FK_GroupFile_RefTypeFile foreign key (type_group_id)
    references type_file (id) on delete restrict on update restrict;