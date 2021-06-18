---------------------- USUARIO -------------------------
CREATE TABLE tb_user (
	id_user SERIAL PRIMARY KEY,
	vl_login CHARACTER VARYING(50) NOT NULL,
	vl_password CHARACTER VARYING(255) NOT NULL,
	dt_created_at timestamp WITHOUT time ZONE,
	dt_updated_at timestamp WITHOUT time ZONE
);
