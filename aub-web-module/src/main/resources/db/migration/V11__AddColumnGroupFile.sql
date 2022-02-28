AlTER table degree add group_file_id SMALLINT;

alter table degree add constraint FK_Degree_RefGroupFile foreign key (group_file_id)
    references group_file (id) on delete restrict on update restrict;