-- Table: public.tramites

-- DROP TABLE public.tramites;

CREATE TABLE tramites
(
    cod_tre SMALLSERIAL PRIMARY KEY,
    tre_id character varying (255),
    tre_nombre character varying(100),
    tre_titulo character varying(200),
    tre_titulo_interno text,
    tre_glosa text,
    tre_hab character(1),
    tre_duracion character varying(40),
    tre_desc text,
    tre_costo integer,
    tre_tipo character(1),
    tre_buscar_en character varying(100),
    tre_cuenta integer,
    created_at timestamp without time zone,
    updated_at timestamp without time zone

);


