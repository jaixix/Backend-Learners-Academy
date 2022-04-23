select c.name, c.section, st.firstName, st.lastName, st.roll_no ,t.firstName, t.lastName, t.emailId, s.name, s.grade_points
from class c, students st, teachers t, subjects s
where t.sub_id=s.id
and t.class_id=c.id
and st.class_id=c.id;