-- Utenti
INSERT INTO users (email, first_name, last_name, password, registered_at) VALUES('giulia@mail.com', 'Giulia', 'Bianchi', '{noop}prova', '2023-11-25 09:30');

INSERT INTO users (email, first_name, last_name, password, registered_at) VALUES('luca@email.com', 'Luca', 'Neri', '{noop}prova', '2023-11-25 10:45');
INSERT INTO users (email, first_name, last_name, password, registered_at) VALUES('francesca@mail.com', 'Francesca', 'Gialli', '{noop}prova', '2023-11-25 11:20');
INSERT INTO users (email, first_name, last_name, password, registered_at) VALUES('superadmin@mail.com', 'Admin', 'Admin', '{noop}admin', '2023-11-27 09:20');

INSERT INTO photos (title, description, url, created_at, visible, user_id)VALUES('Cascata', 'Una cascata nel mezzo di una lussureggiante foresta verde', 'https://images.unsplash.com/photo-1494472155656-f34e81b17ddc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Y2FzY2F0YXxlbnwwfHwwfHx8MA%3D%3D', '2023-11-23 11:40:00', true, 1);
INSERT INTO photos (title, description, url, created_at, visible, user_id)VALUES('Gufo', 'Foto di un gufo', 'https://images.unsplash.com/photo-1543549789-add7e987e50a?q=80&w=1965&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-23 11:40:00', true, 1);
INSERT INTO photos (title, description, url, created_at, visible, user_id)VALUES('Cigno', 'Foto di un cigno', 'https://images.unsplash.com/photo-1588485256313-f021c74731f1?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-23 11:40:00', false, 2);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Montagna', 'Panorama di montagna', 'https://images.unsplash.com/photo-1554629947-334ff61d85dc?q=80&w=1936&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 09:40:00', true, 3);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Spiaggia', 'Scena di spiaggia al tramonto', 'https://images.unsplash.com/photo-1554629947-334ff61d85dc?q=80&w=1936&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 10:00:00', true, 3);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Città', 'Veduta della città di notte', 'https://images.unsplash.com/photo-1556951348-de7d29704984?q=80&w=1964&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 11:20:00', false, 2);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Città di notte', 'Contesto Urbano', 'https://images.unsplash.com/photo-1519501025264-65ba15a82390?q=80&w=1964&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 12:45:00', true, 3);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Tramonto','Veduta di un tramonto', 'https://images.unsplash.com/photo-1494548162494-384bba4ab999?q=80&w=2080&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 13:30:00', true, 1);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Foresta', 'Veduta di una foresta', 'https://images.unsplash.com/photo-1440342359743-84fcb8c21f21?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 14:15:00', true, 2);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Architettura', 'Dettaglio di architettura moderna', 'https://plus.unsplash.com/premium_photo-1673379471916-9caf7c64c7be?q=80&w=1936&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 15:00:00', false, 2);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Montagna Innevata', 'Panorama di montagna con neve', 'https://images.unsplash.com/photo-1489363855452-7327672b1608?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 16:30:00', true, 1);
INSERT INTO photos (title, description, url, created_at, visible, user_id) VALUES('Animali Selvatici', 'Incontro con animali selvatici', 'https://images.unsplash.com/photo-1557008075-7f2c5efa4cfd?q=80&w=1994&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D', '2023-11-25 17:45:00', true, 1);

INSERT INTO categories(name)VALUES("Animali")
INSERT INTO categories(name)VALUES("Paesaggi")
INSERT INTO categories(name)VALUES("Città")

INSERT INTO photos_categories(photos_id, categories_id)VALUES(1,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(2,1)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(3,1)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(4,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(5,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(6,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(7,3)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(8,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(9,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(10,3)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(11,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(12,1)

INSERT INTO roles (id, name) VALUES(1, 'ADMIN');
INSERT INTO roles (id, name) VALUES(2, 'SUPERADMIN');
INSERT INTO users_roles (user_id, roles_id) VALUES(4, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(3, 1);

INSERT INTO messages (email, message, created_at)VALUES('fabio@mail.com', 'Buongiorno, la contatto in merito al preventivo di cui abbiamo discusso al telefono.', '2023-11-24 15:55')
INSERT INTO messages (email, message, created_at)VALUES('laura@mail.com', 'Buongiorno, la contatto in merito al preventivo di cui abbiamo discusso al telefono.', '2023-11-24 15:55')
INSERT INTO messages (email, message, created_at)VALUES('sonia@mail.com', 'Buongiorno, la contatto in merito al preventivo di cui abbiamo discusso al telefono.', '2023-11-24 15:55')