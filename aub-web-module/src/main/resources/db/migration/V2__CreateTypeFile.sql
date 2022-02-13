create TABLE type_file (
                         id SMALLSERIAL PRIMARY KEY,
                         name varchar (55) not null,
                         code character varying(55) NOT NULL,
                         description character varying(255) NOT NULL,
                         type_id character varying(255),
                         creation_date timestamp without time zone,
                         modified_date timestamp without time zone
);