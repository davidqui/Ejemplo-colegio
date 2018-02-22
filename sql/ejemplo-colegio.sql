-- -----------------------------------------------------------------------------
-- TABLA: ESTADO_ESTUDIANTE
-- -----------------------------------------------------------------------------
CREATE TABLE ESTADO_ESTUDIANTE (
    CODIGO  VARCHAR2(2)     NOT NULL,
    NOMBRE  VARCHAR2(20)    NOT NULL,
    PRIMARY KEY (CODIGO)
);

CREATE UNIQUE INDEX ESTADO_ESTUDIANTE_UDX ON ESTADO_ESTUDIANTE (NOMBRE);

INSERT INTO ESTADO_ESTUDIANTE (CODIGO, NOMBRE) VALUES ('A','ACTIVO');
INSERT INTO ESTADO_ESTUDIANTE (CODIGO, NOMBRE) VALUES ('R','RETIRADO');

-- -----------------------------------------------------------------------------
-- TABLA: TIPO_DOCUMENTO
-- -----------------------------------------------------------------------------
CREATE TABLE TIPO_DOCUMENTO (
    CODIGO  VARCHAR2(2)     NOT NULL,
    NOMBRE  VARCHAR2(50)    NOT NULL,
    PRIMARY KEY (CODIGO)
);

CREATE UNIQUE INDEX TIPO_DOCUMENTO_UDX ON TIPO_DOCUMENTO (NOMBRE);

INSERT INTO TIPO_DOCUMENTO (CODIGO, NOMBRE) VALUES ('CC','CEDULA CIUDADANIA');
INSERT INTO TIPO_DOCUMENTO (CODIGO, NOMBRE) VALUES ('TI','TARJETA DE IDENTIDAD');

-- -----------------------------------------------------------------------------
-- TABLA: JORNADA
-- -----------------------------------------------------------------------------
CREATE TABLE JORNADA (
    CODIGO  VARCHAR2(2)     NOT NULL,
    NOMBRE  VARCHAR2(20)    NOT NULL,
    PRIMARY KEY (CODIGO)
);

CREATE UNIQUE INDEX JORNADA_UDX ON JORNADA (NOMBRE);

INSERT INTO JORNADA (CODIGO, NOMBRE) VALUES ('D','DUIRNA');
INSERT INTO JORNADA (CODIGO, NOMBRE) VALUES ('N','NOCTURNA');

-- -----------------------------------------------------------------------------
-- TABLA: ESTADO_PROFESOR
-- -----------------------------------------------------------------------------
CREATE TABLE ESTADO_PROFESOR (
    CODIGO  VARCHAR2(2)     NOT NULL,
    NOMBRE  VARCHAR2(20)    NOT NULL,
    PRIMARY KEY (CODIGO)
);

CREATE UNIQUE INDEX ESTADO_PROFESOR_UDX ON ESTADO_PROFESOR (NOMBRE);

INSERT INTO ESTADO_PROFESOR (CODIGO, NOMBRE) VALUES ('A','ACTIVO');
INSERT INTO ESTADO_PROFESOR (CODIGO, NOMBRE) VALUES ('R','RETIRADO');
INSERT INTO ESTADO_PROFESOR (CODIGO, NOMBRE) VALUES ('V','VACACIONES');

-- -----------------------------------------------------------------------------
-- TABLA: MATERIA
-- -----------------------------------------------------------------------------
CREATE TABLE MATERIA (
    ID                  NUMBER(38)      NOT NULL,
    NOMBRE              VARCHAR2(50)    NOT NULL,
    INTENSIDAD_HORARIA  NUMBER(10)      NOT NULL,
    PRIMARY KEY (ID)
);

CREATE SEQUENCE SQ_MATERIA;

-- -----------------------------------------------------------------------------
-- TABLA: ACUDIENTE
-- -----------------------------------------------------------------------------
CREATE TABLE ACUDIENTE (
    NUM_DOCUMENTO   VARCHAR2(15)    NOT NULL,
    TIPO_DOCUMENTO  VARCHAR2(2)     NOT NULL,
    NOMBRE          VARCHAR2(50)    NOT NULL,
    APELLIDO        VARCHAR2(60)    NOT NULL,
    PRIMARY KEY (NUM_DOCUMENTO),
    CONSTRAINT ACUDIENTE_TIPO_DOCUMENTO_FK FOREIGN KEY (TIPO_DOCUMENTO) REFERENCES TIPO_DOCUMENTO (CODIGO)    
);

-- -----------------------------------------------------------------------------
-- TABLA: ESTUDIANTE
-- -----------------------------------------------------------------------------
CREATE TABLE ESTUDIANTE (
    NUM_DOCUMENTO       VARCHAR2(15)    NOT NULL,
    TIPO_DOCUMENTO      VARCHAR2(2)     NOT NULL,
    ESTADO_ESTUDIANTE   VARCHAR2(2)     NOT NULL,
    NOMBRE              VARCHAR2(50)    NOT NULL,
    APELLIDO            VARCHAR2(60)    NOT NULL,
    FECHA_NACIMIENTO    DATE            NOT NULL,
    ACUDIENTE           VARCHAR2(15)    NOT NULL,
    PRIMARY KEY (NUM_DOCUMENTO),    
    CONSTRAINT ESTUDIANTE_TIPO_DOC_FK   FOREIGN KEY (TIPO_DOCUMENTO)    REFERENCES TIPO_DOCUMENTO (CODIGO),
    CONSTRAINT ESTUDIANTE_ESTADO_FK     FOREIGN KEY (ESTADO_ESTUDIANTE) REFERENCES ESTADO_ESTUDIANTE (CODIGO),
    CONSTRAINT ESTUDIANTE_ACUDIENTE_FK  FOREIGN KEY (ACUDIENTE)         REFERENCES ACUDIENTE (NUM_DOCUMENTO)    
);

