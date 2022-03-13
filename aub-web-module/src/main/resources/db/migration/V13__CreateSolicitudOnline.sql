-- Table: public.tramites
CREATE TABLE Solicitud
(
    id SMALLSERIAL PRIMARY KEY,
    user_id VARCHAR,
    email VARCHAR,
    account VARCHAR,
    name VARCHAR,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);


