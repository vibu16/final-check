-- -----------------------------------------------------
-- Adding Movie in Movie List Item
-- -----------------------------------------------------
INSERT INTO movie_listl
VALUES 
(1, 'Avatar', 2787965087, 'Yes',  '2017/03/15','Science Fiction', 'Yes'),
(2, 'The Avengers', 1518812988, 'Yes', '2017/12/23', 'Superhero', 'No'),
(3, 'Titanic', 2187463944, 'Yes', '2018/08/21', 'Romance', 'No'),
(4, 'Jurassic World', 1671713208, 'No', '2017/07/02','Science Fiction', 'Yes'),
(5, 'Avengers: End Game', 2750760348, 'Yes', '2022/11/02','Superhero', 'Yes');

-- -----------------------------------------------------
-- Displaying Movies in movie_list Table
-- -----------------------------------------------------
SELECT 
mo_title as Title,
mo_box_office as Box_Office,
mo_active as Active,
mo_date_of_launch as Date_Of_Launch,
mo_genre,
mo_has_teaser as Has_Teaser 
FROM movie_list;  


-- -----------------------------------------------------
-- Updating Movie in Movie List Item
-- -----------------------------------------------------

UPDATE movie_list
SET mo_title='Ben 10',mo_box_office=123456789,mo_active='Yes',mo_date_of_launch='2017/07/02',mo_genre='Action',mo_has_teaser='No'
WHERE mo_id = 1;

-- -----------------------------------------------------
-- Displaying Movies in movie_list Table After Update
-- -----------------------------------------------------
SELECT 
mo_title as Title,
mo_box_office as Box_Office,
mo_active as Active,
mo_date_of_launch as Date_Of_Launch,
mo_genre,
mo_has_teaser as Has_Teaser 
FROM movie_list;  

-- -----------------------------------------------------
-- Adding User in User Table
-- -----------------------------------------------------

INSERT INTO user(us_name)
VALUES('Ben'),('Sarath');

-- -----------------------------------------------------
-- Displaying User in User Table
-- -----------------------------------------------------
select
us_id as User_Id,
us_name as User_Name 
from user;

-- -----------------------------------------------------
-- Displaying the movie_list for User
-- -----------------------------------------------------
 
 select  mo_title, mo_box_office, mo_genre, mo_has_teaser from movie_list 
 where mo_active='Yes' and mo_date_of_launch  <= (curdate());
 
-- -----------------------------------------------------
-- Adding Movie into Favorites
-- -----------------------------------------------------

 insert into favorites(ft_us_id,ft_pr_id) values (1,2);
 insert into favorites(ft_us_id,ft_pr_id) values (1,1);
 insert into favorites(ft_us_id,ft_pr_id) values (2,1);
 insert into favorites(ft_us_id,ft_pr_id) values (2,3);

-- -----------------------------------------------------
-- View Favorites
-- -----------------------------------------------------

select 
mo_title as Title,
mo_box_office as Box_Office, 
mo_genre as Genre 
from movie_list 
inner join favorites on ft_pr_id=mo_id
where ft_us_id=2;

-- -----------------------------------------------------
-- View No Of Favorites
-- -----------------------------------------------------
select count(mo_title) as No_of_favorites from movie_list
inner join favorites on ft_pr_id=mo_id
where ft_us_id=2;

-- -----------------------------------------------------
-- Remove Item From Favorites
-- -----------------------------------------------------

delete from favorites where ft_us_id=2 and ft_pr_id=3 limit 1;

-- -----------------------------------------------------
-- View Favorites After Delete
-- -----------------------------------------------------

select 
mo_title as Title,
mo_box_office as Box_Office, 
mo_genre as Genre 
from movie_list 
inner join favorites on ft_pr_id=mo_id
where ft_us_id=2;
-- -----------------------------------------------------
-- View No Of Favorites After Delete
-- -----------------------------------------------------
select count(mo_title) as No_of_favorites from movie_list
inner join favorites on ft_pr_id=mo_id
where ft_us_id=2;