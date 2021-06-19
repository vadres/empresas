CREATE TABLE tb_company (
	id_company SERIAL PRIMARY KEY,
	vl_name CHARACTER VARYING(50) NOT NULL,
	balance NUMERIC(10,2) DEFAULT 0.0,
	
	dt_created_at timestamp WITHOUT time ZONE,
	dt_updated_at timestamp WITHOUT time ZONE
);


CREATE TABLE tb_employee (
	id_employee SERIAL PRIMARY KEY,
	vl_name CHARACTER VARYING(50) NOT NULL,
	id_company INTEGER NOT NULL, 
	balance NUMERIC(10,2) DEFAULT 0.0,
	salary NUMERIC(10,2) DEFAULT 0.0, 
	
	dt_created_at timestamp WITHOUT time ZONE,
	dt_updated_at timestamp WITHOUT time ZONE
);

ALTER TABLE tb_employee ADD CONSTRAINT employee_company_fk 
FOREIGN KEY (id_company) REFERENCES tb_company;