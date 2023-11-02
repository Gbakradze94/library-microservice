CREATE TABLE public.library_record
(
    record_id character varying,
    title character varying,
    author character varying,
    format character varying
);

ALTER TABLE IF EXISTS public.library_record
    OWNER to postgres;