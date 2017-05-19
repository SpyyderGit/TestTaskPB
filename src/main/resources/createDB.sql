DROP DATABASE Shop;COMMIT ;
CREATE DATABASE Shop;
use Shop;
create table product_view(view_id int not null primary key auto_increment,
                          view_name varchar(100) not null);

create table product_type(type_id   int not null primary key auto_increment,
						  type_name varchar(100) not null,
						  fk_id int not null,
              foreign key(fk_id) references product_view(view_id));
create table manufacturer(mr_id int not null primary key auto_increment,
                          mr_name varchar(100) not null);               
create table product(product_id int not null primary key auto_increment,
                     name varchar(100) not null,
                     price numeric(15,2) not null,
                     remark varchar(150) null,
                     sklad char(1) not null,
                     fk_id_mr int not null,
                     fk_id_type int not null,
                     foreign key(fk_id_mr) references manufacturer(mr_id),
                     foreign key(fk_id_type) references product_type(type_id));
commit;
                     