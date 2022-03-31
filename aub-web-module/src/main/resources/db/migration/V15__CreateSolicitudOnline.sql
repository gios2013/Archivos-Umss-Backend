-- Table: public.tramites
CREATE TABLE Solicitud
(
    id SMALLSERIAL NOT NULL PRIMARY KEY,
    user_id VARCHAR,
    email VARCHAR,
    account VARCHAR,
    name VARCHAR,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

