CREATE TABLE kotlin_crud.PURCHASE (
	  id UUID DEFAULT GEN_RANDOM_UUID() PRIMARY KEY
	, total_value NUMERIC NOT NULL
	, total_products INT NOT NULL
	, purchased_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);