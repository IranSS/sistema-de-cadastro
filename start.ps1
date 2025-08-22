docker-compose down

# build a imagem do backend
docker build -t sistema-spring:latest ./backend

# build a imagem do frontend
docker build -t sistema-cadastro-frontend:latest ./frontend

# start environment
docker-compose up --build --force-recreate --remove-orphans