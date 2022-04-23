select distinct s.firstName, s.lastName, s.roll_no, c.name, c.section
from students s join class c on s.class_id=c.id;