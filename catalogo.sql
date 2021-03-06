PGDMP     0    /                z            catalogo    14.1    14.1 0    -           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            .           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            /           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            0           1262    25546    catalogo    DATABASE     d   CREATE DATABASE catalogo WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE catalogo;
                postgres    false            ?            1259    37901    autore    TABLE     ?   CREATE TABLE public.autore (
    id bigint NOT NULL,
    cognome character varying(255) NOT NULL,
    nome character varying(255) NOT NULL
);
    DROP TABLE public.autore;
       public         heap    postgres    false            ?            1259    37900    autore_id_seq    SEQUENCE     v   CREATE SEQUENCE public.autore_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.autore_id_seq;
       public          postgres    false    211            1           0    0    autore_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.autore_id_seq OWNED BY public.autore.id;
          public          postgres    false    210            ?            1259    37910 	   categoria    TABLE     d   CREATE TABLE public.categoria (
    id bigint NOT NULL,
    nome character varying(255) NOT NULL
);
    DROP TABLE public.categoria;
       public         heap    postgres    false            ?            1259    37909    categoria_id_seq    SEQUENCE     y   CREATE SEQUENCE public.categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.categoria_id_seq;
       public          postgres    false    213            2           0    0    categoria_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;
          public          postgres    false    212            ?            1259    37899    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    37916    libri_autori    TABLE     b   CREATE TABLE public.libri_autori (
    id_libro bigint NOT NULL,
    id_autore bigint NOT NULL
);
     DROP TABLE public.libri_autori;
       public         heap    postgres    false            ?            1259    37919    libri_categorie    TABLE     h   CREATE TABLE public.libri_categorie (
    id_libro bigint NOT NULL,
    id_categorie bigint NOT NULL
);
 #   DROP TABLE public.libri_categorie;
       public         heap    postgres    false            ?            1259    37923    libro    TABLE     ?   CREATE TABLE public.libro (
    id bigint NOT NULL,
    anno_pubblicazione integer NOT NULL,
    prezzo double precision NOT NULL,
    titolo character varying(255) NOT NULL
);
    DROP TABLE public.libro;
       public         heap    postgres    false            ?            1259    37922    libro_id_seq    SEQUENCE     u   CREATE SEQUENCE public.libro_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.libro_id_seq;
       public          postgres    false    217            3           0    0    libro_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.libro_id_seq OWNED BY public.libro.id;
          public          postgres    false    216            ?            1259    37929    role    TABLE     W   CREATE TABLE public.role (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.role;
       public         heap    postgres    false            ?            1259    37934 	   user_role    TABLE     ^   CREATE TABLE public.user_role (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);
    DROP TABLE public.user_role;
       public         heap    postgres    false            ?            1259    37939    user_spring    TABLE     ?   CREATE TABLE public.user_spring (
    id integer NOT NULL,
    email character varying(255) NOT NULL,
    is_active boolean NOT NULL,
    password character varying(255) NOT NULL,
    user_name character varying(255) NOT NULL
);
    DROP TABLE public.user_spring;
       public         heap    postgres    false            {           2604    37904 	   autore id    DEFAULT     f   ALTER TABLE ONLY public.autore ALTER COLUMN id SET DEFAULT nextval('public.autore_id_seq'::regclass);
 8   ALTER TABLE public.autore ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            |           2604    37913    categoria id    DEFAULT     l   ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.categoria_id_seq'::regclass);
 ;   ALTER TABLE public.categoria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    212    213            }           2604    37926    libro id    DEFAULT     d   ALTER TABLE ONLY public.libro ALTER COLUMN id SET DEFAULT nextval('public.libro_id_seq'::regclass);
 7   ALTER TABLE public.libro ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            !          0    37901    autore 
   TABLE DATA           3   COPY public.autore (id, cognome, nome) FROM stdin;
    public          postgres    false    211   \4       #          0    37910 	   categoria 
   TABLE DATA           -   COPY public.categoria (id, nome) FROM stdin;
    public          postgres    false    213   ?4       $          0    37916    libri_autori 
   TABLE DATA           ;   COPY public.libri_autori (id_libro, id_autore) FROM stdin;
    public          postgres    false    214   5       %          0    37919    libri_categorie 
   TABLE DATA           A   COPY public.libri_categorie (id_libro, id_categorie) FROM stdin;
    public          postgres    false    215   I5       '          0    37923    libro 
   TABLE DATA           G   COPY public.libro (id, anno_pubblicazione, prezzo, titolo) FROM stdin;
    public          postgres    false    217   ?5       (          0    37929    role 
   TABLE DATA           (   COPY public.role (id, name) FROM stdin;
    public          postgres    false    218   6       )          0    37934 	   user_role 
   TABLE DATA           5   COPY public.user_role (user_id, role_id) FROM stdin;
    public          postgres    false    219   P6       *          0    37939    user_spring 
   TABLE DATA           P   COPY public.user_spring (id, email, is_active, password, user_name) FROM stdin;
    public          postgres    false    220   w6       4           0    0    autore_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.autore_id_seq', 5, true);
          public          postgres    false    210            5           0    0    categoria_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.categoria_id_seq', 6, true);
          public          postgres    false    212            6           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 5, true);
          public          postgres    false    209            7           0    0    libro_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.libro_id_seq', 5, true);
          public          postgres    false    216                       2606    37908    autore autore_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.autore
    ADD CONSTRAINT autore_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.autore DROP CONSTRAINT autore_pkey;
       public            postgres    false    211            ?           2606    37915    categoria categoria_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public            postgres    false    213            ?           2606    37928    libro libro_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.libro DROP CONSTRAINT libro_pkey;
       public            postgres    false    217            ?           2606    37933    role role_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    218            ?           2606    37947 (   user_spring uk_gwvyace83rd0dic7hp38q4bw3 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_spring
    ADD CONSTRAINT uk_gwvyace83rd0dic7hp38q4bw3 UNIQUE (email);
 R   ALTER TABLE ONLY public.user_spring DROP CONSTRAINT uk_gwvyace83rd0dic7hp38q4bw3;
       public            postgres    false    220            ?           2606    37949 (   user_spring uk_kl2hancasrj3bckq2alytq1fm 
   CONSTRAINT     h   ALTER TABLE ONLY public.user_spring
    ADD CONSTRAINT uk_kl2hancasrj3bckq2alytq1fm UNIQUE (user_name);
 R   ALTER TABLE ONLY public.user_spring DROP CONSTRAINT uk_kl2hancasrj3bckq2alytq1fm;
       public            postgres    false    220            ?           2606    37938    user_role user_role_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);
 B   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_pkey;
       public            postgres    false    219    219            ?           2606    37945    user_spring user_spring_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.user_spring
    ADD CONSTRAINT user_spring_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.user_spring DROP CONSTRAINT user_spring_pkey;
       public            postgres    false    220            ?           2606    37965 +   libri_categorie fk6o9n0wwxqmchcs4fur1xqrl60    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_categorie
    ADD CONSTRAINT fk6o9n0wwxqmchcs4fur1xqrl60 FOREIGN KEY (id_libro) REFERENCES public.libro(id);
 U   ALTER TABLE ONLY public.libri_categorie DROP CONSTRAINT fk6o9n0wwxqmchcs4fur1xqrl60;
       public          postgres    false    3203    217    215            ?           2606    37970 %   user_role fka68196081fvovjhkek5m97n3y    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fka68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES public.role(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fka68196081fvovjhkek5m97n3y;
       public          postgres    false    3205    219    218            ?           2606    37960 +   libri_categorie fkbojsvn17cemqdt9wmjpeovwnh    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_categorie
    ADD CONSTRAINT fkbojsvn17cemqdt9wmjpeovwnh FOREIGN KEY (id_categorie) REFERENCES public.categoria(id);
 U   ALTER TABLE ONLY public.libri_categorie DROP CONSTRAINT fkbojsvn17cemqdt9wmjpeovwnh;
       public          postgres    false    3201    213    215            ?           2606    37950 (   libri_autori fkc31odm3gcrhbeowtuu9933mk4    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_autori
    ADD CONSTRAINT fkc31odm3gcrhbeowtuu9933mk4 FOREIGN KEY (id_autore) REFERENCES public.autore(id);
 R   ALTER TABLE ONLY public.libri_autori DROP CONSTRAINT fkc31odm3gcrhbeowtuu9933mk4;
       public          postgres    false    214    211    3199            ?           2606    37955 (   libri_autori fki643j8poheur77ku8rwpmf9fc    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libri_autori
    ADD CONSTRAINT fki643j8poheur77ku8rwpmf9fc FOREIGN KEY (id_libro) REFERENCES public.libro(id);
 R   ALTER TABLE ONLY public.libri_autori DROP CONSTRAINT fki643j8poheur77ku8rwpmf9fc;
       public          postgres    false    217    3203    214            ?           2606    37975 %   user_role fkjnbh64dhuo55gh2jd9d21d245    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkjnbh64dhuo55gh2jd9d21d245 FOREIGN KEY (user_id) REFERENCES public.user_spring(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fkjnbh64dhuo55gh2jd9d21d245;
       public          postgres    false    219    220    3213            !   I   x?3?JMI?+I???L??I?2?H??IL?????M,???2??/.?????L8?3??9?KR?R??b???? ?y?      #   K   x?3?t,+K?+)-J?2?tK?+I,??2?N??u??2???/*?/?2??(???I-?2?t???MM?L?????? ???      $   )   x?3?4?2?4?2?&@ڄ????L?lS ?(???? h?      %   .   x?Ǳ  ???Rb?4????ڴ?RE?ܹe??U4w???      '   ?   x?M̱
?0????)? zik?((uQ]??A??4?????????C??N???'E?4???9篹i)!?`"??????uՙc???????Z??4?:⤻Q??)IeF??.????????9	??"?P(U      (   !   x?3???q?v?2??]|=??b???? t??      )      x?3?4?2?4?2?1z\\\ ?      *   ?   x?U??N?0  ?3}??
??mRĭ?5??xat?n?t????7?????I?????PN?Ik?lX?3?&?$?u?G?e?P?/?b?f??E?H?<Bw?8??F"?2I)?|??އ}?l????Z?"F??z???G?bg??[}????p??8wYz/??8o?&??[????i????l??????#? ???k?X???%???+?"??h?u?t??? ?ZT?     