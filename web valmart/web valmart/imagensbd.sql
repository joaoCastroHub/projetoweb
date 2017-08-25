CREATE DATABASE imagens;
use imagens;

create table imagensbd(
	idImagem int auto_increment primary key,
	posy double not null,
	posx double not null,
	img longblob not null
);

create table imagensProblematicas(
	idImagemP int auto_increment primary key,
	idImagemFk int not null
);

alter table imagensProblematicas
	add foreign key (idImagemFk)
		REFERENCES imagensbd(idimagem);

alter table imagensbd add column imagemConvertida boolean;
update imagensbd set imagemConvertida = 0;