-- -----------------------------------------------------------------------------
-- TABLA: PROFESOR
-- -----------------------------------------------------------------------------
CREATE TABLE PROFESOR (
    NUM_DOCUMENTO       VARCHAR2(15)    NOT NULL,
    TIPO_DOCUMENTO      VARCHAR2(2)     NOT NULL,
    ESTADO_PROFESOR     VARCHAR2(2)     NOT NULL,
    NOMBRE              VARCHAR2(50)    NOT NULL,
    APELLIDOS           VARCHAR2(60)    NOT NULL,
    TITULO_ACADEMICO    VARCHAR2(50)    NOT NULL,
    PRIMARY KEY (NUM_DOCUMENTO),    
    CONSTRAINT PROFESOR_TIPO_DOCUMENTO_FK   FOREIGN KEY (TIPO_DOCUMENTO)    REFERENCES TIPO_DOCUMENTO (CODIGO),
    CONSTRAINT PROFESOR_ESTADO_PROFESOR_FK  FOREIGN KEY (ESTADO_PROFESOR)   REFERENCES ESTADO_PROFESOR (CODIGO)    
);

-- -----------------------------------------------------------------------------
-- TABLA: CURSO
-- -----------------------------------------------------------------------------
CREATE TABLE CURSO (
    ID                  NUMBER(38)      NOT NULL,
    NOMENCLATURA        VARCHAR2(2)     NOT NULL,
    GRADO               NUMBER(10)      NOT NULL,
    PROFESOR_DIRECTOR   VARCHAR2(15)    NOT NULL,
    PRIMARY KEY (ID),    
    CONSTRAINT CURSO_PROFESOR_DIRECTOR_FK   FOREIGN KEY (PROFESOR_DIRECTOR) REFERENCES PROFESOR (NUM_DOCUMENTO)        
);

CREATE INDEX CURSO_NOMENCLATURA_IDX ON CURSO (NOMENCLATURA);
CREATE INDEX CURSO_GRADO_IDX        ON CURSO (GRADO);

CREATE SEQUENCE SQ_CURSO;

-- -----------------------------------------------------------------------------
-- TABLA: MATRICULA
-- -----------------------------------------------------------------------------
CREATE TABLE MATRICULA (
    ID          NUMBER(38)      NOT NULL,
    ESTUDIANTE  VARCHAR2(15)    NOT NULL,
    CURSO       NUMBER(38)      NOT NULL,
    JORNADA     VARCHAR2(2)     NOT NULL,
    FECHA       DATE            NOT NULL,
    ANYO        NUMBER(10)      NOT NULL,
    VALOR       NUMBER(10)      NOT NULL,
    PRIMARY KEY (ID),    
    CONSTRAINT MATRICULA_ESTUDIANTE_FK  FOREIGN KEY (ESTUDIANTE)    REFERENCES ESTUDIANTE (NUM_DOCUMENTO),
    CONSTRAINT MATRICULA_CURSO_FK       FOREIGN KEY (CURSO)         REFERENCES CURSO (ID),
    CONSTRAINT MATRICULA_JORNADA_FK     FOREIGN KEY (JORNADA)       REFERENCES JORNADA (CODIGO)    
);

CREATE INDEX MATRICULA_ANYO_IDX ON MATRICULA (ANYO);

CREATE SEQUENCE SQ_MATRICULA;

-- -----------------------------------------------------------------------------
-- TABLA: ASIGNACION_ACADEMICA
-- -----------------------------------------------------------------------------
CREATE TABLE ASIGNACION_ACADEMICA (
    ID          NUMBER(38)      NOT NULL,
    MATERIA     NUMBER(38)      NOT NULL,
    MATRICULA   NUMBER(38)      NOT NULL,
    PROFESOR    VARCHAR2(15)    NOT NULL,
    NOTA_1      NUMBER(10,2),
    NOTA_2      NUMBER(10,2),
    NOTA_3      NUMBER(10,2),
    NOTA_4      NUMBER(10,2),
    NOTA_FINAL  NUMBER(10,2),
    PRIMARY KEY (ID),    
    CONSTRAINT ASIG_ACADEMICA_MATERIA_FK    FOREIGN KEY (MATERIA)   REFERENCES MATERIA (ID),
    CONSTRAINT ASIG_ACADEMICA_MATRICULA_FK  FOREIGN KEY (MATRICULA) REFERENCES MATRICULA (ID),
    CONSTRAINT ASIG_ACADEMICA_PROFESOR_FK   FOREIGN KEY (PROFESOR)  REFERENCES PROFESOR (NUM_DOCUMENTO)    
);

CREATE SEQUENCE SQ_ASIGNACION_ACADEMICA;
