CREATE TABLE question (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	content text NOT NULL,
	user VARCHAR(100) NOT NULL,
	creation_date timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE answer (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	content text NOT NULL,
	user VARCHAR(100) NOT NULL,
	creation_date timestamp DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE question_answer (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	id_question INTEGER REFERENCES question (id),
	id_answer INTEGER REFERENCES answer (id)
);
