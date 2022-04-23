select distinct t.firstName, t.lastName, t.emailId, c.name, c.section, s.name, s.grade_points
from class c, teachers t, subjects s
where c.id=t.class_id
and t.sub_id=s.id;