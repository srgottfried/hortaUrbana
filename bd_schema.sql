-- -
-- - ESTRUCTURA
-- -
drop database if exists hortas;
create database if not exists hortas;

use hortas;

drop table if exists usuarios;
create table usuarios (
	id_usuario int unsigned auto_increment not null,
    sobrenome varchar(50) not null,
	contrasinal varchar(50) not null,
    data_rexistro date null,
    
    primary key (id_usuario),
    unique key ak_sobrenome (sobrenome)
    
) engine innodb;

drop table if exists sementes;
create table sementes (
	id_semente int unsigned auto_increment not null,
    nome varchar(50) not null,
    espazo_vital int unsigned not null,
    tempo_crecemento_dias int unsigned not null,
    cantidade_auga_ml_dia double unsigned not null, 
    cantidade_nutrientes_g_dia double unsigned not null,
    cantidade_luz_dia int unsigned not null,
    
    primary key (id_semente),
    unique key ak_nome_semente (nome)
    
) engine innodb;

drop table if exists plantios;
create table plantios (
	id_plantio int unsigned auto_increment not null,
    nome varchar(50) not null,
    data_plantacion date not null,
    num_sementes int unsigned not null,
    usuario int unsigned not null,
    semente int unsigned not null,
    
    primary key (nome, usuario),
    unique key (id_plantio),
    foreign key fk_usuario (usuario) references usuarios(id_usuario)
							on update cascade
                            on delete cascade,
	
    foreign key fk_semente (semente) references sementes(id_semente)
										on update cascade
										on delete restrict
) engine innodb;



create table if not exists historico_insercion_plantios(
						mensaxe varchar(128),
                        data_mensaxe date not null,
                        usuario int unsigned not null,
                        id_err int unsigned not null auto_increment,
                        primary key(id_err),
                        foreign key fk_usr (usuario) references usuarios(id_usuario)
														on update cascade
                                                        on delete cascade
) engine innodb; 

create table if not exists historico_inicios_sesion(
						id_ses int unsigned not null auto_increment,
                        usuario int unsigned not null,
                        data_mensaxe datetime not null,
    
                        primary key(id_ses),
                        foreign key fk_usr (usuario) references usuarios(id_usuario)
														on update cascade
                                                        on delete cascade
) engine innodb; 


  
-- -
-- - PROCEDURES
-- -
delimiter $$
drop procedure if exists insertar_plantio$$
create procedure insertar_plantio(nome_usuario varchar(50), nome_plantio varchar(50), nome_semente varchar(50), num_sementes int unsigned, out retorno int)
	modifies sql data
    begin
		declare mensaxe varchar(128);
		declare exit handler for sqlexception
			begin
				if @id_usuario is null then
					set mensaxe = concat('Usuario ', nome_usuario, ' non atopado.');
				elseif @id_semente is null then
					set mensaxe = concat('Semente ', nome_semente, ' non atopada.');
				else
					set mensaxe = 'Erro na inserción do plantío.';
				end if;
				
				insert into historico_insercion_plantios
					values (mensaxe, current_date(), @id_usuario, null);
				set retorno = 0;
			end;
              
		select id_usuario into @id_usuario
			from usuarios 
            where sobrenome = nome_usuario;
            
        select id_semente into @id_semente
			from sementes
            where nome = nome_semente;
        
        if @id_usuario is null then
			set mensaxe = concat('Usuario ', nome_usuario, ' non atopado.');
            insert into historico_insercion_plantios
			values (mensaxe, current_date(), @id_usuario, null);
			set retorno = 0;
		elseif @id_semente is null then
			set mensaxe = concat('Plantío ', nome_plantio, ' non atopado.');
            insert into historico_insercion_plantios
				values (mensaxe, current_date(), @id_usuario, null);
			set retorno = 0;
        else
			insert into plantios
				values (null, nome_plantio, current_date(), num_sementes,  @id_usuario, @id_semente);  
			set mensaxe = concat('Plantío ', nome_plantio, ' de ', nome_usuario, ' engadido con éxito.');
			set retorno = 1;
            insert into historico_insercion_plantios
				values (mensaxe, current_date(), @id_usuario, null);
		end if;
		
    end$$



drop procedure if exists eliminar_plantio$$
create procedure eliminar_plantio(nome_usuario varchar(50), nome_plantio varchar(50), out retorno int)
	modifies sql data
    begin
		declare mensaxe varchar(128);
		declare exit handler for sqlexception
			begin
				set mensaxe = 'Erro no borrado do plantío.';
				insert into historico_insercion_plantios
					values (mensaxe, current_date(), @id_usuario, null);
				set retorno = 0;
			end;
            
        select id_usuario into @id_usr
			from usuarios
            where sobrenome = nome_usuario;
            
		select id_plantio into @id_plantio
			from plantios
            where usuario = @id_usr
            and nome = nome_plantio;
		
        if @id_plantio is null then
			set mensaxe = "Plantío non atopado";
            set retorno = 0;
		else 
			delete from plantios 
				where id_plantio = @id_plantio;
			set mensaxe ="Plantio eliminado con éxito";
            set retorno = 1;
		end if;
        
        insert into historico_insercion_plantios
			values (mensaxe, current_date(), @id_usr, null);
    end$$
    
    
-- -
-- - DATOS
-- -
delimiter ;    
insert into usuarios
	values 	(null, 'test', 'test', current_date()),
			(null, 'test1', 'test1', current_date()),
			(null, 'test2', 'test2', current_date());
            
insert into sementes
	values	(null, 'tomate', 2, 37, 90, 35, 5),
			(null, 'leituga', 4, 25, 120, 38, 6),
            (null, 'pataca', 3, 22, 87, 31, 4),
            (null, 'fresa', 1, 29, 56, 21, 5),
            (null, 'pemento', 3, 19, 77, 11, 4),
            (null, 'lentella', 1, 26, 67, 31, 3);
          
insert into plantios
	values	(null, "Plantio_1", "2022-05-6", 2, 1, 2),
			(null, "Plantio_2", "2022-05-1", 2, 1, 3),
			(null, "Plantio_3", "2022-05-14", 2, 1, 4);

