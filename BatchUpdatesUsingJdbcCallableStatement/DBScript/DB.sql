CREATE TABLE `employee_table` (
  `employee_id` int(11) NOT NULL auto_increment,
  `employee_name` varchar(60) NOT NULL,
  `email` varchar(45) NOT NULL,
  `salary` double default NULL,
  `date_of_joining` datetime default NULL,
  `bonus` decimal(10,0) default NULL,
  PRIMARY KEY  (`employee_id`)
) ;

DELIMITER $$

CREATE PROCEDURE `updateSalById`(IN sal DOUBLE,IN empId INT)
BEGIN
UPDATE employee_table set salary=sal WHERE employee_id=empId;
END