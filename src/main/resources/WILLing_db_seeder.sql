insert into users (id, email, username, password, first_name, last_name, address1, address2, city, state, zip, phone, allow_sms, is_active)
values (1, 'laura.l.davis.210@gmail.com', 'laura', '$2a$12$TM3fqM2mcn2iFi5r10TOFuJdSpqQREfv4I3uwv7wOQaFRt6NST8uK', 'Laura', 'Davis', '475 Golf Drive', null, 'Denver', 'CO', '35162', '418-746-1418', 0, 1),
       (2, 'aaronsingleterry10@gmail.com', 'aaron', '$2a$12$0k94ewIe4DpkUe9PgiXt0OMU4mRF8OoYGhRW5UEU8OG9IuqBeBkuq', 'Aaron', 'Singleterry', '92 Dakota Parkway', null, 'Oklahoma City', 'OK', '23883', '645-850-3993', 0, 1),
       (3, 'greg.jett25@gmail.com', 'greg', '$2a$12$0k94ewIe4DpkUe9PgiXt0OMU4mRF8OoYGhRW5UEU8OG9IuqBeBkuq', 'Greg', 'Jett', '708 Ridge Oak Road', null, 'Port Washington', 'NY', '55143', '030-676-6461', 0, 1),
       (4, 'george412williams@gmail.com', 'george', '$2a$12$TM3fqM2mcn2iFi5r10TOFuJdSpqQREfv4I3uwv7wOQaFRt6NST8uK', 'George', 'Williams', '2364 Mcbride Center', null, 'Denver', 'CO', '41051', '807-256-1773', 0, 1),
       (5, 'esilly4@delicious.com', 'esilly4', '$2a$12$0k94ewIe4DpkUe9PgiXt0OMU4mRF8OoYGhRW5UEU8OG9IuqBeBkuq', 'Eleanore', 'Silly', '7 Buhler Junction', null, 'Trenton', 'NJ', '60220', '826-448-0664', 0, 1);

insert into albums (id, user_id, title, description, lineage, deadline, is_active)
values (1, 1, 'Shepherd family', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit. Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', 'Grandma Shepherd', '2020-12-03 06:20:23', 1),
       (2, 1, 'Dennis', 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', 'Grandfather', '2020-11-09 20:00:52', 1),
       (3, 1, 'Furniture', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl.', 'Great-Grandpa Joe', '2020-10-04 06:04:25', 1),
       (4, 1, 'Tools', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', 'Uncle Jeff', '2020-12-02 05:18:23', 1),
       (5, 1, 'George', 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo. Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', 'Uncle', '2020-12-09 08:03:10', 1);

insert into invites (id, album_id, email, created_at, updated_at)
values (1, 4, 'mlyvon1@google.fr', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (2, 2, 'mlyvon1@google.fr', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (3, 5, 'gyellop3@businesswire.com', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (4, 1, 'tdebenedetti2@booking.com', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (5, 1, 'bplanque0@dropbox.com', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (6, 3, 'esilly4@delicious.com', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (7, 3, 'joebob@email.com', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (8, 2, 'rayray@email.com', '2020-8-14 05:18:23', '2020-8-14 05:18:23');

insert into album_user (album_id, user_id)
values (4, 2),
       (2, 2),
       (5, 4),
       (1, 3),
       (1, 1),
       (3, 5);

insert into items (id, album_id, title, description, lineage, is_pickup_only, has_shipping_cost, est_shipping_cost, user_id)
values (1, 3, 'Sofa', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl.', null, 1, 0, 0.0, null),
       (2, 5, 'Wrist Watch', 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', null, 0, 1, 4.99, null),
       (3, 5, 'Rocking Chair', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', null, 1, 0, 0.0, 3),
       (4, 3, 'Dresser', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', null, 1, 0, 0.0, 5),
       (5, 1, 'Diamond ring', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', null, 0, 0, 0, 2),
       (6, 2, 'TV', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', 'Grandpa', 1, 0, 0.0, null),
       (7, 4, 'Saw-Zaw', 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', 'Uncle', 1, 0, 0.0, null);

insert into interests (id, user_id, item_id, interest_ranking, will_pay_shipping)
values (1, 3, 3, 5, 0),
       (2, 5, 4, 5, 0),
       (3, 2, 1, 3, 0),
       (4, 2, 2, 4, 0),
       (5, 2, 5, 5, 1);

insert into comments (id, item_id, user_id, comment_id, content, created_at, updated_at)
values (1, 3, 4, null, 'Suspendisse ornare consequat lectus. Fusce consequat.', '2020-8-14 05:18:23', '2020-8-14 05:18:23'),
       (2, 1, 5, null, 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', '2020-8-14 05:18:23', '2020-8-14 05:18:23');

-- insert into images (album_id, item_id, filename, file_type)
-- values (1, 5, '/img/Dishes_pic.jpeg', 'JPEG'),
--        (2, 6, '/img/TV_pic.jpeg', 'JPEG'),
--        (3, 1, '/img/Sofa_pic.jpeg', 'JPEG'),
--        (4, 7, '/img/Saw_Zaw_pic.jpeg', 'JPEG');