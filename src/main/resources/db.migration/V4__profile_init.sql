insert into profile(name, surname, email, password, role, status, visible)
values ('Alish', 'Alishev', 'hojiakbarandaqulov5@gmail.com', '81dc9bdb52d04dc2036dbd8313ed055', 'ROLE_USER', ' ACTIVE',
        true)
on conflict (id) do nothing;
select setval('profile_id_seq', max(id))
from profile