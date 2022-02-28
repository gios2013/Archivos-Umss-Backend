create TABLE group_file (
                              id SMALLSERIAL PRIMARY KEY,
                              groupNum integer NOT NULL,
                              minimumRange integer NOT NULL,
                              maximumRange integer NOT NULL,
                              observation character varying(255) NOT NULL,
                              date_initial date,
                              group_file_id character varying(255),
                              creation_date timestamp without time zone,
                              modified_date timestamp without time zone
);