create TABLE section_file (
                         id SMALLSERIAL PRIMARY KEY,
                         code character varying(55) NOT NULL,
                         description character varying(255) NOT NULL,
                         date_initial date,
                         name varchar (55) not null,
                         initials_und varchar (55) not null,
                         section_id character varying(255),
                         creation_date timestamp without time zone,
                         modified_date timestamp without time zone
);