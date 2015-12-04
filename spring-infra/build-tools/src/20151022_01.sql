create table ROLES(
	role_id SERIAL PRIMARY KEY,
	role_type VARCHAR(15)
);

INSERT INTO ROLES (role_type) values ('CEO');
INSERT INTO ROLES (role_type) values ('CFO');
INSERT INTO ROLES (role_type) values ('COO');
INSERT INTO ROLES (role_type) values ('Admin');
INSERT INTO ROLES (role_type) values ('Manager');

create table PERSON_ROLE (
   person_id INT,
   role_id INT,
   PRIMARY KEY(person_id, role_id),
   FOREIGN KEY(person_id) REFERENCES PERSON(id) ON DELETE CASCADE,
   FOREIGN KEY(role_id) REFERENCES ROLES(role_id) ON DELETE CASCADE
);
