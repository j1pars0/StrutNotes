/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  james
 * Created: 29 Oct 2025
 */
insert into notes (id, note_name, note_content, create_date, modify_date) values (1, 'Legs Akimbo', 'Limb trial seperation', '25-10-29 20:00:00.000', '25-10-29 20:00:00.000');
insert into notes (id, note_name, note_content, create_date, modify_date) values (2, 'Spider Trial', 'Arachnid crime', '25-10-29 20:00:00.000', '25-10-29 20:00:00.000');
insert into categories (id, category_name, category_desc, create_date, modify_date) values (1, 'Medical', 'Anything to do with health', '25-10-29 20:30:00.000', '25-10-29 20:30:00.000');
insert into categories (id, category_name, category_desc, create_date, modify_date) values (2, 'Nature', 'Outside and upclose', '25-10-29 20:30:00.000', '25-10-29 20:30:00.000');
insert into notes_categories (notes_id, categories_id) values (1,1);
insert into notes_categories (notes_id, categories_id) values (2,2);
alter sequence notes_SEQ restart with 3;
alter sequence categories_SEQ restart with 3;
