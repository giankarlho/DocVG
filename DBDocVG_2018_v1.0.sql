create database DocVG
go
use
DocVG
go
create table Empresa(
    IDEMP int identity(1,1) primary key,
	RAZEMP	varchar(30),
	COMEMP	varchar(40),
    RUCEMP	char(11),
    ESTEMP	char(1),
    DIREMP	varchar(40),
    CODUBI	char(6),
    TELEMP	varchar(20)
)
go
create table Persona(
     IDPER	int identity(1,1) primary key,
     NOMPER	varchar(40),
     APEPER	varchar(60),
     CELPER	varchar(20),
     CORPER	varchar(30),
     DNIPER	char(8),
	 TIPPER	char(1),		-- ALUMNO, PROFESOR O EXTERNO
     ESTPER	char(1),
     DIRPER	varchar(40),
     CODUBI	char(6),
	 TITPER	varchar(4)		--Sr. Ing. Dr.
)
go
create table detEmpresa(
	idDEMP	int identity(1,1) primary key,
	IDPER	int,
	CARPER	varchar(40),
	ESTASI	char(1),
	FECASI	date
)


select * from empresa
select * from Persona
select * from detEmpresa

