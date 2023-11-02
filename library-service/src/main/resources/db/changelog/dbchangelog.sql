CREATE TABLE public.library_record
(
    record_id character varying,
    title character varying,
    author character varying,
    format character varying,
    PRIMARY KEY (record_id)
);

ALTER TABLE IF EXISTS public.library_record
    OWNER to postgres;