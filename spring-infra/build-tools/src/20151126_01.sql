ALTER TABLE roles DROP COLUMN IF EXISTS isActive;

CREATE TABLE project(
	id SERIAL PRIMARY KEY,
	name VARCHAR(20),
	start_date DATE,
	end_date DATE
);

CREATE TABLE project_person(
    project_id INT,
	person_id INT,
    PRIMARY KEY(project_id, person_id),
	foreign key(project_id) references project(id) on delete cascade,
	foreign key(person_id) references person(id) on delete cascade
);
