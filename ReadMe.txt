http://localhost:8000/currency-exchange/from/EUR/to/INR

http://localhost:8100/currency-converter/from/EUR/to/INR/quantity/10

docker build -t exchangeservice .

docker run -d --name e1 -p 8000:8000  exchangeservice


docker build -t conversionservice .

docker run -d --name e2 -p 8100:8100  conversionservice  



# push image to docker hub

  docker login
  docker tag exchangeservice cnsnoida/exchangeservice
  docker push cnsnoida/exchangeservice
  
  docker tag conversionservice cnsnoida/conversionservice
  docker push cnsnoida/conversionservice
  
# AWS ECS

docker.io/cnsnoida/exchangeservice:latest
docker.io/cnsnoida/conversionservice:latest

hard limit- 512
port mapping 8000 8000
