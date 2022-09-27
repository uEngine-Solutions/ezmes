```
http :8081/workOrders ordrAmnt=2000 
   http :8082/productions orderId=1
   http PUT "http://localhost:8082/productions/1/complete" itemCount=700
   http :8084/dashboards
   http :8082/productions
```