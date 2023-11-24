INSERT INTO photos (title, description, url, created_at, visible)VALUES('Gatto', 'Foto di un gatto', 'https://images.unsplash.com/photo-1697724006911-643513f26694?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDF8SnBnNktpZGwtSGt8fGVufDB8fHx8fA%3D%3D', '2023-11-23 11:40:00', true);
INSERT INTO photos (title, description, url, created_at, visible)VALUES('Gufo', 'Foto di un gufo', 'https://images.unsplash.com/photo-1699488169278-68f988a8b876?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDd8SnBnNktpZGwtSGt8fGVufDB8fHx8fA%3D%3D', '2023-11-23 11:40:00', true);
INSERT INTO photos (title, description, url, created_at, visible)VALUES('Cigno', 'Foto di un cigno', 'https://images.unsplash.com/photo-1700324022450-f143742da6c1?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHx0b3BpYy1mZWVkfDh8SnBnNktpZGwtSGt8fGVufDB8fHx8fA%3D%3D', '2023-11-23 11:40:00', false);
INSERT INTO categories(name)VALUES("felini")
INSERT INTO categories(name)VALUES("volatili")
INSERT INTO photos_categories(photos_id, categories_id)VALUES(1,1)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(2,2)
INSERT INTO photos_categories(photos_id, categories_id)VALUES(3,2)
INSERT INTO users (email, first_name, last_name, password, registered_at)VALUES('mario@mail.com', 'Mario', 'Rossi', '{noop}prova', '2023-11-24 10:21')
INSERT INTO users (email, first_name, last_name, password, registered_at) VALUES('enrica@email.com', 'Enrica', 'Verdi','{noop}prova', '2023-11-20 15:43');

INSERT INTO roles (id, name) VALUES(1, 'ADMIN');
INSERT INTO users_roles (user_id, roles_id) VALUES(1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES(2, 1);