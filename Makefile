all: build-docker-image run-docker-image

build-docker-image:
	docker build -t kotlincrud-mongodb:latest .

run-docker-image:
	cd docker; \
	docker-compose up kotlincrud-mongodb
